package msg.bug.entity.dto;

import msg.base.BaseEntity;

public class BugDTO extends BaseEntity<Long> {
    private String title;
    private String description;
    private String version;
    private String targetDate;
    private String fixedVersion;
    private String severity;
    private String status;
    private String usernameAssignTo;
    private String usernameCreatedBy;

//    private UserEntity assignedTo;
//    private Set<AttachmentEntity> attachment;
    /* todo: severity and status should be enums
     *   status should be set to New when first created
     *   what data type is the attachment? how do we limit it to 25mb?
     */


    public BugDTO() {
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

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsernameAssignTo() {
        return usernameAssignTo;
    }

    public void setUsernameAssignTo(String usernameAssignTo) {
        this.usernameAssignTo = usernameAssignTo;
    }

    public String getUsernameCreatedBy() {
        return usernameCreatedBy;
    }

    public void setUsernameCreatedBy(String usernameCreatedBy) {
        this.usernameCreatedBy = usernameCreatedBy;
    }
}
