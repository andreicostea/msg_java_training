// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.notifications.boundary.notificationParams;

/**
 * The message parameters of the message type {@link msg.notifications.entity.NotificationType#WELCOME_NEW_USER}.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
public class NotificationParamsWelcomeUser implements NotificationParams {

    private String name;
    private String username;

    public NotificationParamsWelcomeUser(final String name, final String username) {
        this.name = name;
        this.username = username;
    }

    /**
     * Getter.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter.
     *
     * @param pName
     */
    public void setName(final String pName) {
        this.name = pName;
    }

    /**
     * Getter.
     *
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Setter.
     *
     * @param pUsername
     */
    public void setUsername(final String pUsername) {
        this.username = pUsername;
    }
}
