// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.user.control;

import msg.exceptions.BusinessException;
import msg.notification.boundary.NotificationFacade;
import msg.user.entity.dao.userDao;
import msg.user.entity.dto.UserConverter;
import msg.user.entity.dto.UserInputDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test class for UserControl.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControlTestV2 {

    @InjectMocks
    UserControl userControl;

    @Mock
    userDao userDao;

    @Mock
    UserConverter userConverter;

    @Mock
    NotificationFacade notificationFacade;

    @Before
    public void setUp() {

        try {
            FieldSetter.setField(this.userControl,
                    UserControl.class.getDeclaredField("notificationFacade"),
                    this.notificationFacade);
        } catch (final NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateUserWithSuccess() {
        UserInputDTO user = createTestInputDTO();

        Mockito.when(userConverter.convertInputDTOtoEntity(Mockito.any())).thenCallRealMethod();
        Mockito.when(userDao.existsEmail(user.getEmail())).thenReturn(false);
        //Mockito.doNothing().when(notificationFacade).createNotification(Mockito.any(), Mockito.any());

        this.userControl.createUser(user);
    }

    @Test(expected = BusinessException.class)
    public void testCreateUserWhenEmailAddressAlreadyExists() {
        UserInputDTO user = createTestInputDTO();

        Mockito.when(userDao.existsEmail(user.getEmail())).thenReturn(true);
        //Mockito.doNothing().when(notificationFacade).createNotification(Mockito.any(), Mockito.any());

        this.userControl.createUser(user);
    }

//    @Test
//    public void testCreateUserNotificationSent(){
//        NotificationInputDTO user = createTestInputDTO();
//
//        ArgumentCaptor<NotificationType> sentNotificationType = ArgumentCaptor.forClass(NotificationType.class);
//        Mockito.when(userConverter.convertInputDTOtoEntity(Mockito.any())).thenCallRealMethod();
//        Mockito.when(userDao.existsEmail(user.getEmail())).thenReturn(false);
//        Mockito.doNothing().when(notificationFacade).createNotification(sentNotificationType.capture(), Mockito.any());
//
//        this.userControl.createUser(user);
//        Assert.assertEquals(sentNotificationType.getValue(), NotificationType.WELCOME_NEW_USER);
//    }

    private UserInputDTO createTestInputDTO() {
        UserInputDTO user = new UserInputDTO();
        user.setLastName("Pop");
        user.setFirstName("Andrei");
        user.setEmail("axasde@yahoo.com");
        user.setMobileNumber("0700000000");
        return user;
    }

}
