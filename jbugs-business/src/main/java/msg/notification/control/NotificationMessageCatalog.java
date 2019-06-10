package msg.notification.control;

import java.text.MessageFormat;

/**
 * The catalog of all the Notification messages.
 *
 * @author msg systems AG;
 * @since 19.1.2
 */
public class NotificationMessageCatalog {

    private static final String WELCOME_NEW_USER = "Welcome {0},you're username is {1}!";
    private static final String USER_DELETED_NOTIFICATIONS = "User {0} has been deleted";
    private static final String USER_UPDATED_TARGET = " Your data has been modified by {0}";
    private static final String USER_UPDATED_SOURCE = "You modified the data of {0}";
    private static final String BUG_CREATED_NEW_SOURCE = "You created the bug with title {1} , severity {2}  and assigned it to {0}!";
    private static final String BUG_CREATED_NEW_DEST = "User {3}, the bug with title {1} and severity {2} was assigned to you by {0}!";
    private static final String BUG_UPDATED_SOURCE = "You updated the bug with title {1}, severity {2} and assigned it to  {0}!";
    private static final String BUG_UPDATED_DEST = "User {3}, the bug with title {1} and severity {2} assigned to you was updated by {0}";
    private static final String BUG_STATUS_UPDATED_SOURCE = "User {0}, the bug {1}, has been changed from status {2} to status {3}";
    private static final String BUG_STATUS_UPDATED_TARGET = "User {0}, the bug {1}, has been changed from status {2} to status {3}";
    private static final String BUG_CLOSED = "User {0}, bug {1} has been CLOSED";

    public static String getFullMessageForWelcomeNewUser(String name, String username) {
        return MessageFormat.format(WELCOME_NEW_USER, name, username);

    }

    //    public static String getFullMessageForUserUpdatedTarget(String usernameSource, String usernameTarget, String data) {
    public static String getFullMessageForUserUpdatedTarget(String usernameSource) {
//        return MessageFormat.format(USER_UPDATED_TARGET, usernameSource, usernameTarget, data);
        return MessageFormat.format(USER_UPDATED_TARGET, usernameSource);
    }

    //    public static String getFullMessageForUserUpdatedSource(String usernameTarget, String data) {
    public static String getFullMessageForUserUpdatedSource(String usernameTarget) {
//        return MessageFormat.format(USER_UPDATED_SOURCE, usernameTarget, data);
        return MessageFormat.format(USER_UPDATED_SOURCE, usernameTarget);
    }

    public static String getFullMessageUserDeleted(String username) {
        return MessageFormat.format(USER_DELETED_NOTIFICATIONS, username);
    }

    public static String getFullMessageForBugCreateSource(String usernameSource, String title,String severity,String usernameTarget) {
        return MessageFormat.format(BUG_CREATED_NEW_SOURCE, usernameSource, title,severity, usernameTarget);
    }

    public static String getFullMessageForBugCreateTarget(String usernameSource, String title,String severity,String usernameTarget) {
        return MessageFormat.format(BUG_CREATED_NEW_DEST, usernameSource, title,severity, usernameTarget);
    }

    public static String getFullMessageForBugUpdateSource(String usernameSource, String title,String severity,String usernameTarget) {
        return MessageFormat.format(BUG_UPDATED_SOURCE, usernameSource, title, severity, usernameTarget);
    }

    public static String getFullMessageForBugUpdateTarget(String usernameSource, String title,String severity,String usernameTarget) {
        return MessageFormat.format(BUG_UPDATED_DEST, usernameSource,title,severity, usernameTarget);
    }

    public static String getFullMessageForBugStatusUpdateSource(String usernameSource, String oldStatus, String newStatus, String data) {
        return MessageFormat.format(BUG_STATUS_UPDATED_SOURCE, usernameSource, data, oldStatus, newStatus);
    }

    public static String getFullMessageForBugStatusUpdateTarget(String usernameSource, String oldStatus, String newStatus, String data) {
        return MessageFormat.format(BUG_STATUS_UPDATED_TARGET, usernameSource, data, oldStatus, newStatus);
    }

    public static String getFullMessageForBugClose(String usernameSource, String data) {
        return MessageFormat.format(BUG_CLOSED, usernameSource, data);
    }
}
