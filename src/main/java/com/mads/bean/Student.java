package com.mads.bean;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private String username = "mads";

    private String password = "123";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
