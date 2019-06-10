// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.notification.entity.dto;

import msg.notification.entity.NotificationType;

import java.util.Date;

/**
 * A representation of the User, used for creating a user.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
public class NotificationInputDTO {
    private Long id;
    private String type;
    private String urlBug;
    private String message;
    private Long userId;
    private Date date;
    private NotificationType notificationType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrlBug() {
        return urlBug;
    }

    public void setUrlBug(String urlBug) {
        this.urlBug = urlBug;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }
    /**
     * Getter.
     *
     * @return firstName
     */

}
