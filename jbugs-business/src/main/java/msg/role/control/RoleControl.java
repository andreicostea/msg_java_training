// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.role.control;

import msg.exceptions.BusinessException;
import msg.exceptions.BusinessWebAppException;
import msg.permission.PermissionEntity;
import msg.permission.boundary.PermissionFacade;
import msg.permission.entity.dao.PermissionDAO;
import msg.permission.entity.dto.PermissionConverter;
import msg.permission.entity.dto.PermissionDTO;
import msg.role.entity.RoleEntity;
import msg.role.entity.dao.RoleDAO;
import msg.role.entity.dto.RoleConverter;
import msg.role.entity.dto.RoleDTO;
import msg.user.MessageCatalog;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

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
    @EJB
    private RoleConverter roleConverter;


    @EJB
    private PermissionFacade permissionFacade;
    @EJB
    private PermissionConverter permissionConverter;
    @EJB
    private PermissionDAO permissionDAO;


    /**
     * Given a input list of {@link RoleEntity#getType()}s, returns the corresponding list of RoleEntity Entities.
     *
     * @param typeList a list of role types.
     * @return a list of role entities.
     */
    public List<RoleEntity> getRolesByTypeList(List<String> typeList) {
        return roleDao.getRolesByTypeList(typeList);
    }

    public List<RoleDTO> getAll() {
        return roleDao.getAll().stream()
                .map(roleConverter::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<String> getAllRolesByType() {
        return roleDao.getAllRolesByType();
    }


    public RoleEntity addPermission(long id, PermissionDTO permissionDTO) {
        RoleEntity permissionEntities = roleDao.getRoleById(id);
        for (PermissionEntity permission : permissionEntities.getPermissions()) {
            if (permission.getType().equals(permissionDTO.getType())) {
                throw new BusinessWebAppException(MessageCatalog.ROLE_WITH_SAME_PERMISSION_EXISTS, 411);
            }
        }
        final PermissionEntity permissionEntity = permissionConverter.convertInputDTOtoEntity(permissionDTO);
        permissionEntity.setDescription(permissionDTO.getDescription());
        permissionEntity.setType(permissionDTO.getType());
        PermissionEntity newPermission = permissionDAO.createPermission(permissionEntity);
        RoleEntity roleEntity = roleDao.getRoleById(id);
        return roleDao.addPermission(roleEntity, newPermission);
    }

    public RoleEntity getRoleById(long id) {
        RoleEntity roleEntity;
        try {
            roleEntity = roleDao.getRoleById(id);
        } catch (Exception e) {
            throw new BusinessException(MessageCatalog.USER_WITH_THIS_ROLE_DONT_HAVE_PERMISSIONS);
        }
        //roleEntity.addPermission();
        return roleEntity;
    }

    public List<RoleDTO> getRolesAndPermissions() {
        List<RoleEntity> roleEntity2 = roleDao.getAllRolesAndPermissions();
        List<RoleDTO> collect = roleEntity2.stream().map(roleConverter::convertInputEntityToDTO).collect(Collectors.toList());
        return collect;
    }
}
//    public List<String> getAllRolesAndPermissions(RoleDTO roleDTO, PermissionDTO permissionDTO){
//    }

//    public List<String> getRolesAndPermissions() {
//        int n = 4;
//        List<String> rolesandpermissions = null;
//        for (int i = 0; i < n; i++) {
//            rolesandpermissions = (List<String>) this.getRoleById(i);
//            return null;
//        }
//        return rolesandpermissions;
//    }


//    public List<PermissionEntity> getPermission(List<String> permissionEntityList){
//        return roleDao.getPermission(permissionEntityList);
//    }
