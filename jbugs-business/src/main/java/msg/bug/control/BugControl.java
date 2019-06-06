package msg.bug.control;

import msg.bug.entity.BugEntity;
import msg.bug.entity.StatusType;
import msg.bug.entity.dao.BugDAO;
import msg.bug.entity.dto.BugConverter;
import msg.bug.entity.dto.BugDTO;
import msg.bug.entity.dto.BugInputDTO;
import msg.exceptions.BusinessException;
import msg.exceptions.BusinessWebAppException;
import msg.notification.boundary.NotificationFacade;
import msg.user.MessageCatalog;
import msg.user.entity.dao.UserDAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
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
        if (bug.getTitle() == null || bug.getDescription() == null || bug.getVersion() == null || bug.getSeverity() == null) {
            throw new BusinessException(NULL_FIELD);
        }
        if (bug.getTitle().length() == 0 || bug.getDescription().length() == 0 || bug.getVersion().length() == 0 || bug.getSeverity().length() == 0) {
            throw new BusinessException(NULL_FIELD);
        }
        if (bug.getDescription().length() > 250) {
            throw new BusinessException(LIMIT_EXCEEDED);
        }

        final BugEntity newBug = bugConverter.convertInputDTOToEntity(bug);
        newBug.setStatus(String.valueOf(StatusType.NEW));
        try {
            bugDao.createBug(newBug);
        } catch (Exception e) {
            throw new BusinessWebAppException(MessageCatalog.BUG_INVALID_PATTERN, 400);
        }


        return newBug;
    }

    public BugEntity updateBug(BugDTO input) {
        if (input.getStatus() != null) {


        }
        final BugEntity newBug = bugConverter.convertDTOToEntity(input);
        bugDao.updateBug(newBug);
        return newBug;

    }
}
