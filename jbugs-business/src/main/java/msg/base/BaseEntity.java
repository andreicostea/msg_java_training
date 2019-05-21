package msg.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@MappedSuperclass
public class BaseEntity<T extends Serializable> implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private T id;

    public BaseEntity() {
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
