package msg.bug.control;

import msg.bug.entity.BugEntity;
import msg.bug.entity.dao.BugDAO;
import msg.bug.entity.dto.BugConverter;
import msg.bug.entity.dto.BugDTO;
import msg.bug.entity.dto.BugInputDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Stateless
public class BugControl {

    @EJB
    private BugDAO bugDao;

    @EJB
    private BugConverter bugConverter;

    public List<BugDTO> getAll()
    {
        return bugDao.getAll()
                .stream()
                .map(bugConverter::convertEntityDTOtoEntity)
                .collect(Collectors.toList());
    }

    public BugEntity createBug(BugInputDTO bug) {
        if (bug.getTitle() == null || bug.getDescription() == null || bug.getVersion() == null || bug.getSeverity() == null)
        {
            //field shouldn't be empty, not sure if it should be here
        }
        if (bug.getDescription().length() > 250)
        {
            //description exceeds maximum allowed characters
        }
        //todo: check if below code works [fingers crossed]
        Pattern pattern = Pattern.compile("[A-Za-z0-9.]*");
        Matcher matcher = pattern.matcher(bug.getVersion());
        if (!matcher.matches())
        {
            //version incorrectly formatted
        }

        final BugEntity newBug = bugConverter.convertInputDTOToEntity(bug);
        newBug.setStatus("New");
        return newBug;
    }
}
