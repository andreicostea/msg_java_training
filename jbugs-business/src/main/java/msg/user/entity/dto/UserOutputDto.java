package msg.user.entity.dto;

import java.util.ArrayList;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */

public class UserOutputDto {
    private String email;
    private String userName;
    private ArrayList<String> permissions;
    private String token;

    public UserOutputDto() {
    }

    public UserOutputDto(String email, String userName, ArrayList<String> permissions, String token) {
        this.email = email;
        this.userName = userName;
        this.permissions = permissions;
        this.token = token;
    }

    public ArrayList<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<String> permissions) {
        this.permissions = permissions;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
