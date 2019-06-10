package msg.permission.control;

import msg.exceptions.BusinessWebAppException;
import msg.permission.entity.dao.PermissionDAO;
import msg.permission.entity.dto.PermissionConverter;
import msg.permission.entity.dto.PermissionDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@RunWith(MockitoJUnitRunner.class)
public class PermissionControlTest {
    @InjectMocks
    PermissionControl permissionControl;
    @Mock
    PermissionDAO permissionDAO;
    @Mock
    List<PermissionDTO> mockList;
    @Mock
    PermissionConverter permissionConverter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreatePermissionWithSuccess() {
        PermissionDTO permissionDTO = createTestDTO();
        when(permissionConverter.convertInputDTOtoEntity(Mockito.any())).thenCallRealMethod();
        this.permissionControl.createPermission(permissionDTO);
    }

    @Test(expected = BusinessWebAppException.class)
    public void testRemovePermissionWhenIdDoesnotExists() throws Exception {
        PermissionDTO permissionDTO = createTestDTO2();
        when(!permissionDAO.existsId(permissionDTO.getId())).thenReturn(false);
    }

    @Test(expected = BusinessWebAppException.class)
    public void RemovePermissionsWithSucces() throws Exception {
        PermissionDTO permissionDTO = createTestDTO();
        Mockito.when(permissionConverter.convertInputDTOtoEntity(Mockito.any())).thenCallRealMethod();
        when(this.permissionControl.removePermission(permissionDTO.getId())).thenCallRealMethod();
    }

    @Test
    public void getAllPermissions() {
        PermissionDTO permissionDTO = new PermissionDTO();
        permissionDTO.setType("PERMISSION_MANAGEMENT");
        permissionDTO.setDescription("Can add or remove permissions");
        when(mockList.get(0)).thenReturn(permissionDTO);
        assertEquals("PERMISSION_MANAGEMENT", mockList.get(0).getType());

    }

    private PermissionDTO createTestDTO() {
        PermissionDTO permissionDTO = new PermissionDTO();
        permissionDTO.setDescription("CAN MAKE THE CRUD OPERATIONS FOR A BUG");
        permissionDTO.setType("BUG_MANAGEMENT");
        permissionDTO.setId((long) 62);
        return permissionDTO;
    }

    private PermissionDTO createTestDTO2() {
        PermissionDTO permissionDTO = new PermissionDTO();
        permissionDTO.setDescription("CAN ADD OR REMOVE PERMISSIONS");
        permissionDTO.setType("PERMISSION_MANAGEMENT");
        permissionDTO.setId((long) 111);
        return permissionDTO;
    }
}
