package msg.bug.entity.dto;

import msg.bug.entity.BugEntity;
import msg.user.entity.UserEntity;
import msg.user.entity.dao.UserDAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

@Stateless
public class BugConverter {

    @EJB
    private UserDAO userDao;

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


        if(input.getCREATED_ID() != 0){
            try {
               UserEntity userEntity = userDao.getUserById(input.getCREATED_ID());
               b.setCreated(userEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(input.getASSIGNED_ID() != null){
            try {
                UserEntity userEntity =  userDao.getUserById(input.getASSIGNED_ID());
                b.setAssigned(userEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



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


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = null;
        try {
            date = dateFormat.parse(input);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }



    }


}
