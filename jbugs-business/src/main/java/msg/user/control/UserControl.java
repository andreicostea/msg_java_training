// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.user.control;

import msg.exeptions.BusinessException;
import msg.notifications.boundary.NotificationFacade;
import msg.notifications.boundary.notificationParams.NotificationParamsWelcomeUser;
import msg.notifications.entity.NotificationType;
import msg.user.MessageCatalog;
import msg.user.entity.dto.UserInputDTO;
import msg.user.entity.UserEntity;
import msg.user.entity.dto.UserConverter;
import msg.user.entity.UserDao;
import msg.user.entity.dto.UserLoginDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Control operations for all the User related operations.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
@Stateless
public class UserControl {

    @EJB
    private UserDao userDao;

    @EJB
    private UserConverter userConverter;

    @EJB
    private NotificationFacade notificationFacade;


    /**
     * Creates a userDTO based on the {@link UserInputDTO}.
     *
     * @param userDTO the input User DTO. mandatory
     * @return the username of the newly created user.
     */
    public String createUser(final UserInputDTO userDTO){
        if (userDao.existsEmail(userDTO.getEmail())){
            throw new BusinessException(MessageCatalog.USER_WITH_SAME_MAIL_EXISTS);
        }

        final UserEntity newUserEntity = userConverter.convertInputDTOtoEntity(userDTO);

        newUserEntity.setUsername(this.createUserName(userDTO.getFirstName(), userDTO.getLastName()));
        newUserEntity.setPassword("DEFAULT_PASSWORD");
        userDao.createUser(newUserEntity);

        final String userFullName = newUserEntity.getFirstName() + " " + newUserEntity.getLastName();
        this.notificationFacade.createNotification(
                NotificationType.WELCOME_NEW_USER,
                new NotificationParamsWelcomeUser(userFullName, newUserEntity.getUsername()));

        return newUserEntity.getUsername();
    }

    /**
     * Creates a unique user name based on the inputs.
     *
     * @param firstName the first name of the user. mandatory
     * @param lastName the last name of the user. mandatory
     * @return a unique identifier for the input user.
     */
    //TODO Replace with logic based on the specification
    private String createUserName(final String firstName, final String lastName){
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int count = 8;
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public void loginUser(UserLoginDTO userLoginDTO) {
        if (!userDao.loginUser(userLoginDTO)){
            throw new BusinessException(MessageCatalog.USER_INVALID_USERNAME_OR_PASSWORD);
        }else{
            System.out.println("ESTE USER");
        }

    }
}
