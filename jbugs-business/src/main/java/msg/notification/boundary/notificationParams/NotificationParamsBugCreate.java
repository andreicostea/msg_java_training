package msg.notification.boundary.notificationParams;

import msg.bug.entity.BugEntity;

public class NotificationParamsBugCreate implements NotificationParams  {

    private String usernameSource;
    private String usernameTarget;
    private BugEntity bug;

    public NotificationParamsBugCreate(String usernameSource, String usernameTarget, BugEntity bug) {
        this.usernameSource = usernameSource;
        this.usernameTarget = usernameTarget;
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
}
