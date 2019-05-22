package msg.permission.entity.dao;

import msg.permission.entity.PermissionEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The DAO for the PermissionType Entities.
 *
 * @author msg systems AG;
 * @since 19.1.2
 */
@Stateless
public class PermissionDAO {

    @PersistenceContext(unitName="persistenceUnit")
    private EntityManager em;

    /**
     * Persists a permission entity.
     *
     * @param p the input entity to be saved.
     * @return the persisted entity.
     */
    public PermissionEntity createPermission(PermissionEntity p){
        em.persist(p);
        return p;
    }


    public void removePermission(PermissionEntity p){
        em.remove(p);
    }
}
