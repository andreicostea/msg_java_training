package msg.role.entity;

import msg.base.BaseEntity;
import msg.permission.PermissionEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Roles Entity.
 *
 * @author msg systems AG;
 * @since 19.1.2
 */
@Entity
@Table(name = "roles")
@Cacheable(value = false)
@NamedQueries({
        @NamedQuery(name = RoleEntity.GET_PERMISSIONSANDROLES,
                query = "select r from RoleEntity r"),
        @NamedQuery(name = RoleEntity.GET_PERMISSIONS,
                query = "select r.permissions from RoleEntity r where r.id in :" + RoleEntity.ID_PERM),
        @NamedQuery(name = RoleEntity.QUERY_GET_ROLES_BY_TYPE_LIST,
                query = "select r from RoleEntity r " + "where r.type in :" + RoleEntity.INPUT_TYPE_LIST),
        @NamedQuery(name = RoleEntity.GET_ALL_ROLES_TYPE,
                query = "SELECT r.type from RoleEntity r "),
        @NamedQuery(name = RoleEntity.QUERY_GET_ROLE_BY_ID,
                query = "select r from RoleEntity r "
                        + "where r.id = :" + RoleEntity.INPUT_ID)})
public class RoleEntity extends BaseEntity<Long> {

    public static final String QUERY_GET_ROLE_BY_ID = "getRoleById";
    public static final String QUERY_GET_ROLES_BY_TYPE_LIST = "getRolesByTypeList";
    public static final String INPUT_TYPE_LIST = "type";
    public static final String INPUT_ID = "id";
    public static final String ID_PERM = "id";
    public static final String GET_ALL_ROLES_TYPE = "getAllRolesType";
    public static final String GET_PERMISSIONS = "getPermissions";
    public static final String GET_PERMISSIONSANDROLES = "getAllRolesAndPermissions";
    @Column(name = "type", nullable = false)
    private String type;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "roles_permissions",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id", nullable = false)
    )
    private List<PermissionEntity> permissions = new ArrayList<>();


    public RoleEntity() {
    }

    public RoleEntity(String type, List<PermissionEntity> permissions) {
        this.type = type;
        this.permissions = permissions;
    }

    public List<PermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionEntity> permissions) {
        this.permissions = permissions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity role = (RoleEntity) o;
        return Objects.equals(type, role.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }


}
