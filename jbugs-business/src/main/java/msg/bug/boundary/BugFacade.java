package msg.bug.boundary;

import msg.bug.control.BugControl;
import msg.bug.entity.dto.BugDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BugFacade {
    @EJB
    private BugControl bugControl;

    public void createBug(BugDTO bug)
    {
        this.bugControl.createBug(bug);
    }

    public Object getAll()
    {
        return bugControl.getAll();
    }

}
