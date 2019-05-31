package msg.bug.entity.dto;

import msg.bug.entity.BugEntity;

import javax.ejb.Stateless;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public BugEntity convertInputDTOToEntity(BugInputDTO input) {
        final BugEntity b = new BugEntity();
        b.setTitle(input.getTitle());
        b.setDescription(input.getDescription());
        b.setVersion(input.getVersion());
        b.setFixedVersion(input.getFixedVersion());
        b.setTargetDate(parseStringToDate(input.getTargetDate()));
        b.setSeverity(input.getSeverity());
        //b.setAssigned(input.);
        //b.setAttachmentEntities(input.);
        return b;
    }

    public BugDTO convertEntityDTOtoEntity(BugEntity bug) {
        final BugDTO b = new BugDTO();
        b.setTitle(bug.getTitle());
        b.setDescription(bug.getDescription());
        b.setVersion(bug.getVersion());
        b.setFixedVersion(bug.getFixedVersion());
        b.setTargetDate(bug.getTargetDate());
        b.setSeverity(bug.getSeverity());

        return b;
    }
    // "yyyy-MM-ddT21:00:00.000Z   => "yyyy-MM-dd HH:mm:ss""
    public Date parseStringToDate(String input ){


        String split1 = input.substring(0,10);
        String split2 = input.substring(split1.length() + 4, input.length() - 2);
        input = split1 + " " + split2;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        try {
            date = format.parse(input);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;

    }
}
