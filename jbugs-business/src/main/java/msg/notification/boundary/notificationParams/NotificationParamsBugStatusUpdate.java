package msg.notification.boundary.notificationParams;

import msg.bug.entity.BugEntity;

public class NotificationParamsBugStatusUpdate implements NotificationParams {

    private String usernameSource;
    private String usernameTarget;
    private String oldStatus;
    private BugEntity bug;

    public NotificationParamsBugStatusUpdate(String usernameSource, String usernameTarget, String oldStatus, BugEntity bug) {
        this.usernameSource = usernameSource;
        this.usernameTarget = usernameTarget;
        this.oldStatus = oldStatus;
        this.bug = bug;
    }

    public String getUsernameSource() {
        return usernameSource;
    }

    public void setUsernameSource(String usernameSource) {
        this.usernameSource = usernameSource;
    }

    public String getUsernameTarget() {
        return usernameTarget;
    }

    public void setUsernameTarget(String usernameTarget) {
        this.usernameTarget = usernameTarget;
    }

    public BugEntity getBug() {
        return bug;
    }

    public void setBug(BugEntity bug) {
        this.bug = bug;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }
}
