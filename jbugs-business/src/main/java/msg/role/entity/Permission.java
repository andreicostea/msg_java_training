package msg.role.entity;

import edu.msg.ro.persistence.entity.BaseEntity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The permission entity.
 *
 * @author msg systems AG;
 * @since 19.1.2
 */
@Entity
@Table(name="permission")
public class Permission extends BaseEntity<Long> {

    @Column(name="type", nullable = false)
    private String type;
    @Column(name="description",nullable = false)
    private String description;


    public Permission() {
    }

    public Permission(String type, String description) {
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
        Permission that = (Permission) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, description);
    }
}
