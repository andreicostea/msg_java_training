package msg.notification.entity.dao;

import msg.notification.entity.NotificationEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The DAO for the Notification Entities.
 *
 * @author msg systems AG; UserEntity Name.
 * @since 19.1.2
 */
@Stateless
public class NotificationDAO {
    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;

    /**
     * Creates a notification based on the input Entity.
     *
     * @param notificationEntity the input entity.
     */
    public void createNotification(NotificationEntity notificationEntity){
        this.em.persist(notificationEntity);
    }

}
