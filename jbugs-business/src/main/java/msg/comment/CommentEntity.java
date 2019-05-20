package msg.comment;

import edu.msg.ro.persistence.entity.BaseEntity;
import edu.msg.ro.persistence.entity.Comment;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
public class CommentEntity {
    @Entity
    @Table(name = "comments")
    public class Comment extends BaseEntity<Long> {
        @Column(name = "text")
        private String text;
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "date")
        private Date date;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;



        public Comment() {
        }

        public Comment(String text, Date date) {
            this.text = text;
            this.date = date;
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
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Comment comment = (Comment) o;
            return Objects.equals(text, comment.text) &&
                    Objects.equals(date, comment.date);
        }

        @Override
        public int hashCode() {
            return Objects.hash(text, date);
        }
    }

}
