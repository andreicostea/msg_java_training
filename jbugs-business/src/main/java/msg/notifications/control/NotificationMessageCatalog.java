package msg.notifications.control;

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
    private static final String USER_UPDATED_TARGET = " Datelel tale {0} au fost actualizat de {1} datele :{2} ";
    private static final String USER_UPDATED_SOURCE = "{0} au fost actualizate cu  datele {2}";

    public static String getFullMessageForWelcomeNewUser(String name, String username){
        return MessageFormat.format(WELCOME_NEW_USER,name,username);

    }
    public static String getFullMessageForUserUpdatedTarget(String usernameSource,String usernameTarget, String data){
        return MessageFormat.format(USER_UPDATED_TARGET,usernameSource, usernameTarget, data);

    }
    public static String getFullMessageForUserUpdatedSource(String username,String data){
        return MessageFormat.format(USER_UPDATED_SOURCE,username,data);
    }




}
