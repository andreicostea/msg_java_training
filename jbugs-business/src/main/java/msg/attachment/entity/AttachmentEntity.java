package msg.attachment.entity;

import msg.base.BaseEntity;
import msg.bug.entity.BugEntity;

import javax.persistence.*;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Entity
@Table(name = "attachments")
public class AttachmentEntity extends BaseEntity<Long> {
    @Column(name = "attContent")
    private String addContent;
    @ManyToOne
    @JoinColumn(name = "id_bug")
    private BugEntity bugEntity;

    public AttachmentEntity(String addContent) {
        this.addContent = addContent;
    }

    public AttachmentEntity() {
    }

    public BugEntity getBugEntity() {
        return bugEntity;
    }

    public void setBugEntity(BugEntity bugEntity) {
        this.bugEntity = bugEntity;
    }

    public String getAddContent() {
        return addContent;
    }

    public void setAddContent(String addContent) {
        this.addContent = addContent;
    }
}
