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
    private int counter;
    private List<String> roles=new ArrayList<>();

    /**
     * Getter.
     *
     * @return firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Setter.
     *
     * @param pFirstName
     */
    public void setFirstName(final String pFirstName) {

        this.firstName = pFirstName;
    }

    /**
     * Getter.
     *
     * @return lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Setter.
     *
     * @param pLastName
     */
    public void setLastName(final String pLastName) {
        this.lastName = pLastName;
    }

    /**
     * Getter.
     *
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter.
     *
     * @param pEmail
     */
    public void setEmail(final String pEmail) {
        this.email = pEmail;
    }

    /**
     * Getter.
     *
     * @return mobileNumber
     */
    public String getMobileNumber() {
        return this.mobileNumber;
    }

    /**
     * Setter.
     *
     * @param pMobileNumber
     */
    public void setMobileNumber(final String pMobileNumber) {
        this.mobileNumber = pMobileNumber;
    }

    /**
     * Getter.
     *
     * @return counter
     */
    public int getCounter() {
        return this.counter;
    }

    /**
     * Setter.
     *
     * @param pCounter
     */
    public void setCounter(final int pCounter) {
        this.counter = pCounter;
    }

    /**
     * Getter.
     *
     * @return roles
     */
    public List<String> getRoles() {
        return this.roles;
    }

    /**
     * Setter.
     *
     * @param pRoles
     */
    public void setRoles(final List<String> pRoles) {
        this.roles = pRoles;
    }
}
