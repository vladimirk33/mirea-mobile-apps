package com.mirea.kateninva.domain.models;

import java.time.LocalDateTime;
import java.util.Date;

public class User {

    private String id;
    private String userName;

    private String email;

    private Date regDate;

    public User(String id, String userName, String email, Date regDate) {
        this.id = id;

        this.userName = userName;

        this.email = email;
        this.regDate = regDate;
    }

    public static User getTestUser() {
        return new User("1", "test user", "test_email", new Date());
    }

    public String getId() {
        return id;
    }

    public Date getRegDate() {
        return regDate;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }
}
