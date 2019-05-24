package msg.history;

import msg.base.BaseEntity;
import msg.bug.entity.BugEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Entity
@Table(name="history")
public class HistoryEntity extends BaseEntity<Long> {
    @Column(name = "modifiedDate")
    private Date modifiedDate;
    @Column(name = "afterStatus")
    private String afterStatus;
    @Column(name = "beforeStatus")
    private String beforeStatus;
    @Column(name = "modifiedBy")
    private String modifiedBy;
@ManyToOne
@JoinColumn(name="id_bug", nullable=false)
private BugEntity bugEntity;
    public HistoryEntity() {
    }

    public BugEntity getBugEntity() {
        return bugEntity;
    }

    public void setBugEntity(BugEntity bugEntity) {
        this.bugEntity = bugEntity;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getAfterStatus() {
        return afterStatus;
    }

    public void setAfterStatus(String afterStatus) {
        this.afterStatus = afterStatus;
    }

    public String getBeforeStatus() {
        return beforeStatus;
    }

    public void setBeforeStatus(String beforeStatus) {
        this.beforeStatus = beforeStatus;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
