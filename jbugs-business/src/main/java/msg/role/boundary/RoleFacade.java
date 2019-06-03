package msg.role.boundary;

import msg.role.control.RoleControl;
import msg.role.entity.RoleEntity;
import msg.role.entity.dto.RoleDTO;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RoleFacade {

    @EJB
    private RoleControl roleControl;

    public List<RoleDTO> getAll() {
        return this.roleControl.getAll();
    }

    public List<String> getAllRolesType(){
        return this.roleControl.getAllRolesByType();
    }
}
