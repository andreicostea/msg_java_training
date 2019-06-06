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
        b.setId(bugDTO.getId());
        b.setTitle(bugDTO.getTitle());
        b.setDescription(bugDTO.getDescription());
        b.setVersion(bugDTO.getVersion());

        b.setStatus(bugDTO.getStatus());
        b.setSeverity(bugDTO.getSeverity());
        b.setTargetDate(parseStringToDate(bugDTO.getTargetDate()));
        if (bugDTO.getFixedVersion() == null) {
            b.setFixedVersion(" ");
        } else {
            b.setFixedVersion(bugDTO.getFixedVersion());
        }


        try {
            if (bugDTO.getUsernameAssignTo() != null) {
                UserEntity userEntity = userDao.getUserByUsername(bugDTO.getUsernameAssignTo());
                b.setAssigned(userEntity);
            }
            UserEntity userEntity = userDao.getUserByUsername(bugDTO.getUsernameCreatedBy());
            b.setCreated(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;
    }

    public BugEntity convertInputDTOToEntity(BugInputDTO input) {
        final BugEntity b = new BugEntity();
        b.setTitle(input.getTitle());
        b.setDescription(input.getDescription());
        b.setVersion(input.getVersion());
        b.setFixedVersion(input.getFixedVersion());
        b.setTargetDate(parseStringToDateCalendar(input.getTargetDate()));
        b.setSeverity(input.getSeverity());


        if (input.getCREATED_ID() != 0) {
            try {
                UserEntity userEntity = userDao.getUserById(input.getCREATED_ID());
                b.setCreated(userEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (input.getASSIGNED_ID() != null) {
            try {
                UserEntity userEntity = userDao.getUserById(input.getASSIGNED_ID());
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
        b.setId(bug.getId());
        b.setTitle(bug.getTitle());
        b.setStatus(bug.getStatus());
        b.setDescription(bug.getDescription());
        b.setVersion(bug.getVersion());
        b.setFixedVersion(bug.getFixedVersion());
        b.setTargetDate(parseDateToString(bug.getTargetDate()));
        b.setSeverity(bug.getSeverity());
        try {
            b.setUsernameCreatedBy(userDao.getUserById(bug.getCreated().getId()).getUsername());
            if (bug.getAssigned() != null) {
                b.setUsernameAssignTo(userDao.getUserById(bug.getAssigned().getId()).getUsername());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;
    }

    // "yyyy-MM-ddT21:00:00.000Z   => "yyyy-MM-dd HH:mm:ss""
    public Date parseStringToDateCalendar(String input) {


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


    public String parseDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = dateFormat.format(date);

        return str;

    }

    //    public String parseDateToString(Date date) {
//        String string = date.toString().substring(0, 4)
//                + date.toString().substring(7, 11)
//                + date.toString().substring(4, 7)
//                + date.toString().substring(date.toString().length() - 5, date.toString().length());
//        System.out.println(date.toString());
//        return string;
//    }
    public Date parseStringToDate(String str) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;

    }


}
