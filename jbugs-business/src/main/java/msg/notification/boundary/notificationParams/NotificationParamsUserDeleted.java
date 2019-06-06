package msg.notification.boundary.notificationParams;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
public class NotificationParamsUserDeleted implements NotificationParams {

    private String username;

    public NotificationParamsUserDeleted(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
