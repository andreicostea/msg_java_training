package msg.role.entity;

import edu.msg.ro.persistence.entity.BaseEntity;

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
@Table(name="roles")
@NamedQueries({
        @NamedQuery(name="getPermissions",
            query="select r.permissions from Role r where r.type=:type "),
        @NamedQuery(name= Role.QUERY_GET_ROLES_BY_TYPE_LIST,
            query= "select r from Role r "
                + "where r.type in :" + Role.INPUT_TYPE_LIST )})
public class Role extends BaseEntity<Long> {

    public static final String QUERY_GET_ROLES_BY_TYPE_LIST = "getRolesByTypeList";
    public static final String INPUT_TYPE_LIST = "type";
    @Column(name="type",nullable = false)
    private String type;

    @ManyToMany(cascade= CascadeType.PERSIST)
    @JoinTable(name="permissions_roles",
            joinColumns = @JoinColumn(name="role_id", referencedColumnName = "id",nullable = false),
            inverseJoinColumns = @JoinColumn(name="permission_id",referencedColumnName = "id",nullable = false)
    )
    private List<Permission> permissions=new ArrayList<>();


    public Role() {
    }

    public Role(String type, List<Permission> permissions) {
        this.type = type;
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
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
        Role role = (Role) o;
        return Objects.equals(type, role.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }


}
