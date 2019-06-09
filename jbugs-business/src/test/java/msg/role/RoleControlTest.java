package msg.role;

import msg.permission.PermissionEntity;
import msg.role.boundary.RoleResource;
import msg.role.control.RoleControl;
import msg.role.entity.RoleEntity;
import msg.role.entity.dao.RoleDAO;
import msg.role.entity.dto.RoleConverter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
public class RoleControlTest {
    @InjectMocks
    RoleControl roleControl;
    @Mock
    RoleDAO roleDAO;
    @Mock
    List<RoleEntity> mockList;
    @Mock
    RoleConverter roleConverter;
    @Mock
    RoleResource roleResource;
    @Mock
    PermissionEntity permissionEntity;
    @Mock
    RoleEntity roleEntity;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getRoleByid() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId((long) 3);
        roleEntity.setType("TESTER");
        PermissionEntity permissionEntity = new PermissionEntity();
        permissionEntity.setId((long) 1);
        permissionEntity.setType("PERMISSION_MANAGEMENT");
        permissionEntity.setDescription("Can add or remove a permission for a user");
        when(roleEntity.getId()).thenReturn(roleEntity.getId());
        assertEquals(java.util.Optional.of(3), roleEntity.getId());

    }
}
