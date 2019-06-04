// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.user.control;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import msg.exceptions.BusinessException;
import msg.exceptions.BusinessWebAppException;
import msg.notification.boundary.NotificationFacade;
import msg.notification.boundary.notificationParams.NotificationParamsWelcomeUser;
import msg.notification.entity.NotificationType;
import msg.permission.PermissionEntity;
import msg.role.entity.RoleEntity;
import msg.user.MessageCatalog;

import msg.user.entity.dto.*;


import msg.user.entity.UserEntity;
import msg.user.entity.dao.UserDAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Control operations for all the User related operations.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
@Stateless
public class UserControl {

    @EJB
    private UserDAO userDao;

    @EJB
    private UserConverter userConverter;

    @EJB
    private NotificationFacade notificationFacade;

//    @EJB
//    private RoleControl roleControl;


    public UserOutputDto authenticateUser(UserLoginDTO userLoginDTO) {



            UserDTO user = loginUser(userLoginDTO);

            UserEntity userEntity = userDao.getUserByEmail(user.getEmail());

            if (userEntity != null) {

                ArrayList<String> permissionsAsList = new ArrayList<>();
                Set<PermissionEntity> permissions = new HashSet<>();
                for (RoleEntity roleEntity : userEntity.getRoles()) {
                    for (PermissionEntity permissionEntity : roleEntity.getPermissions()) {
                        permissions.add(permissionEntity);
                    }
                }
                Algorithm algorithm = Algorithm.HMAC256("harambe");
                String jwt =  JWT.create().withIssuer("auth0")
                        .withClaim("id",userEntity.getId())
                        .withClaim("username", userEntity.getUsername())
                        .withArrayClaim("permissions", permissions
                                .stream()
                                .map(PermissionEntity::getType).toArray(String[]::new))
                        .sign(algorithm);
                for (PermissionEntity perm:permissions){
                    permissionsAsList.add(perm.getType());
                }
                UserOutputDto userOutputDto = new UserOutputDto(userEntity.getEmail(),userEntity.getUsername(),permissionsAsList,jwt);


                return userOutputDto;

            } else {
                throw new BusinessException(MessageCatalog.USER_INVALID_USERNAME_OR_PASSWORD);
            }


    }

    /**
     * Creates a userDTO based on the {@link UserInputDTO}.
     *
     * @param userDTO the input User DTO. mandatory
     * @return the username of the newly created user.
     */

    public String createUser(final UserInputDTO userDTO) {
        if(userDTO.getFirstName() == null || userDTO.getLastName() == null || userDTO.getEmail() == null ||
                userDTO.getMobileNumber() == null || userDTO.getRoles().isEmpty())
                 throw new BusinessWebAppException(MessageCatalog.USER_FIELDS_MISSING, 400);

        if (userDao.existsEmail(userDTO.getEmail()))
            throw new BusinessWebAppException(MessageCatalog.USER_WITH_SAME_MAIL_EXISTS, 400);


        final UserEntity newUserEntity = userConverter.convertInputDTOtoEntity(userDTO);

        newUserEntity.setUsername(this.createUserName(userDTO.getFirstName(), userDTO.getLastName()));
        newUserEntity.setStatus(true);
        newUserEntity.setPassword("DEFAULT_PASSWORD");
        newUserEntity.setCounter(5);
        try{
            userDao.createUser(newUserEntity);
        }catch (Exception e){
            throw new BusinessWebAppException(MessageCatalog.USER_INVALID_PATTERN, 400);
        }

        final long id = userDao.getUserByEmail(userDTO.getEmail()).getId();
        final String userFullName = newUserEntity.getFirstName() + " " + newUserEntity.getLastName();
//        = newUserEntity.getId();
        this.notificationFacade.createNotification(
                NotificationType.WELCOME_NEW_USER,
                new NotificationParamsWelcomeUser(userFullName, newUserEntity.getUsername()), id);

        return newUserEntity.getUsername();
    }

    /**
     * Creates a unique user name based on the inputs.
     *
     * @param firstName the first name of the user. mandatory
     * @param lastName  the last name of the user. mandatory
     * @return a unique identifier for the input user.
     */
    //TODO Replace with logic based on the specification
    private String createUserName(final String firstName, final String lastName) {
        String username = "";

            String lastNameBuild = lastName;
            String firstNameBuild = firstName;
            while(lastNameBuild.length() < 5) lastNameBuild += "-";
            while(firstNameBuild.length() < 5) firstNameBuild += "-";

            username = generateUsernameNormal(firstNameBuild, lastNameBuild);

            if(username.equals("")){
                username = generateUsernameWithNumber(firstNameBuild, lastNameBuild);

                if(username.equals("")){
                    username = generateUserNameRandom();
            }
        }

        return username;

    }

