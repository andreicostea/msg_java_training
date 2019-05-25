package msg.permission.entity.dto;

public class PermissionDTO {

    // todo: type should be an enum
    private String description;
    private String type;

    public PermissionDTO() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
