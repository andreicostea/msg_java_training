package msg.role.entity.dto;

import msg.permission.entity.dto.PermissionDTO;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO {

    // todo: this should be an enum
    private long id;
    private String type;
    private List<PermissionDTO> permissions = new ArrayList<>();

    public RoleDTO() {
    }

    public List<PermissionDTO> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<PermissionDTO> permissions) {
        this.permissions = permissions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
