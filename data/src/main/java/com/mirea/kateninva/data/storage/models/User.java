package com.mirea.kateninva.data.storage.models;

import java.util.Date;

public class User {

    private String id;
    private String userName;

    private String email;

    private Date regDate;

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Date getRegDate() {
        return regDate;
    }

    public User(String id, String userName, String email, String password, Date regDate) {
        this.id = id;

        this.userName = userName;

        this.email = email;
        this.regDate = regDate;
    }

}
