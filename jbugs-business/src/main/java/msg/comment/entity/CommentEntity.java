package msg.comment.entity;

import msg.base.BaseEntity;
import msg.bug.entity.BugEntity;
import msg.user.entity.UserEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity<Long> {
    @Column(name = "text")
    private String text;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(name = "bug_id")
    private BugEntity bugEntity;

    public CommentEntity() {
    }

    public CommentEntity(String text, Date date) {
        this.text = text;
        this.date = date;
    }

    public BugEntity getBugEntity() {
        return bugEntity;
    }

    public void setBugEntity(BugEntity bugEntity) {
        this.bugEntity = bugEntity;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentEntity comment = (CommentEntity) o;
        return Objects.equals(text, comment.text) &&
                Objects.equals(date, comment.date) &&
                Objects.equals(userEntity, comment.userEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, date, userEntity);
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
