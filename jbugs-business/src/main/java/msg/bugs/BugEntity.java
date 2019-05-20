package msg.bugs;

import edu.msg.ro.persistence.entity.BaseEntity;

import javax.persistence.Column;
import java.util.Date;
import java.util.Objects;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
public class BugEntity extends BaseEntity<Long> {
    @Column(name="title",nullable = false)
    private String title;
    @Column(name="description",nullable = false)
    private String description;
    @Column(name="version",nullable = false)//todo: @Pattern
    private Date version;
    @Column(name="targetDate")
    private Date targetDate;
    @Column(name="status")
    private String status;
    @Column(name="fixedVersion",nullable = false)
    private Date fixedVersion;
    public BugEntity() {
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
