package msg.notification.control;

import msg.exceptions.BusinessException;
import msg.notification.MessageCatalog;
import msg.notification.boundary.notificationParams.NotificationParams;
import msg.notification.boundary.notificationParams.NotificationParamsUserChanges;
import msg.notification.boundary.notificationParams.NotificationParamsWelcomeUser;
import msg.notification.entity.NotificationEntity;
import msg.notification.entity.NotificationType;
import msg.notification.entity.dao.NotificationDAO;
import msg.notification.entity.dto.NotificationConverter;
import msg.notification.entity.dto.NotificationOutputDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Control operations for all the Notification related operations.
 *
 * @author msg systems AG;
 * @since 19.1.2
 */
@Stateless
public class NotificationControl {
    @EJB
    private NotificationDAO notificationDao;

    @EJB
    private NotificationConverter notificationConverter;

    private static final String SERVER_ADDRESS = "http://" + System.getProperty("myServerAddress");

    public List<NotificationOutputDTO> getNotificationsById(long id) {

        return notificationDao
                .getAllById(id)
                .stream()
                .map(notificationConverter::convertEntityToDTO)//pentru fiec elem din lista apeleaza convertEntityToDTO
                //si apoi ce returneaza colecteaza
                .collect(Collectors.toList());
    }

    public NotificationOutputDTO getWelcomeNotificationById(long id) {

        return notificationConverter.convertEntityToDTO(notificationDao.
                getWelcomeNotificationById(id));

    }

    /**
     * Creates a notification based on the input {@link NotificationType} and {@link NotificationParams}.
     *
     * @param notificationType the type of the notification.
     * @param params the parameters for the notification type.
     */
    public void createNotification(final NotificationType notificationType, final NotificationParams params) {
        switch (notificationType) {
            case WELCOME_NEW_USER:
                this.createWelcomeUserNotification(params);
                break;
            case USER_UPDATED:
                this.createUserUpdateNotification(params);
                break;
        }
    }

    /**
     * Creates the notification for the {@link NotificationType#WELCOME_NEW_USER} message type.
     *
     * @param params the input params.
     */
    private void createWelcomeUserNotification(final NotificationParams params) {
        if (!(params instanceof NotificationParamsWelcomeUser)) {
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
     * Creates the notification for the {@link NotificationType#USER_UPDATED} message type.
     *
     * @param params the input params.
     */
    private void createUserUpdateNotification(final NotificationParams params) {
        if (!(params instanceof NotificationParamsUserChanges)) {
            throw new BusinessException(MessageCatalog.MESSAGE_PARAMS_AND_TYPE_ARE_INCOMPATIBLE);
        }

        final NotificationParamsUserChanges messageParams = (NotificationParamsUserChanges) params;
        this.createWelcomeUpdateTarget(messageParams);
        this.createWelcomeUpdateSource(messageParams);
    }

    private void createWelcomeUpdateTarget(final NotificationParamsUserChanges messageParams) {
        final NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setMessage(NotificationMessageCatalog
                .getFullMessageForUserUpdatedTarget(messageParams.getUsernameSource(),
                        messageParams.getUsernameTarget(), messageParams.getData()));
        notificationEntity.setNotificationType(NotificationType.USER_UPDATED);
        //todo update with correct link when routing is available
        notificationEntity.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntity.setDate(new Date());
        this.notificationDao.createNotification(notificationEntity);

    }

    private void createWelcomeUpdateSource(final NotificationParamsUserChanges messageParams) {
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
