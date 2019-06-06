package msg.notification.control;

import java.text.MessageFormat;

/**
 * The catalog of all the Notification messages.
 *
 * @author msg systems AG;
 * @since 19.1.2
 */
public class NotificationMessageCatalog {

    //TODO refactor to english
    private static final String WELCOME_NEW_USER = "Bun venit {0},username-ul tau este {1}!";
    private static final String USER_UPDATED_TARGET = " Datele tale au fost modificate de catre {0}";
    private static final String USER_UPDATED_SOURCE = "Ai modificat datele lui {0}";

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


}
