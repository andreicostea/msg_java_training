package msg.permission.entity.dto;

import msg.permission.PermissionEntity;

import javax.ejb.Stateless;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
public class PermissionConverter {
    public PermissionEntity convertInputDTOtoEntity(PermissionDTO permissionDTO) {
        final PermissionEntity u = new PermissionEntity();
        u.setType(permissionDTO.getType());
        u.setDescription(permissionDTO.getDescription());
        u.setId(permissionDTO.getId());
        return u;
    }

    public PermissionDTO convertEntityToInputDTO(PermissionEntity permissionEntity) {
        final PermissionDTO permissionDTO = new PermissionDTO();
        permissionDTO.setType(permissionEntity.getType());
        permissionDTO.setDescription(permissionEntity.getDescription());
        permissionDTO.setId(permissionEntity.getId());
        return permissionDTO;
    }
}

