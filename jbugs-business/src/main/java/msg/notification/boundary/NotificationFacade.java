package msg.notification.boundary;

import msg.notification.boundary.notificationParams.NotificationParams;
import msg.notification.control.NotificationControl;
import msg.notification.entity.NotificationType;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Facade for all operations on Notifications.
 *
 * @author msg systems AG; UserEntity Name.
 * @since 19.1.2
 */
@Stateless
public class NotificationFacade {

    @EJB
    private NotificationControl notificationControl;

    /**
     * Creates a notification based on the input {@link NotificationType} and {@link NotificationParams}.
     *
     * @param notificationType the type of the notification.
     * @param params           the parameters for the notification type.
     */
    public void createNotification(final NotificationType notificationType, final NotificationParams params, final long... id) {
        this.notificationControl.createNotification(notificationType, params, id);
    }

    public Object getAllNotificationById(long id) {
        return this.notificationControl.getNotificationsById(id);
    }

    public Object getWelcomeNotificationById(long id) {
        return this.notificationControl.getWelcomeNotificationById(id);
    }

    public Object getUpdateNotificationById(long id) {
        return this.notificationControl.getUpdateNotificationById(id);
    }

    public Object getDeleteNotificationById(long id) {
        return this.notificationControl.getDeleteNotificationById(id);
    }
}
