package msg.user.entity.dto;

import java.util.ArrayList;
import java.util.List;

public class UserUpdateDTO {
    private String firstName;
    private String lastName;
    private String emailBeforeUpdate;
    private String email;
    private String mobileNumber;
    private List<String> roles;
//    private List<String> roles = new ArrayList<>();

    public UserUpdateDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailBeforeUpdate() {
        return emailBeforeUpdate;
    }

    public void setEmailBeforeUpdate(String emailBeforeUpdate) {
        this.emailBeforeUpdate = emailBeforeUpdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
