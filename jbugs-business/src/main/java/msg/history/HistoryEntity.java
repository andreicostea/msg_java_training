package msg.history;

import edu.msg.ro.persistence.entity.BaseEntity;
import msg.bugs.BugEntity;

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
    private Date modifiedDate;
    private String afterDate;
@ManyToOne
@JoinColumn(name="bug_id", nullable=false)
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

    public String getAfterDate() {
        return afterDate;
    }

    public void setAfterDate(String afterDate) {
        this.afterDate = afterDate;
    }
}
