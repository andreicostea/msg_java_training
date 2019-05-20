package msg.notifications.boundary;

import msg.notifications.boundary.notificationParams.NotificationParams;
import msg.notifications.control.NotificationControl;
import msg.notifications.entity.NotificationType;

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
     * @param params the parameters for the notification type.
     */
    public void createNotification(final NotificationType notificationType, final NotificationParams params){
        this.notificationControl.createNotification(notificationType, params);
    }
}
