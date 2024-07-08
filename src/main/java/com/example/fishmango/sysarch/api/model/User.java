package com.example.fishmango.sysarch.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
        public class User {


    private String name;
    private int age;
    private String email;
    private String username;
    private String password;

    public User( String name, int age, String email, String username, String password){

        this.name = name;
        this.age = age;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
