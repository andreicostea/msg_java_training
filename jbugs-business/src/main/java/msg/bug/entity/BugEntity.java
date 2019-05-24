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
@NamedQueries({
        @NamedQuery(name = BugEntity.BUG_GET_ALL,
                query = "select b from BugEntity b")})
public class BugEntity extends BaseEntity<Long> {
    public static final String BUG_GET_ALL = "BugEntity.getAllBugEntities";

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "version", nullable = false)
    private String version;
    @Column(name = "targetDate")
    private Date targetDate;
    @Column(name = "severity")
    private String severity;
    @Column(name = "status")
    private String status;
    @Column(name = "fixedVersion", nullable = false)
    private String fixedVersion;

    public BugEntity() {
    }

    @OneToMany(mappedBy = "bugEntity")
    private Set<CommentEntity> comments;

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    @ManyToOne
    @JoinColumn(name = "ASSIGNED_ID")
    private UserEntity assignedTo;

    public UserEntity getAssigned() {
        return assignedTo;
    }

    public void setAssigned(UserEntity assignedTo) {
        this.assignedTo = assignedTo;
    }

    @ManyToOne
    @JoinColumn(name = "CREATED_ID", insertable = false, updatable = false)
    private UserEntity createdBy;

    public UserEntity getCreated() {
        return createdBy;
    }

    public void setCreated(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    @OneToMany(mappedBy = "bugEntity")
    private Set<AttachmentEntity> attachments;
    @OneToMany(mappedBy = "bugEntity")
    private Set<HistoryEntity> historyEntities;

    public Set<HistoryEntity> getHistoryEntities() {
        return historyEntities;
    }

    public void setHistoryEntities(Set<HistoryEntity> historyEntities) {
        this.historyEntities = historyEntities;
    }

    public Set<AttachmentEntity> getAttachmentEntities() {
        return attachments;
    }

    public void setAttachmentEntities(Set<AttachmentEntity> attachmentEntities) {
        this.attachments = attachmentEntities;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
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

    public String getFixedVersion() {
        return fixedVersion;
    }

    public void setFixedVersion(String fixedVersion) {
        this.fixedVersion = fixedVersion;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
