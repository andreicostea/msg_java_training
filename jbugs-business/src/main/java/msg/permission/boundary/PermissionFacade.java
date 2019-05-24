package msg.permission.boundary;

import msg.permission.control.PermissionControl;
import msg.permission.entity.dto.PermissionDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
public class PermissionFacade {
    @EJB
    private PermissionControl permissionControl;

    public PermissionDTO createPermission(PermissionDTO permissionDTO) {
        return permissionControl.createPermission(permissionDTO);
    }

    public void removePermission(long id) {
        this.permissionControl.removePermission(id);
    }
}
