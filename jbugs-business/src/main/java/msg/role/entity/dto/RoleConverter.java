package msg.role.entity.dto;

import msg.role.entity.RoleEntity;

import javax.ejb.Stateless;

@Stateless
public class RoleConverter {

    public RoleDTO convertEntityToDTO(RoleEntity roleEntity){
        final RoleDTO roleDTO = new RoleDTO();
        roleDTO.setType(roleEntity.getType());
        roleDTO.setId(roleEntity.getId());

        return roleDTO;
    }
}
