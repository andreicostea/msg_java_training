// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.role.control;

import msg.role.entity.Role;
import msg.role.entity.RoleDao;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Control operations for all the Role related operations.
 *
 * @author msg-system ag;
 * @since 1.0
 */
@Stateless
public class RoleControl {

    @EJB
    private RoleDao roleDao;

    /**
     * Given a input list of {@link Role#getType()}s, returns the corresponding list of Role Entities.
     *
     * @param typeList a list of role types.
     * @return a list of role entities.
     */
    public List<Role> getRolesByTypeList(List<String> typeList){
        return roleDao.getRolesByTypeList(typeList);
    }
}
