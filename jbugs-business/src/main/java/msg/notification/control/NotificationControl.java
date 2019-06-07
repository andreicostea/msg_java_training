package msg.notification.control;

import msg.exceptions.BusinessException;
import msg.notification.MessageCatalog;
import msg.notification.boundary.notificationParams.*;
import msg.notification.entity.NotificationEntity;
import msg.notification.entity.NotificationType;
import msg.notification.entity.dao.NotificationDAO;
import msg.notification.entity.dto.NotificationConverter;
import msg.notification.entity.dto.NotificationOutputDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
    private static final String SERVER_ADDRESS = "http://" + System.getProperty("myServerAddress");
    @EJB
    private NotificationDAO notificationDao;
    @EJB
    private NotificationConverter notificationConverter;

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

    public List<NotificationOutputDTO> getUpdateNotificationById(long id) {

        return notificationDao.getUpdateNotificationById(id)
                .stream()
                .map(notificationConverter::convertEntityToDTO)//pentru fiec elem din lista apeleaza convertEntityToDTO
                //si apoi ce returneaza colecteaza
                .collect(Collectors.toList());

    }

    public void deleteNotificationsPeriodically() {
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DATE, -30);
        java.util.Date dt = c.getTime();
        java.sql.Date dtSql = new java.sql.Date(dt.getTime());
        System.out.println(dtSql);
        notificationDao.deleteNotificationsPeriodically(dtSql);

    }

    /**
     * Creates a notification based on the input {@link NotificationType} and {@link NotificationParams}.
     *
     * @param notificationType the type of the notification.
     * @param params           the parameters for the notification type.
     */
    public void createNotification(final NotificationType notificationType, final NotificationParams params, final long... id) {
        switch (notificationType) {
            case WELCOME_NEW_USER:
                this.createWelcomeUserNotification(params, id[0]);
                break;
            case USER_UPDATED:
                this.createUserUpdateNotification(params, id[0], id[1]);
                break;
            case USER_DELETED:
                this.createUserDeleteNotification(params, id[0]);
                break;
            case BUG_UPDATED:
                this.createBugUpdatedNotification(params, id[0], id[1]);
                break;
            case BUG_CREATED:
                this.createBugCreatedNotification(params, id[0], id[1]);
                break;
            case BUG_STATUS_UPDATE:
                this.createBugStatusUpdatedNotification(params, id[0], id[1]);
                break;
            case BUG_CLOSED:
                this.createBugClosedNotification(params, id[0], id[1]);
                break;
        }
    }

    private void createBugUpdatedNotification(NotificationParams params, long userSourceID, long userTargetID) {
        if (!(params instanceof NotificationParamsBugUpdate)) {
            throw new BusinessException(MessageCatalog.MESSAGE_PARAMS_AND_TYPE_ARE_INCOMPATIBLE);
        }
        final NotificationParamsBugUpdate messageParams = (NotificationParamsBugUpdate) params;
        final NotificationEntity notificationEntityS = new NotificationEntity();
        final NotificationEntity notificationEntityT = new NotificationEntity();
        notificationEntityS.setMessage(
                NotificationMessageCatalog.getFullMessageForBugCreateSource(
                        messageParams.getUsernameSource(),
                        messageParams.getUsernameTarget(),
                        messageParams.getBug().toString()));
        notificationEntityT.setMessage(
                NotificationMessageCatalog.getFullMessageForBugCreateTarget(
                        messageParams.getUsernameTarget(),
                        messageParams.getUsernameSource(),
                        messageParams.getBug().toString()));
        notificationEntityS.setNotificationType(NotificationType.BUG_UPDATED);
        notificationEntityT.setNotificationType(NotificationType.BUG_UPDATED);
        //todo update with correct link when routing is available
        notificationEntityS.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntityS.setDate(new Date());
        notificationEntityS.setUserID(userSourceID);
        notificationEntityT.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntityT.setDate(new Date());
        notificationEntityT.setUserID(userTargetID);
        this.notificationDao.createNotification(notificationEntityS);
        this.notificationDao.createNotification(notificationEntityT);
    }

    private void createBugCreatedNotification(NotificationParams params, long userSourceID, long userTargetID) {
        if (!(params instanceof NotificationParamsBugCreate)) {
            throw new BusinessException(MessageCatalog.MESSAGE_PARAMS_AND_TYPE_ARE_INCOMPATIBLE);
        }
        final NotificationParamsBugCreate messageParams = (NotificationParamsBugCreate) params;
        final NotificationEntity notificationEntityS = new NotificationEntity();
        final NotificationEntity notificationEntityT = new NotificationEntity();
        notificationEntityS.setMessage(
                NotificationMessageCatalog.getFullMessageForBugUpdateSource(
                        messageParams.getUsernameSource(),
                        messageParams.getUsernameTarget(),
                        messageParams.getBug().toString()));
        notificationEntityT.setMessage(
                NotificationMessageCatalog.getFullMessageForBugUpdateTarget(
                        messageParams.getUsernameTarget(),
                        messageParams.getUsernameSource(),
                        messageParams.getBug().toString()));
        notificationEntityS.setNotificationType(NotificationType.BUG_CREATED);
        notificationEntityT.setNotificationType(NotificationType.BUG_CREATED);
        //todo update with correct link when routing is available
        notificationEntityS.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntityS.setDate(new Date());
        notificationEntityS.setUserID(userSourceID);
        notificationEntityT.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntityT.setDate(new Date());
        notificationEntityT.setUserID(userTargetID);
        this.notificationDao.createNotification(notificationEntityS);
        this.notificationDao.createNotification(notificationEntityT);
    }

    private void createBugStatusUpdatedNotification(NotificationParams params, long userSourceID, long userTargetID) {
        if (!(params instanceof NotificationParamsBugStatusUpdate)) {
            throw new BusinessException(MessageCatalog.MESSAGE_PARAMS_AND_TYPE_ARE_INCOMPATIBLE);
        }
        final NotificationParamsBugStatusUpdate messageParams = (NotificationParamsBugStatusUpdate) params;
        final NotificationEntity notificationEntityS = new NotificationEntity();
        final NotificationEntity notificationEntityT = new NotificationEntity();
        notificationEntityS.setMessage(
                NotificationMessageCatalog.getFullMessageForBugStatusUpdateSource(
                        messageParams.getUsernameSource(),
                        messageParams.getOldStatus(),
                        messageParams.getBug().getStatus(),
                        messageParams.getBug().toString()));
        notificationEntityT.setMessage(
                NotificationMessageCatalog.getFullMessageForBugStatusUpdateTarget(
                        messageParams.getUsernameTarget(),
                        messageParams.getOldStatus(),
                        messageParams.getBug().getStatus(),
                        messageParams.getBug().toString()));
        notificationEntityS.setNotificationType(NotificationType.BUG_STATUS_UPDATE);
        notificationEntityT.setNotificationType(NotificationType.BUG_STATUS_UPDATE);
        //todo update with correct link when routing is available
        notificationEntityS.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntityS.setDate(new Date());
        notificationEntityS.setUserID(userSourceID);
        notificationEntityT.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntityT.setDate(new Date());
        notificationEntityT.setUserID(userTargetID);
        this.notificationDao.createNotification(notificationEntityS);
        this.notificationDao.createNotification(notificationEntityT);
    }

    private void createBugClosedNotification(final NotificationParams params, final long userSourceID, final long userTargetID) {
        if (!(params instanceof NotificationParamsBugClose)) {
            throw new BusinessException(MessageCatalog.MESSAGE_PARAMS_AND_TYPE_ARE_INCOMPATIBLE);
        }
        final NotificationParamsBugClose messageParams = (NotificationParamsBugClose) params;
        final NotificationEntity notificationEntityS = new NotificationEntity();
        final NotificationEntity notificationEntityT = new NotificationEntity();
        notificationEntityS.setMessage(
                NotificationMessageCatalog.getFullMessageForBugClose(
                        messageParams.getUsernameSource(),
                        messageParams.getBug().toString()));
        notificationEntityT.setMessage(
                NotificationMessageCatalog.getFullMessageForBugClose(
                        messageParams.getUsernameTarget(),
                        messageParams.getBug().toString()));
        notificationEntityS.setNotificationType(NotificationType.BUG_CLOSED);
        notificationEntityT.setNotificationType(NotificationType.BUG_CLOSED);
        //todo update with correct link when routing is available
        notificationEntityS.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntityS.setDate(new Date());
        notificationEntityS.setUserID(userSourceID);
        notificationEntityT.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntityT.setDate(new Date());
        notificationEntityT.setUserID(userTargetID);
        this.notificationDao.createNotification(notificationEntityS);
        this.notificationDao.createNotification(notificationEntityT);
    }

    /**
     * Creates the notification for the {@link NotificationType#WELCOME_NEW_USER} message type.
     *
     * @param params the input params.
     */
    private void createWelcomeUserNotification(final NotificationParams params, final long userID) {
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
        notificationEntity.setUserID(userID);
        this.notificationDao.createNotification(notificationEntity);
    }

    /**
     * Creates the notification for the {@link NotificationType#USER_UPDATED} message type.
     *
     * @param params the input params.
     */
    private void createUserUpdateNotification(final NotificationParams params, final long userIdSource, final long userIdTarget) {
        if (!(params instanceof NotificationParamsUserChanges)) {
            throw new BusinessException(MessageCatalog.MESSAGE_PARAMS_AND_TYPE_ARE_INCOMPATIBLE);
        }

        final NotificationParamsUserChanges messageParams = (NotificationParamsUserChanges) params;
        this.createWelcomeUpdateTarget(messageParams, userIdTarget);
        this.createWelcomeUpdateSource(messageParams, userIdSource);
    }

    private void createUserDeleteNotification(final NotificationParams params, final long userID) {
        if (!(params instanceof NotificationParamsUserDeleted)) {
            throw new BusinessException(MessageCatalog.MESSAGE_PARAMS_AND_TYPE_ARE_INCOMPATIBLE);
        }
        final NotificationParamsUserDeleted messageParams = (NotificationParamsUserDeleted) params;
        this.createDeleteUserNotifications(messageParams, userID);
    }


    private void createWelcomeUpdateTarget(final NotificationParamsUserChanges messageParams, final long userID) {
        final NotificationEntity notificationEntity = new NotificationEntity();
//        notificationEntity.setMessage(NotificationMessageCatalog.getFullMessageForUserUpdatedTarget(messageParams.getUsernameSource(), messageParams.getUsernameTarget(), messageParams.getData()));
        notificationEntity.setMessage(NotificationMessageCatalog.getFullMessageForUserUpdatedTarget(messageParams.getUsernameSource()));
        notificationEntity.setNotificationType(NotificationType.USER_UPDATED);
        //todo update with correct link when routing is available
        notificationEntity.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntity.setDate(new Date());
        notificationEntity.setUserID(userID);
        this.notificationDao.createNotification(notificationEntity);
    }

    private void createWelcomeUpdateSource(final NotificationParamsUserChanges messageParams, final long userIdSource) {
        final NotificationEntity notificationEntity = new NotificationEntity();
//        notificationEntity.setMessage(NotificationMessageCatalog.getFullMessageForUserUpdatedSource(messageParams.getUsernameSource(), messageParams.getData()));
        notificationEntity.setMessage(NotificationMessageCatalog.getFullMessageForUserUpdatedSource(messageParams.getUsernameTarget()));
        notificationEntity.setNotificationType(NotificationType.USER_UPDATED);
        //todo update with correct link when routing is available
        notificationEntity.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntity.setDate(new Date());
        notificationEntity.setUserID(userIdSource);
        this.notificationDao.createNotification(notificationEntity);

    }

    private void createDeleteUserNotifications(final NotificationParamsUserDeleted messageParams, final long userId) {
        final NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setMessage(
                NotificationMessageCatalog.getFullMessageUserDeleted(messageParams.getUsername()));
        notificationEntity.setNotificationType(NotificationType.USER_DELETED);
        //todo update with correct link when routing is available
        notificationEntity.setUrl(SERVER_ADDRESS + "someOtherInfo");
        notificationEntity.setDate(new Date());
        notificationEntity.setUserID(userId);
        this.notificationDao.createNotification(notificationEntity);
    }

}
