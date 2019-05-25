package msg.bug.boundary;

import msg.bug.control.BugControl;
import msg.bug.entity.dto.BugInputDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BugFacade {
    @EJB
    private BugControl bugControl;

    public void createBug(BugInputDTO bug)
    {
        this.bugControl.createBug(bug);
    }

    public Object getAll()
    {
        return this.bugControl.getAll();
    }

    public void updateBug(BugDTO input) {
        this.bugControl.updateBug(input);
    }
}
