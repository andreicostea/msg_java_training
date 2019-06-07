package msg.bug.control;

import msg.bug.entity.BugEntity;
import msg.bug.entity.SeverityType;
import msg.bug.entity.StatusType;
import msg.bug.entity.StatusUpdate;
import msg.bug.entity.dao.BugDAO;
import msg.bug.entity.dto.BugConverter;
import msg.bug.entity.dto.BugDTO;
import msg.bug.entity.dto.BugInputDTO;
import msg.exceptions.BusinessException;
import msg.exceptions.BusinessWebAppException;
import msg.notification.boundary.NotificationFacade;
import msg.notification.boundary.notificationParams.*;
import msg.notification.entity.NotificationType;
import msg.notification.entity.NotificationType;
import msg.user.MessageCatalog;
import msg.user.control.UserControl;
import msg.user.entity.UserEntity;
import msg.user.entity.dao.UserDAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static msg.bug.MessageCatalog.LIMIT_EXCEEDED;
import static msg.bug.MessageCatalog.NULL_FIELD;

@Stateless
public class BugControl {

    @EJB
    private BugDAO bugDao;

    @EJB
    private BugConverter bugConverter;
    @EJB
    private NotificationFacade notificationFacade;
    @EJB
    private UserDAO userDao;

    public List<BugDTO> getAll() {
        return bugDao.getAll()
                .stream()
                .map(bugConverter::convertEntityDTOtoEntity)
                .collect(Collectors.toList());
    }

    public BugEntity createBug(BugInputDTO bug) {
        if (bug.getTitle() == null || bug.getDescription() == null || bug.getVersion() == null || bug.getSeverity() == null ||
                bug.getCREATED_ID() == null || bug.getTargetDate() == null)
            throw new BusinessWebAppException(MessageCatalog.BUG_NULL_FIELD, 400);

        if (bug.getTitle().length() == 0 || bug.getDescription().length() == 0 || bug.getTargetDate().length() == 0 ||
                bug.getVersion().length() == 0 || bug.getSeverity().length() == 0)
            throw new BusinessWebAppException(MessageCatalog.BUG_EMPTY_FIELD, 400);

        if (bug.getDescription().length() > 250 || bug.getTitle().length() > 250 || bug.getFixedVersion().length() > 250)
            throw new BusinessWebAppException(MessageCatalog.BUG_LIMIT_EXCEEDED, 400);

        boolean checkSeverity = false;
        for (SeverityType s : SeverityType.values()) {
            if (s.toString().equals(bug.getSeverity().toUpperCase())) checkSeverity = true;
        }
        if (!checkSeverity) throw new BusinessWebAppException(MessageCatalog.BUG_INVALID_PATTERN, 400);

        final BugEntity newBug = bugConverter.convertInputDTOToEntity(bug);
        newBug.setStatus(String.valueOf(StatusType.NEW));
        try {
            bugDao.createBug(newBug);
        } catch (Exception e) {
            throw new BusinessWebAppException(MessageCatalog.BUG_INVALID_PATTERN, 400);
        }
        try {
            this.notificationFacade.createNotification(
                    NotificationType.BUG_CREATED,
                    new NotificationParamsBugCreate(bug.getCREATED_ID().toString(), bug.getASSIGNED_ID().toString(), newBug),
                    bug.getCREATED_ID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newBug;
    }


    public BugEntity updateBug(BugDTO input, Map<String, List<String>> statusMap) {
        BugEntity newBug = null;
        boolean checkStatus = false;
        BugEntity oldBug = bugDao.getById(input.getId());

        if (input.getStatus() != null) {
            for (String status : statusMap.get(oldBug.getStatus())) {
                if (status.equals(input.getStatus().toUpperCase())) checkStatus = true;
            }
            if (checkStatus) {
                if (input.getTitle() == null || input.getDescription() == null || input.getVersion() == null || input.getSeverity() == null ||
                        input.getUsernameCreatedBy() == null || input.getTargetDate() == null) {
                    throw new BusinessWebAppException(MessageCatalog.BUG_NULL_FIELD, 400);
                } else {
                    newBug = bugConverter.convertDTOToEntity(input);
                    bugDao.updateBug(newBug);
                    try {
                        this.notificationFacade.createNotification(
                                NotificationType.BUG_UPDATED,
                                new NotificationParamsBugUpdate(
                                        newBug.getCreated().getUsername(),
                                        newBug.getAssigned().getUsername(),
                                        newBug),
                                newBug.getCreated().getId(), newBug.getAssigned().getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                throw new BusinessWebAppException(MessageCatalog.BUG_INVALID_STATUS, 400);
            }

        }
//        newBug = bugConverter.convertDTOToEntity(input);
//              bugDao.updateBug(newBug);


        return newBug;

    }


}
