package msg.bug.entity.dto;


public class BugInputDTO {

    private String title;
    private String description;
    private String version;
    private String targetDate;
    private String fixedVersion;
    private String severity;


    public BugInputDTO() {
    }

    public BugInputDTO(String title, String description, String version, String targetDate, String fixedVersion, String severity) {
        this.title = title;
        this.description = description;
        this.version = version;
        this.targetDate = targetDate;
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
}
