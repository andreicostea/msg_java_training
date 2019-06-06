// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.user.entity.dto;

import msg.permission.boundary.PermissionFacade;
import msg.role.control.RoleControl;
import msg.user.entity.UserEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;

/**
 * Converts different DOs to UserEntity and vice-versa.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
@Stateless
public class UserConverter {

    @EJB
    private RoleControl roleControl;
    @EJB
    private PermissionFacade permissionFacade;

    /**
     * Converts a {@link UserInputDTO} to {@link UserEntity}.
     *
     * @param userInputDTO the input dto.
     * @return the output un-managed Entity.
     */
    public UserEntity convertInputDTOtoEntity(UserInputDTO userInputDTO) {
        final UserEntity u = new UserEntity();
        u.setFirstName(userInputDTO.getFirstName());
        u.setLastName(userInputDTO.getLastName());
        u.setEmail(userInputDTO.getEmail());
        u.setMobileNumber(userInputDTO.getMobileNumber());
        u.setRoles(new ArrayList<>());

        if (userInputDTO.getRoles() != null && !userInputDTO.getRoles().isEmpty()) {
            u.getRoles().addAll(
                    roleControl.getRolesByTypeList(userInputDTO.getRoles()));
        }
//        if (userInputDTO.getRoles()!=null && roleControl.getPermission(userInputDTO.getRoles()).equals(PermissionType.PERMISSION_MANAGEMENT)){
        //this.permissionFacade.createPermission();
//        };

        return u;
    }

    public UserDTO convertEntityDTO(UserEntity userEntity) {
        final UserDTO u = new UserDTO();
        u.setId(userEntity.getId());
        u.setUserName(userEntity.getUsername());
        u.setFirstName(userEntity.getFirstName());
        u.setLastName(userEntity.getLastName());
        u.setEmail(userEntity.getEmail());
        u.setMobileNumber(userEntity.getMobileNumber());
//        u.setRoles((ArrayList<RoleEntity>)userEntity.getRoles());
        return u;
    }

//    public UserEntity convertUpdateDTOToEntity(UserUpdateDTO userUpdateDTO) {
//        final UserEntity userEntity = new UserEntity();
//        userEntity.setFirstName(userUpdateDTO.getFirstName());
//        userEntity.setLastName(userUpdateDTO.getLastName());
//        userEntity.setEmail(userUpdateDTO.getEmail());
//        userEntity.setMobileNumber(userUpdateDTO.getMobileNumber());
//        userEntity.setRoles(new ArrayList<>());
//
//        if (userUpdateDTO.getRoles() != null && !userUpdateDTO.getRoles().isEmpty()) {
//            userEntity.getRoles().addAll(
//                    roleControl.getRolesByTypeList(userUpdateDTO.getRoles()));
//        }
//        return userEntity;
//    }
}
