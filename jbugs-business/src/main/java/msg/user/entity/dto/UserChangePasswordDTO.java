package msg.user.entity.dto;

public class UserChangePasswordDTO {
    private long id;
    private String newPassword;

    public UserChangePasswordDTO(long id, String newPassword) {
        this.id = id;
        this.newPassword = newPassword;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
