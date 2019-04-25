package com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request;

/**
 * use @NotNull or @NotBlank for strings, include a message
 */

//TODO: add validations
public class UserDto {

    private String firstName;

    private String lastName;

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

}
