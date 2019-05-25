package msg.notification.entity;

import msg.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * The Notification Entity.
 *
 * @author msg systems AG;
 * @since 19.1.2
 */
@Entity
@Table(name = "notifications")
@NamedQueries({@NamedQuery(name = NotificationEntity.NOTIFICATION_FIND_USER_ID, query = "SELECT n from NotificationEntity n where n.userID =:id"),
        @NamedQuery(name = NotificationEntity.NOTIFICATION_FIND_BY_NOTIFICATION_TYPE, query = "SELECT n from NotificationEntity n  where n.userID =:id and n.notificationType =:notificationType")
})
public class NotificationEntity extends BaseEntity<Long> {

    public static final String NOTIFICATION_FIND_USER_ID = "NotificationEntity.findById";
    public static final String NOTIFICATION_FIND_BY_NOTIFICATION_TYPE = "NotificationEntity.findByNotificationType";

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private NotificationType notificationType;

    @Column(name = "url")
    private String url;

    @Column(name = "message")
    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @Column(name = "user_id")
    private long userID;

    public NotificationEntity() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationEntity that = (NotificationEntity) o;
        return notificationType == that.notificationType &&
                Objects.equals(url, that.url) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationType, url, message);
    }
}
