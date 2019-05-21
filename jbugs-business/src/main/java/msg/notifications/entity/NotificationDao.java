package msg.notifications.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * The DAO for the Notification Entities.
 *
 * @author msg systems AG; UserEntity Name.
 * @since 19.1.2
 */
@Stateless
public class NotificationDao {
    @PersistenceContext(unitName = "jbugs-persistence")
    private EntityManager em;

    /**
     * Creates a notification based on the input Entity.
     *
     * @param notificationEntity the input entity.
     */
    public void createNotification(NotificationEntity notificationEntity){
        this.em.persist(notificationEntity);
    }

    public List<NotificationEntity> getAllById(long id) {
        return em.createNamedQuery(NotificationEntity.NOTIFICATION_FIND_USER_ID, NotificationEntity.class)
                .setParameter("id", id)
                .getResultList();

    }
}


