package msg.bug.entity;

import msg.bug.Bug;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BugDao {
    @PersistenceContext(unitName="jbugs-persistence")
    private EntityManager em;

    public List<Bug> getAll()
    {
        return em.createNamedQuery(Bug.BUG_GET_ALL, Bug.class).getResultList();
    }

}
