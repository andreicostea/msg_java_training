package msg.role.entity.dto;

import msg.permission.PermissionEntity;
import msg.permission.control.PermissionControl;
import msg.permission.entity.dto.PermissionConverter;
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
    @EJB
    PermissionConverter permissionConverter;

    public RoleEntity convertInputDTOtoEntity(RoleDTO roleDTO) {
        final RoleEntity r = new RoleEntity();
        r.setType(roleDTO.getType());
        r.setPermissions(new ArrayList<>());
        return r;
    }

    public RoleDTO convertInputEntityToDTO(RoleEntity roleEntity) {
        final RoleDTO r = new RoleDTO();
        r.setId(roleEntity.getId());
        r.setType(roleEntity.getType());
        r.setPermissions(new ArrayList<>());

        for (PermissionEntity permissionEntity : roleEntity.getPermissions()) {
            r.getPermissions()
                    .add(permissionConverter.convertEntityToInputDTO(permissionEntity));
        }
        return r;
    }

}

