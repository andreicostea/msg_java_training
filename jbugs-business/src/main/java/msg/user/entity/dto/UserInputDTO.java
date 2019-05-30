// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.user.entity.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * A representation of the User, used for creating a user.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
public class UserInputDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private List<String> roles = new ArrayList<>();

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String pFirstName) {
        this.firstName = pFirstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String pLastName) {
        this.lastName = pLastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String pEmail) {
        this.email = pEmail;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(final String pMobileNumber) {
        this.mobileNumber = pMobileNumber;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public void setRoles(final List<String> pRoles) {
        this.roles = pRoles;
    }
}
