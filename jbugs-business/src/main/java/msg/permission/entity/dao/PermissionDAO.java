package msg.permission.entity.dao;

import msg.permission.PermissionEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * The DAO for the PermissionType Entities.
 *
 * @author msg systems AG;
 * @since 19.1.2
 */
@Stateless
public class PermissionDAO {

    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;

    /**
     * Persists a permission entity.
     *
     * @param p the input entity to be saved.
     * @return the persisted entity.
     */
    public PermissionEntity createPermission(PermissionEntity p) {
        em.persist(p);
        return p;
    }

    public String removePermission(long id) {
        em.remove(findById(id));
        em.flush();
        return "Deleted successfully!";
    }
    public boolean existsId(Long id) {
        try {
            return em.createNamedQuery(PermissionEntity.PERMISSION_FIND_BY_ID, PermissionEntity.class)
                    .setParameter(PermissionEntity.INPUT_ID, id)
                    .getSingleResult() != null;

        } catch (NoResultException N) {
            return false;
        }
    }

    public PermissionEntity findById(long id) {
        return em.createNamedQuery(PermissionEntity.PERMISSION_FIND_BY_ID, PermissionEntity.class)
                .setParameter(PermissionEntity.INPUT_ID, id)
                .getSingleResult();
    }
    public List<PermissionEntity> getAll() {
        return em.createNamedQuery(PermissionEntity.PERMISSION_FIND_ALL, PermissionEntity.class)
                .getResultList();
    }
}
