// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.role.entity.dao;

import msg.permission.PermissionEntity;
import msg.role.entity.RoleEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

/**
 * The DAO for the RoleEntity Entities.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
@Stateless
public class RoleDAO {

    @PersistenceContext(unitName = "persistenceUnit", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    /**
     * Given a input list of {@link RoleEntity#getType()}s, returns the corresponding list of RoleEntity Entities.
     *
     * @param typeList a list of role types.
     * @return a list of role entities.
     */
    public List<RoleEntity> getRolesByTypeList(final List<String> typeList) {
        return em.createNamedQuery(RoleEntity.QUERY_GET_ROLES_BY_TYPE_LIST, RoleEntity.class)
                .setParameter(RoleEntity.INPUT_TYPE_LIST, typeList)
                .getResultList();
    }

    public RoleEntity getRoleById(final long id) {
        return em.createNamedQuery(RoleEntity.QUERY_GET_ROLE_BY_ID, RoleEntity.class)
                .setParameter(RoleEntity.INPUT_ID, id)
                .getSingleResult();
    }

    public List<RoleEntity> getAllRolesAndPermissions() {
        List<RoleEntity> roleEntities = em.createNamedQuery(RoleEntity.GET_PERMISSIONSANDROLES, RoleEntity.class)
                .getResultList();
//        roleEntities.stream().forEach((roleEntity -> {
//            this.em.refresh(roleEntity);
//        }));
        return roleEntities;
    }

    public RoleEntity addPermission(RoleEntity roleEntity, PermissionEntity permissionEntity) {
        roleEntity.getPermissions().add(permissionEntity);
        //ca sa faca update
        return em.merge(roleEntity);
    }

//    public List<PermissionEntity> getPermission(final List<String> permissionEntityList){
//        return em.createNamedQuery(RoleEntity.GET_PERMISSIONS,PermissionEntity.class)
//                .setParameter(RoleEntity.INPUT_TYPE_LIST,permissionEntityList)
//                .getResultList();
//    }


    public List<RoleEntity> getAll() {
        return em.createNamedQuery(RoleEntity.GET_ALL_ROLES, RoleEntity.class).getResultList();
    }

    public List<String> getAllRolesByType() {
        return em.createNamedQuery(RoleEntity.GET_ALL_ROLES_TYPE, String.class)
                .getResultList();
    }


}
