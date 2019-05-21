package msg.bug.control;

import msg.bug.Bug;
import msg.bug.entity.BugDao;
import msg.bug.entity.dto.BugConverter;
import msg.bug.entity.dto.BugDTO;
import msg.bug.entity.dto.BugInputDTO;
import msg.exeptions.BusinessException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Stateless
public class BugControl {

    @EJB
    private BugDao bugDao;

    @EJB
    private BugConverter bugConverter;

    public List<BugDTO> getAll()
    {
        return bugDao.getAll()
                .stream()
                .map(bugConverter::convertEntityDTOtoEntity)
                .collect(Collectors.toList());
    }

    public Bug createBug(BugInputDTO bug) {
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

        final Bug newBug = bugConverter.convertInputDTOToEntity(bug);
        newBug.setStatus("New");
        return newBug;
    }
}
