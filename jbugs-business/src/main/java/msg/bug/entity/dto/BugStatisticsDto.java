package msg.bug.entity.dto;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
public class BugStatisticsDto {
    private int newBug;
    private int closed;
    private int fixed;
    private int open;
    private int inProgress;
    private int infoNeeded;
    private int rejected;

    public int getClosed() {
        return closed;
    }

    public void setClosed(int closed) {
        this.closed = closed;
    }

    public int getFixed() {
        return fixed;
    }

    public void setFixed(int fixed) {
        this.fixed = fixed;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    public int getInProgress() {
        return inProgress;
    }

    public void setInProgress(int inProgress) {
        this.inProgress = inProgress;
    }

    public int getInfoNeeded() {
        return infoNeeded;
    }

    public void setInfoNeeded(int infoNeeded) {
        this.infoNeeded = infoNeeded;
    }

    public int getRejected() {
        return rejected;
    }

    public void setRejected(int rejected) {
        this.rejected = rejected;
    }

    public int getNewBug() {
        return newBug;
    }

    public void setNewBug(int newBug) {
        this.newBug = newBug;
    }
}
