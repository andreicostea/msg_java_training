package msg.bug.boundary;

import msg.bug.control.BugControl;
import msg.bug.entity.StatusUpdate;
import msg.bug.entity.dto.BugDTO;
import msg.bug.entity.dto.BugInputDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;

@Stateless
public class BugFacade {
    @EJB
    private BugControl bugControl;

    public void createBug(BugInputDTO bug) {
        this.bugControl.createBug(bug);
    }

    public List<BugDTO> getAll() {
        return this.bugControl.getAll();
    }

    public void updateBug(BugDTO input, Map<String, List<String>> statusMap) {
        this.bugControl.updateBug(input, statusMap);
    }

    public Object getStatusBugComplete(String status) {
        return StatusUpdate.allStatusValue.get(status.toUpperCase());
    }

    public Object getStatusBugLimited(String status) {
        return StatusUpdate.limitedStatusValue.get(status.toUpperCase());
    }
}
