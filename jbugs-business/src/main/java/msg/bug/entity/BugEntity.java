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
                query = "select b from BugEntity b"),
        @NamedQuery(name = BugEntity.BUG_FIND_BY_ID,
                query = "select b from BugEntity b where b.id = :" + BugEntity.ID)})

public class BugEntity extends BaseEntity<Long> {
    public static final String BUG_GET_ALL = "BugEntity.getAllBugEntities";
    public static final String BUG_GET_BY_TITLE = "BugEntity.getBugByTitle";
    public static final String UPDATE_BUG = "BugEntity.updateBug";
    public static final String BUG_FIND_BY_ID = "BugEntity.findById";
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String VERSION = "version";
    public static final String FIXEDVERSION = "fixedVersion";
    public static final String SEVERITY = "severity";
    public static final String STATUS = "status";

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
    @OneToMany(mappedBy = "bugEntity")
    private Set<CommentEntity> comments;
    @ManyToOne
    @JoinColumn(name = "ASSIGNED_ID", nullable = true)
    private UserEntity assignedTo;
    @ManyToOne
    @JoinColumn(name = "CREATED_ID", nullable = false)
    private UserEntity createdBy;
    @OneToMany(mappedBy = "bugEntity")
    private Set<AttachmentEntity> attachments;
    @OneToMany(mappedBy = "bugEntity")
    private Set<HistoryEntity> historyEntities;

    public BugEntity() {
    }

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    public UserEntity getAssigned() {
        return assignedTo;
    }

    public void setAssigned(UserEntity assignedTo) {
        this.assignedTo = assignedTo;
    }

    public UserEntity getCreated() {
        return createdBy;
    }

    public void setCreated(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

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
