package com.jowl.msg.post.domain;

import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotBlank;

public class User {
    @NotBlank(message = "Expected not-blank uid.")
    @Indexed
    private String uid;
    @NotBlank(message = "Expected not-blank email.")
    @Indexed
    private String email;
    @NotBlank(message = "Expected not-blank Name")
    private String displayName;

    private String photoURL;

    protected User() {
    }

    public User(String uid, String displayName, String email, String photoURL) {
        this.uid = uid;
        this.displayName = displayName;
        this.email = email;
        this.photoURL = photoURL;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}