    private String generateUsernameWithNumber(String firstName, String lastName) {
        String username = lastName.substring(0, 5);
        for(int i = 0; i <= 99999; i++){
            int count = 4;
            String username1 = username + i;
            while(username1.length() > 6) username1 = username.substring( 0, --count) + i;

            if(!userDao.exitsUsername(username1.toLowerCase())){
               return username1.toLowerCase();
            }


        }
        return "";
    }

    public String generateUsernameNormal(String firstName, String lastName){

        int counterLastName = 6;
        int counterFirstName = 0;
        String username ="";
        //cand lastname e suficient
        if(lastName.length() > 4){
            do{
                if(counterLastName == 1) {
                    username = ""; break;
                }
                username = lastName.substring(0,--counterLastName)
                        + firstName.substring(0,++counterFirstName);
            }while(userDao.exitsUsername(username.toLowerCase()));


        }else {

            if (firstName.length() + lastName.length() >= 6) {

                username = lastName + firstName.substring(0, 6 - lastName.length());
                int lastNameLength = lastName.length();
                while (userDao.exitsUsername(username.toLowerCase())) {
                    if(lastNameLength == 1){
                        username = ""; break;
                    }

                    username = lastName.substring(0, --lastNameLength)
                            + firstName.substring(0, 6 - lastNameLength);
                }

            }
        }
        return username.toLowerCase();
    }

    private String generateUserNameRandom() {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int count = 8;
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();

    }




    public UserDTO loginUser(UserLoginDTO userLoginDTO) {
        UserEntity userEntity;
        try{
            userEntity  = userDao.getUserByUsername(userLoginDTO.getUsername());

        }catch (Exception e){
            throw new BusinessException(MessageCatalog.USER_INVALID_USERNAME_OR_PASSWORD);
        }
        //verify password
        if (userEntity.getStatus()) {

            if (!userEntity.getPassword().equals(userLoginDTO.getPassword())){
                // subtract the counter and throw message
                if(userEntity.getCounter() > 1){

                    int counter = userEntity.getCounter() - 1;
                    userEntity.setCounter(counter);
                    userDao.updateUser(userEntity);

                    throw new BusinessWebAppException(MessageCatalog.USER_INVALID_USERNAME_OR_PASSWORD, 400);
                    // username inactive
                }else{
                    userEntity.setStatus(false);
                    userEntity.setCounter(0);
                    userDao.updateUser(userEntity);
                    throw new BusinessWebAppException(MessageCatalog.USER_INACTIVE, 403);

                }
                //success and reset the counter if necessary
            }else{
                if(userEntity.getCounter() != 5){
                    userEntity.setCounter(5);
                    userDao.updateUser(userEntity);
                }
            }


        }else{
            throw new BusinessWebAppException(MessageCatalog.USER_INACTIVE, 403);
        }
        return userConverter.convertEntityDTO(userEntity);
    }

    public List<UserDTO> getAll(){
        return userDao.getAll().stream()
                .map(userConverter::convertEntityDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(long id) {
        UserEntity user;
        try {
            user = userDao.getUserById(id);
        } catch (Exception e) {
            throw new BusinessException(MessageCatalog.USER_WITH_THAT_ID_DOES_NOT_EXIST);
        }
        return userConverter.convertEntityDTO(user);

    }

    // todo: notification USER_UPDATED
    public void updateUser(UserUpdateDTO userUpdateDTO) {
        UserEntity userToUpdate = userDao.getUserByEmail(userUpdateDTO.getEmailBeforeUpdate());
        userToUpdate.setFirstName(userUpdateDTO.getFirstName());
        userToUpdate.setLastName(userUpdateDTO.getLastName());
            userToUpdate.setEmail(userUpdateDTO.getEmail());
        userToUpdate.setMobileNumber(userUpdateDTO.getMobileNumber());
        userToUpdate.setStatus(userUpdateDTO.getStatus());
//        userToUpdate.setRoles(roleControl.getRolesByTypeList(userUpdateDTO.getRoles()));
        userDao.updateUser(userToUpdate);
    }

    // todo: notification USER_DELETED
    public void deactivateUser(long id) {
        try {
            UserEntity userToDeactivate = userDao.getUserById(id);
            userToDeactivate.setStatus(false);
            userDao.updateUser(userToDeactivate);
        } catch (Exception e) {
            throw new BusinessException(MessageCatalog.USER_WITH_THAT_ID_DOES_NOT_EXIST);
        }
        // if no bugs assigned then deactivate
        // else throw exception
    }
}
