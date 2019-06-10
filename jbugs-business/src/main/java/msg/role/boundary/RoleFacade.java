package msg.role.boundary;

import msg.permission.entity.dto.PermissionDTO;
import msg.role.control.RoleControl;
import msg.role.entity.RoleEntity;
import msg.role.entity.dto.RoleDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
public class RoleFacade {
    @EJB
    private RoleControl roleControl;

    public RoleDTO getRoleById(long id) {
        return this.roleControl.getRoleById(id);
    }

    public List<RoleDTO> getAllRolesAndPermissions() {
        return this.roleControl.getRolesAndPermissions();
    }

    public RoleEntity addPermission(long id, PermissionDTO permissionDTO) {
        return this.roleControl.addPermission(id, permissionDTO);
    }

    public List<String> getAllRolesType() {
        return this.roleControl.getAllRolesByType();
    }

}

