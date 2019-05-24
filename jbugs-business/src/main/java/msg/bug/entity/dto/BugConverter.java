package msg.bug.entity.dto;

import msg.bug.entity.BugEntity;

import javax.ejb.Stateless;

@Stateless
public class BugConverter {

    public BugEntity convertDTOToEntity(BugDTO bugDTO) {
        final BugEntity b = new BugEntity();
        b.setTitle(bugDTO.getTitle());
        b.setDescription(bugDTO.getDescription());
        b.setVersion(bugDTO.getVersion());
        b.setFixedVersion(bugDTO.getFixedVersion());
        b.setStatus(bugDTO.getStatus());
        return b;
    }
    public BugEntity convertInputDTOToEntity(BugInputDTO input)
    {
        final BugEntity b = new BugEntity();
        b.setTitle(input.getTitle());
        b.setDescription(input.getDescription());
        b.setVersion(input.getVersion());
        b.setFixedVersion(input.getFixedVersion());
        return b;
    }

    public BugDTO convertEntityDTOtoEntity(BugEntity bug)
    {
        final BugDTO b = new BugDTO();
        b.setTitle(bug.getTitle());
        b.setDescription(bug.getDescription());
        b.setVersion(bug.getVersion());
        b.setFixedVersion(bug.getFixedVersion());
        b.setTargetDate(bug.getTargetDate());
        b.setSeverity(bug.getSeverity());

        return b;
    }
}
