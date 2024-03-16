package com.simpleworkoutservice.simpleworkoutservice.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "auth_id")
    private String authId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "email_verified")
    private Boolean emailVerified;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "given_name")
    private String givenName;

    @Column(name = "last_password_reset")
    private String lastPasswordReset;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "phone_verified")
    private Boolean phoneVerified;

    @Column(name = "picture")
    private String picture;

    public User() {
    }

    public User(int id, String authId, String username, String email, Boolean emailVerified,
            String familyName, String givenName, String lastPasswordReset,
            String name, String phoneNumber, Boolean phoneVerified,
            String picture, Date createdAt) {
        this.id = id;
        this.authId = authId;
        this.username = username;
        this.email = email;
        this.emailVerified = emailVerified;
        this.familyName = familyName;
        this.givenName = givenName;
        this.lastPasswordReset = lastPasswordReset;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.phoneVerified = phoneVerified;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isEmailVerified() {
        return emailVerified;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getLastPasswordReset() {
        return lastPasswordReset;
    }

    public void setLastPasswordReset(String lastPasswordReset) {
        this.lastPasswordReset = lastPasswordReset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean isPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(Boolean phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                ", id='" + id + '\'' +
                ", authId='" + authId + '\'' +
                ", email='" + email + '\'' +
                ", emailVerified=" + emailVerified +
                ", familyName='" + familyName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", lastPasswordReset='" + lastPasswordReset + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", phoneVerified=" + phoneVerified +
                ", picture='" + picture + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

}
