package msg.notification.entity.dto;

import msg.notification.entity.NotificationType;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@XmlRootElement
public class NotificationOutputDTO  //e de output
{
    private Long id;
    private String urlBug;
    private String message;
    private Date date;
    private NotificationType notificationType;

    public NotificationOutputDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
