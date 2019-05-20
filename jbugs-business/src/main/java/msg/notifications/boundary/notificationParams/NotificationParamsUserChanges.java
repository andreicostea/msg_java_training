// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.notifications.boundary.notificationParams;

/**
 * The message parameters of the message type {@link msg.notifications.entity.NotificationType#USER_UPDATED}.
 *  *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
public class NotificationParamsUserChanges implements NotificationParams {

    private String usernameSource;
    private String usernameTarget;
    private String data;

    public NotificationParamsUserChanges(final String usernameSource, final String usernameTarget, final String data) {
        this.usernameSource = usernameSource;
        this.usernameTarget = usernameTarget;
        this.data = data;
    }

    /**
     * Getter.
     *
     * @return usernameSource
     */
    public String getUsernameSource() {
        return this.usernameSource;
    }

    /**
     * Setter.
     *
     * @param pUsernameSource
     */
    public void setUsernameSource(final String pUsernameSource) {
        this.usernameSource = pUsernameSource;
    }

    /**
     * Getter.
     *
     * @return usernameTarget
     */
    public String getUsernameTarget() {
        return this.usernameTarget;
    }

    /**
     * Setter.
     *
     * @param pUsernameTarget
     */
    public void setUsernameTarget(final String pUsernameTarget) {
        this.usernameTarget = pUsernameTarget;
    }

    /**
     * Getter.
     *
     * @return data
     */
    public String getData() {
        return this.data;
    }

    /**
     * Setter.
     *
     * @param pData
     */
    public void setData(final String pData) {
        this.data = pData;
    }
}
