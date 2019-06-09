package msg.notification.control;

import java.text.MessageFormat;

/**
 * The catalog of all the Notification messages.
 *
 * @author msg systems AG;
 * @since 19.1.2
 */
public class NotificationMessageCatalog {

    private static final String WELCOME_NEW_USER = "Bun venit {0},username-ul tau este {1}!";
    private static final String USER_DELETED_NOTIFICATIONS = "{0}, ai fost dezactivat";
    private static final String USER_UPDATED_TARGET = " Datele tale au fost modificate de catre {0}";
    private static final String USER_UPDATED_SOURCE = "Ai modificat datele lui {0}";
    private static final String BUG_UPDATED_NEW_SOURCE = "{0}, bug-ul {1} a fost creat, si asignat utilizatorului {2}!";
    private static final String BUG_UPDATED_NEW_DEST = "{0}, ai un nou bug {1} asignat de catre {2}!";
    private static final String BUG_UPDATED_SOURCE = "{0}, bug-ul {1} a fost creat, si asignat utilizatorului {2}!";
    private static final String BUG_UPDATED_DEST = "{0}, ai un nou bug {1} asignat de catre {2}!";
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

    public static String getFullMessageForBugCreateSource(String usernameSource, String usernameTarget, String data) {
        return MessageFormat.format(BUG_UPDATED_NEW_SOURCE, usernameSource, data, usernameTarget);
    }

    public static String getFullMessageForBugCreateTarget(String usernameSource, String usernameTarget, String data) {
        return MessageFormat.format(BUG_UPDATED_NEW_DEST, usernameSource, data, usernameTarget);
    }

    public static String getFullMessageForBugUpdateSource(String usernameSource, String usernameTarget, String data) {
        return MessageFormat.format(BUG_UPDATED_SOURCE, usernameSource, data, usernameTarget);
    }

    public static String getFullMessageForBugUpdateTarget(String usernameSource, String usernameTarget, String data) {
        return MessageFormat.format(BUG_UPDATED_DEST, usernameSource, data, usernameTarget);
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
