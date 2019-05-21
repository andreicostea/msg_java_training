package msg.bug.entity.dto;

import msg.bug.Bug;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BugConverter {

    public Bug convertDTOToEntity(BugDTO bugDTO) {
        final Bug b = new Bug();
        b.setTitle(bugDTO.getTitle());
        b.setDescription(bugDTO.getDescription());
        b.setVersion(bugDTO.getVersion());
        b.setFixedVersion(bugDTO.getFixedVersion());
        b.setDate(bugDTO.getDate());
        b.setSeverity(bugDTO.getSeverity());
        b.setStatus(bugDTO.getStatus());
        return b;
    }

    public BugDTO convertEntityDTOtoEntity(Bug bug)
    {
        final BugDTO b = new BugDTO();
        b.setTitle(bug.getTitle());
        b.setDescription(bug.getDescription());
        b.setVersion(bug.getVersion());
        b.setFixedVersion(bug.getFixedVersion());
        b.setSeverity(bug.getSeverity());
        b.setSeverity(bug.getSeverity());
        return b;
    }
}
