package msg.bug.entity.dto;

import java.util.Date;

public class BugDTO {

    private String title;
    private String description;
    private String version;
    private Date date;
    private String Status;
    private String fixedVersion;
    private String severity;

    public BugDTO() {
    }

    public BugDTO(String title, String description, String version, Date date, String status, String fixedVersion, String severity) {
        this.title = title;
        this.description = description;
        this.version = version;
        this.date = date;
        Status = status;
        this.fixedVersion = fixedVersion;
        this.severity = severity;
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
