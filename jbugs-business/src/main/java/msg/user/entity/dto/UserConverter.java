// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.user.entity.dto;

import msg.role.control.RoleControl;
import msg.role.entity.RoleEntity;
import msg.user.entity.UserEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.stream.Collectors;

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

    public UserInputDTO convertToDTO(UserEntity entity) {
        final UserInputDTO u = new UserInputDTO();
        u.setFirstName(entity.getFirstName());
        u.setLastName(entity.getLastName());
        u.setEmail(entity.getEmail());
        u.setRoles(entity.getRoles().stream().map(RoleEntity::getType).collect(Collectors.toList()));
        return u;
    }
}
