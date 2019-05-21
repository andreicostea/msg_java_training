package msg.bug.control;

import msg.bug.entity.BugDao;
import msg.bug.entity.dto.BugConverter;
import msg.bug.entity.dto.BugDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
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

    public void createBug(BugDTO bug) {

    }
}
