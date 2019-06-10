package msg.bug.control;

import msg.bug.entity.BugEntity;
import msg.bug.entity.dao.BugDAO;
import msg.bug.entity.dto.BugConverter;
import msg.bug.entity.dto.BugInputDTO;

import msg.notification.boundary.NotificationFacade;
import msg.notification.boundary.notificationParams.NotificationParams;
import msg.notification.boundary.notificationParams.NotificationParamsBugCreate;
import msg.notification.entity.NotificationType;
import msg.role.entity.RoleEntity;
import msg.user.entity.UserEntity;
import msg.user.entity.dao.UserDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;


public class BugControlTest {


    BugControl bugControl;
    @Mock
    EntityManager em;
    @Mock
    BugConverter bugConverter;
    @Mock
    UserDAO userDao;
    @Mock
    NotificationFacade notificationFacade;

    @Mock
    BugDAO bugDao;

    BugInputDTO bug = new BugInputDTO(
            "bugtest",
            "descriere bug",
            "v1.0",
            "2019-10-10T21:00:00.000Z",
            "v1.2",
            "high",
            1L,1L);

    @Before
    public void init(){
        bugControl = new BugControl();
        bugConverter = Mockito.mock(BugConverter.class);
        userDao = new UserDAO();
        bugDao = Mockito.mock(BugDAO.class);
        notificationFacade = Mockito.mock(NotificationFacade.class);
        //bugConverter=Mockito.mock(BugConverter.class);
        try {
            FieldSetter.setField(bugControl,
                    BugControl.class.getDeclaredField("bugConverter"),
                    bugConverter);

            FieldSetter.setField(bugControl,
                    BugControl.class.getDeclaredField("bugDao"),
                    bugDao);
            FieldSetter.setField(bugControl,
                    BugControl.class.getDeclaredField("notificationFacade"),
                    notificationFacade);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void getAll() {
    }

    @Test
    public void createBug() {
        BugEntity bugEntity = new BugEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUsername("Lore");
        userEntity.setEmail("lore@msggroup.com");
        userEntity.setFirstName("Lorena");
        userEntity.setLastName("S");
        userEntity.setPassword("lore");
        userEntity.setStatus(1);
        userEntity.setMobileNumber("+40123456789");
        bugEntity.setCreated(userEntity);


        Mockito.when(bugConverter.convertInputDTOToEntity(bug)).thenReturn(bugEntity);
        bugEntity.setCreated(userEntity);


        Assert.assertEquals(bugEntity, this.bugControl.createBug(bug));

    }

    @Test
    public void updateBug() {
    }
}