// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.role.control;

import msg.role.entity.RoleEntity;
import msg.role.entity.dao.RoleDAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Control operations for all the RoleEntity related operations.
 *
 * @author msg-system ag;
 * @since 1.0
 */
@Stateless
public class RoleControl {

    @EJB
    private RoleDAO roleDao;

    /**
     * Given a input list of {@link RoleEntity#getType()}s, returns the corresponding list of RoleEntity Entities.
     *
     * @param typeList a list of role types.
     * @return a list of role entities.
     */
    public List<RoleEntity> getRolesByTypeList(List<String> typeList) {
        return roleDao.getRolesByTypeList(typeList);
    }
}
