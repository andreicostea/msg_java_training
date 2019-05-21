package msg.comment.entity.dto;

import java.util.Date;

public class CommentDTO {

    private String text;
    private Date date;

    public CommentDTO() {
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
}
