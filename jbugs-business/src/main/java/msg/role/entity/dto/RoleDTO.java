package msg.role.entity.dto;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO {

    // todo: this should be an enum
    private String type;
    private List<String> permissions = new ArrayList<>();

    public List<String> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public RoleDTO() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
