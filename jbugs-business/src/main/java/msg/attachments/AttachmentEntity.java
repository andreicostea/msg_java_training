package msg.attachments;

import edu.msg.ro.persistence.entity.BaseEntity;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
public class AttachmentEntity extends BaseEntity<Long> {
    private String addContent;

    public AttachmentEntity(String addContent) {
        this.addContent = addContent;
    }

    public String getAddContent() {
        return addContent;
    }

    public void setAddContent(String addContent) {
        this.addContent = addContent;
    }

    public AttachmentEntity() {
    }
}
