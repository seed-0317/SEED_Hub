package com.example.model;

import javax.persistence.*;

/**
 * Created by qzh225 on 5/3/17.
 */
public class User {

    private int uId;
    private String eId;
    private String email;
    private String fname;
    private String lname;
    private Role role;
    private Stage stage;

    public User() {}

    public User(int uId, String eId, String email, String fname, String lname, Role role, Stage stage) {
        this.uId = uId;
        this.eId = eId;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
        this.stage = stage;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (uId != user.uId) return false;
        if (eId != null ? !eId.equals(user.eId) : user.eId != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (fname != null ? !fname.equals(user.fname) : user.fname != null) return false;
        if (lname != null ? !lname.equals(user.lname) : user.lname != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        return stage != null ? stage.equals(user.stage) : user.stage == null;
    }

    @Override
    public int hashCode() {
        int result = uId;
        result = 31 * result + (eId != null ? eId.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (stage != null ? stage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", eId='" + eId + '\'' +
                ", email='" + email + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", role=" + role +
                ", stage=" + stage +
                '}';
    }
}