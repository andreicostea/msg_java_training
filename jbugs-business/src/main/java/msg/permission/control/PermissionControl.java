package msg.permission.control;

import msg.exceptions.BusinessWebAppException;
import msg.permission.PermissionEntity;
import msg.permission.entity.dao.PermissionDAO;
import msg.permission.entity.dto.PermissionConverter;
import msg.permission.entity.dto.PermissionDTO;
import msg.user.MessageCatalog;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
public class PermissionControl {
    @EJB
    private PermissionDAO permissionDAO;
    @EJB
    private PermissionConverter permissionConverter;

    public PermissionDTO createPermission(final PermissionDTO permissionDTO) {
        final PermissionEntity newPermissionEntity = permissionConverter.convertInputDTOtoEntity(permissionDTO);
        newPermissionEntity.setDescription(permissionDTO.getDescription());
        newPermissionEntity.setType(permissionDTO.getType());
        permissionDAO.createPermission(newPermissionEntity);
        final PermissionDTO permissionDTO1 = permissionConverter.convertEntityToInputDTO(newPermissionEntity);
        return permissionDTO1;
    }

    public String removePermission(long id) {
        if (!permissionDAO.existsId(id)) {
            throw new BusinessWebAppException(MessageCatalog.THIS_ID_DOES_NOT_EXIST, 409);
        }

        permissionDAO.removePermission(id);
        String x = "Permission deleted";
        return x;

    }

    public List<PermissionEntity> getPermissionByTypeList(List<String> typeList) {
        return permissionDAO.getPermissionByTypeList(typeList);
    }

    public List<PermissionDTO> getAll() {
        return permissionDAO.getAll().stream()
                .map(permissionConverter::convertEntityToInputDTO)
                .collect(Collectors.toList());
    }

}
