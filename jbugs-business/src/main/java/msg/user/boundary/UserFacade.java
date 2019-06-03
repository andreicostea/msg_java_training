// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.user.boundary;

import msg.user.control.UserControl;
import msg.user.entity.dto.UserDTO;
import msg.user.entity.dto.UserInputDTO;
import msg.user.entity.dto.UserLoginDTO;
import msg.user.entity.dto.UserUpdateDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Facade for all operations on Users.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
@Stateless
public class UserFacade {

    @EJB
    private UserControl userControl;

    /**
     * Creates a user based on the {@link UserInputDTO}.
     *
     * @param userInputDto the input User DTO. mandatory
     */
    //@RolesAllowed(PermissionType.USER_MANAGEMENT)
    public Object authenticateUser(UserLoginDTO userLoginDTO) {
        return userControl.authenticateUser(userLoginDTO);
    }

    public void createUser(UserInputDTO user) {
        this.userControl.createUser(user);
    }

    public void updateUser(UserUpdateDTO userUpdateDTO) {
        this.userControl.updateUser(userUpdateDTO);
    }

    public void loginUser(UserLoginDTO userLoginDTO) {

        this.userControl.loginUser(userLoginDTO);
    }

    public List<UserDTO> getAll() {
        return this.userControl.getAll();
    }

    public UserDTO getUserById(long id) {
        return this.userControl.getUserById(id);
    }
}
