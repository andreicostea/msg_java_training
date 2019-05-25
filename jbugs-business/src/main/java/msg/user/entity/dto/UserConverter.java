// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.user.entity.dto;

import msg.role.control.RoleControl;
import msg.user.entity.UserEntity;

import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

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

    /**
     * Converts a {@link UserInputDTO} to {@link UserEntity}.
     *
     * @param userInputDTO the input dto.
     * @return the output un-managed Entity.
     */
    public UserEntity convertInputDTOtoEntity(UserInputDTO userInputDTO){
        final UserEntity u = new UserEntity();
        u.setFirstName(userInputDTO.getFirstName());
        u.setLastName(userInputDTO.getLastName());
        u.setEmail(userInputDTO.getEmail());
        u.setMobileNumber(userInputDTO.getMobileNumber());
        u.setRoles(new ArrayList<>());

        if (userInputDTO.getRoles() != null && !userInputDTO.getRoles().isEmpty()){
            u.getRoles().addAll(
                    roleControl.getRolesByTypeList(userInputDTO.getRoles()));
        }
        return u;
    }

    public UserDTO convertEntityDTO(UserEntity userEntity){
        final UserDTO u = new UserDTO();
        u.setFirstName(userEntity.getFirstName());
        u.setLastName(userEntity.getLastName());
        u.setEmail(userEntity.getEmail());
        u.setMobileNumber(userEntity.getMobileNumber());
        return u;
    }

}
