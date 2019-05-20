package edu.msg.ro.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Entity
@Table(name = "bugs")
public class Bug extends BaseEntity<Long>{

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name ="version")
    private String version;
    @Column(name ="targetDate")
    private Date date;
    @Column(name = "Status")
    private String Status;
    @Column(name = "fixed_version")
    private String fixedVersion;
    @Column (name ="severity")
    private String severity;
    /* todo: createByUser assigned to */

    public Bug() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
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
