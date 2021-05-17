package com.petlife.backend.requestModels.response;


import com.petlife.backend.models.User;
import java.util.List;

public class UserProfileResponse {

    private String email;

    //private String password;

    private String name;

    private String surname;

    private String cellPhoneNumber;

    private List<String> roles;

    public UserProfileResponse(User user, List<String> roles){
        this.email = user.getEmail();
        //this.password = user.getPassword();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.cellPhoneNumber = user.getCellPhoneNumber();
        this.roles = roles;
    }

    public UserProfileResponse(String email, String name, String surname, String cellPhoneNumber, List<String> roles) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.cellPhoneNumber = cellPhoneNumber;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
