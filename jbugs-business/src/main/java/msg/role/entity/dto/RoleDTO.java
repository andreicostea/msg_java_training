package msg.role.entity.dto;

import msg.base.BaseEntity;

public class RoleDTO {

    // todo: this should be an enum
    private long id;
    private String type;

    public RoleDTO() {
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
