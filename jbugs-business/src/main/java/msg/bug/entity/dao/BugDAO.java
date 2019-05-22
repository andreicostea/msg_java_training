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

}
