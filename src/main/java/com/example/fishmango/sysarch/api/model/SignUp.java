package com.example.fishmango.sysarch.api.model;


import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

public class SignUp {

    private String fullname;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    public SignUp( String fullname, String username, String password, String email, String phoneNumber){
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
                
        
    }
    public void setFullname(String username) {
        this.username = username;
    }
    public String getFullname() {
        return fullname;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }


    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }



}



