package msg.role.entity.dto;

import msg.permission.control.PermissionControl;
import msg.role.entity.RoleEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
public class RoleConverter {
    @EJB
    PermissionControl permissionControl;

    public RoleEntity convertInputDTOtoEntity(RoleDTO roleDTO) {
        final RoleEntity r = new RoleEntity();
        r.setType(roleDTO.getType());
        r.setPermissions(new ArrayList<>());

        if (roleDTO.getPermissions() != null && !roleDTO.getPermissions().isEmpty()) {
            r.getPermissions().addAll(
                    permissionControl.getPermissionByTypeList(roleDTO.getPermissions()));
        }
        return r;
    }
}
