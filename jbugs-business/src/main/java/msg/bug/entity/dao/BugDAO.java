package msg.bug.entity.dao;

import msg.bug.entity.BugEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BugDAO {
    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;

    public BugEntity createBug(BugEntity bug) {
        em.persist(bug);
        return bug;
    }

    public List<BugEntity> getAll() {
        return em.createNamedQuery(BugEntity.BUG_GET_ALL, BugEntity.class).getResultList();
    }

    public void updateBug(BugEntity newBug) {
        BugEntity oldBug = em.createNamedQuery(BugEntity.BUG_FIND_BY_ID, BugEntity.class).getSingleResult();
        if (newBug.getTitle().length() != 0)
        {
            em.setProperty(BugEntity.TITLE, newBug.getTitle());
        }
        if (newBug.getDescription().length() != 0)
        {
            em.setProperty(BugEntity.DESCRIPTION, newBug.getDescription());
        }
        if(newBug.getVersion().length() != 0)
        {
            em.setProperty(BugEntity.VERSION, newBug.getVersion());
        }
        if(newBug.getFixedVersion().length() != 0)
        {
            em.setProperty(BugEntity.FIXEDVERSION, newBug.getFixedVersion());
        }
        if(newBug.getSeverity().length() != 0)
        {
            em.setProperty(BugEntity.SEVERITY, newBug.getSeverity());
        }
        if(newBug.getStatus().length() != 0)
        {
            em.setProperty(BugEntity.STATUS, newBug.getStatus());
        }
    }
}
