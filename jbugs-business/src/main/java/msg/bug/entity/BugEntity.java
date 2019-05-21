package msg.bug.entity;

import msg.attachment.entity.AttachmentEntity;
import msg.base.BaseEntity;
import msg.comment.entity.CommentEntity;
import msg.history.HistoryEntity;
import msg.user.entity.UserEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Entity
@Table(name = "bugs")
public class BugEntity extends BaseEntity<Long> {
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "version", nullable = false)//todo: @Pattern
    private Date version;
    @Column(name = "targetDate")
    private Date targetDate;
    @Column(name = "status")
    private String status;
    @Column(name = "fixedVersion", nullable = false)
    private Date fixedVersion;

    public BugEntity() {
    }

    @OneToMany
    private Set<CommentEntity> comments;

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    @ManyToOne
    private UserEntity assiged;

    public UserEntity getAssiged() {
        return assiged;
    }

    public void setAssiged(UserEntity assiged) {
        this.assiged = assiged;
    }

    @ManyToOne
    private UserEntity created;

    public UserEntity getCreated() {
        return created;
    }

    public void setCreated(UserEntity created) {
        this.created = created;
    }

    @OneToMany
    private Set<AttachmentEntity> attachmentEntities;
    @OneToMany
    private Set<HistoryEntity> historyEntities;

    public Set<HistoryEntity> getHistoryEntities() {
        return historyEntities;
    }

    public void setHistoryEntities(Set<HistoryEntity> historyEntities) {
        this.historyEntities = historyEntities;
    }

    public Set<AttachmentEntity> getAttachmentEntities() {
        return attachmentEntities;
    }

    public void setAttachmentEntities(Set<AttachmentEntity> attachmentEntities) {
        this.attachmentEntities = attachmentEntities;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BugEntity bugEntity = (BugEntity) o;
        return Objects.equals(title, bugEntity.title) &&
                Objects.equals(description, bugEntity.description) &&
                Objects.equals(version, bugEntity.version) &&
                Objects.equals(targetDate, bugEntity.targetDate) &&
                Objects.equals(status, bugEntity.status) &&
                Objects.equals(fixedVersion, bugEntity.fixedVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, version, targetDate, status, fixedVersion);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getVersion() {
        return version;
    }

    public void setVersion(Date version) {
        this.version = version;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFixedVersion() {
        return fixedVersion;
    }

    public void setFixedVersion(Date fixedVersion) {
        this.fixedVersion = fixedVersion;
    }

}
