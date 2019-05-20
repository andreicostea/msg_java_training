package msg.notifications.control;

import msg.exeptions.BusinessException;
import msg.notifications.MessageCatalog;
import msg.notifications.boundary.notificationParams.NotificationParams;
import msg.notifications.boundary.notificationParams.NotificationParamsUserChanges;
import msg.notifications.boundary.notificationParams.NotificationParamsWelcomeUser;
import msg.notifications.entity.NotificationDao;
import msg.notifications.entity.NotificationEntity;
import msg.notifications.entity.NotificationType;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Control operations for all the Notification related operations.
 *
 * @author msg systems AG;
 * @since 19.1.2
 */
@Stateless
public class NotificationControl {
    @EJB
    private NotificationDao notificationDao;

    private static final String SERVER_ADDRESS = "http://" + System.getProperty("myServerAddress");

    /**
     * Creates a notification based on the input {@link NotificationType} and {@link NotificationParams}.
     *
     * @param notificationType the type of the notification.
     * @param params the parameters for the notification type.
     */
    public void createNotification(final NotificationType notificationType, final NotificationParams params){
        switch(notificationType){
            case WELCOME_NEW_USER: this.createWelcomeUserNotification(params);
                break;
            case USER_UPDATED: this.createUserUpdateNotification(params);
                break;
        }
    }

    /**
     * Creates the notifications for the {@link NotificationType#WELCOME_NEW_USER} message type.
     *
     * @param params the input params.
     */
    private void createWelcomeUserNotification(final NotificationParams params){
        if (!(params instanceof NotificationParamsWelcomeUser)){
            throw new BusinessException(MessageCatalog.MESSAGE_PARAMS_AND_TYPE_ARE_INCOMPATIBLE);
        }

        final NotificationParamsWelcomeUser messageParams = (NotificationParamsWelcomeUser) params;

        final NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setMessage(
                NotificationMessageCatalog.getFullMessageForWelcomeNewUser(
                        messageParams.getName(), messageParams.getUsername()));
        notificationEntity.setNotificationType(NotificationType.WELCOME_NEW_USER);
        //todo update with correct link when routing is available
        notificationEntity.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntity.setDate(new Date());
        this.notificationDao.createNotification(notificationEntity);
    }

    /**
     * Creates the notifications for the {@link NotificationType#USER_UPDATED} message type.
     *
     * @param params the input params.
     */
    private void createUserUpdateNotification(final NotificationParams params){
        if (!(params instanceof NotificationParamsUserChanges)){
            throw new BusinessException(MessageCatalog.MESSAGE_PARAMS_AND_TYPE_ARE_INCOMPATIBLE);
        }

        final NotificationParamsUserChanges messageParams = (NotificationParamsUserChanges) params;
        this.createWelcomeUpdateTarget(messageParams);
        this.createWelcomeUpdateSource(messageParams);
    }

    private void createWelcomeUpdateTarget( final NotificationParamsUserChanges messageParams) {
        final NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setMessage( NotificationMessageCatalog
                .getFullMessageForUserUpdatedTarget(messageParams.getUsernameSource(),
                        messageParams.getUsernameTarget(), messageParams.getData()));
        notificationEntity.setNotificationType(NotificationType.USER_UPDATED);
        //todo update with correct link when routing is available
        notificationEntity.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntity.setDate(new Date());
        this.notificationDao.createNotification(notificationEntity);

    }
    private void createWelcomeUpdateSource( final NotificationParamsUserChanges messageParams) {
        final NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setMessage(
                NotificationMessageCatalog.getFullMessageForUserUpdatedSource(
                        messageParams.getUsernameSource(), messageParams.getData()));
        notificationEntity.setNotificationType(NotificationType.USER_UPDATED);
        //todo update with correct link when routing is available
        notificationEntity.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntity.setDate(new Date());
        this.notificationDao.createNotification(notificationEntity);

    }
}
