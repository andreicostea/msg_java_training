// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.role.entity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The DAO for the Role Entities.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
@Stateless
public class RoleDao {

    @PersistenceContext(unitName="jbugs-persistence")
    private EntityManager em;

    /**
     * Given a input list of {@link Role#getType()}s, returns the corresponding list of Role Entities.
     *
     * @param typeList a list of role types.
     * @return a list of role entities.
     */
    public List<Role> getRolesByTypeList(final List<String> typeList){
        return em.createNamedQuery(Role.QUERY_GET_ROLES_BY_TYPE_LIST, Role.class)
                .setParameter(Role.INPUT_TYPE_LIST, typeList)
                .getResultList();
    }
}
