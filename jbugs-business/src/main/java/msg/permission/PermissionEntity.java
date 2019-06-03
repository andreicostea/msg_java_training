package msg.permission;

import msg.base.BaseEntity;
import msg.role.entity.RoleEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The permission entity.
 *
 * @author msg systems AG;
 * @since 19.1.2
 */
@Entity
@Table(name = "permissions")
@NamedQueries({
        @NamedQuery(name = PermissionEntity.QUERY_GET_PERMISSION_BY_TYPE_LIST,
                query = "select p from PermissionEntity p "
                        + "where p.type in :" + PermissionEntity.INPUT_TYPE_LIST),
        @NamedQuery(name = PermissionEntity.PERMISSION_FIND_BY_ID,
                query = "select p from PermissionEntity p where p.id= :" + PermissionEntity.INPUT_ID),
        @NamedQuery(name = PermissionEntity.PERMISSION_FIND_ALL, query = "SELECT p from PermissionEntity p"),
})
public class PermissionEntity extends BaseEntity<Long> {
    public static final String INPUT_ID = "id";
    public static final String PERMISSION_FIND_BY_ID = "PermissionEntity.findById";
    public static final String QUERY_GET_PERMISSION_BY_TYPE_LIST = "getPermissionByTypeList";
    public static final String INPUT_TYPE_LIST = "type";
    public static final String PERMISSION_FIND_ALL = "PermissionEntity.findAll";
    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "roles_permissions",
            joinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    )
    private List<RoleEntity> roles = new ArrayList<>();


    public PermissionEntity() {
    }

    public PermissionEntity(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionEntity that = (PermissionEntity) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, description);
    }
}
