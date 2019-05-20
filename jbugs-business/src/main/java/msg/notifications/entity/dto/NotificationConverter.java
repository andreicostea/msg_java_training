// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.notifications.entity.dto;

import msg.notifications.entity.NotificationEntity;
import msg.role.control.RoleControl;
import msg.user.entity.UserEntity;
import msg.user.entity.dto.UserInputDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Converts different DOs to UserEntity and vice-versa.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
@Stateless
public class NotificationConverter {

    @EJB
    private RoleControl roleControl;

    /**
     * Converts a {@link UserInputDTO} to {@link UserEntity}.
     *
     * @param userInputDTO the input dto.
     * @return the output un-managed Entity.
     */
//    public NotificationEntity convertInputDTOtoEntity(NotificationInputDTO notificationInputDTO){
//        final NotificationEntity notificationEntity = new NotificationEntity();
//        notificationEntity.setUserID(notificationInputDTO.getUserId());
//        notificationEntity.setDate(notificationInputDTO.getDate());
//        notificationEntity.setNotificationType(notificationInputDTO.getNotificationType());
//        notificationEntity.setMessage(notificationInputDTO.getMessage());
//
//
//        if (userInputDTO.getRoles() != null && !userInputDTO.getRoles().isEmpty()){
//            u.getRoles().addAll(
//                    roleControl.getRolesByTypeList(userInputDTO.getRoles()));
//        }
//        return u;
//    }
    public NotificationDTO convertEntityToDTO(NotificationEntity notificationEntity) {
        final NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setDate(notificationEntity.getDate());
        notificationDTO.setMessage(notificationEntity.getMessage());
        notificationDTO.setNotificationType(notificationEntity.getNotificationType());
        notificationDTO.setUrlBug(notificationEntity.getUrl());

        return notificationDTO;
    }

}
