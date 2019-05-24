package msg.permission.entity.dao;

import msg.permission.PermissionEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

    public String removePermission(long id) {
//        PermissionEntity permissionEntity=em.find(PermissionEntity.class,id);
//        em.remove(permissionEntity);
        em.remove(findById(id));
        return "Deleted successfully!";
    }

    //    public PermissionEntity deleteById(long id){
//        return em.createNamedQuery(PermissionEntity.PERMISSION_DELETE_BY_ID, PermissionEntity.class)
//                .setParameter(PermissionEntity.INPUT_ID, id)
//                .getSingleResult();
//    }
//    public void removePermission(long id){
////        PermissionEntity permissionEntity=em.find(PermissionEntity.class,id);
////        em.remove(permissionEntity);
//        deleteById(id);
//
//    }
    public boolean existsId(Long id) {
        PermissionEntity count = em.createNamedQuery(PermissionEntity.PERMISSION_FIND_BY_ID, PermissionEntity.class)
                .setParameter(PermissionEntity.INPUT_ID, id)
                .getSingleResult();
        return (count != null);
    }

    public PermissionEntity findById(long id) {
        return em.createNamedQuery(PermissionEntity.PERMISSION_FIND_BY_ID, PermissionEntity.class)
                .setParameter(PermissionEntity.INPUT_ID, id)
                .getSingleResult();
    }

    public List<PermissionEntity> getPermissionByTypeList(final List<String> typeList) {
        return em.createNamedQuery(PermissionEntity.QUERY_GET_PERMISSION_BY_TYPE_LIST, PermissionEntity.class)
                .setParameter(PermissionEntity.INPUT_TYPE_LIST, typeList)
                .getResultList();
    }
}
