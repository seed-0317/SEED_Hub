package com.example.model;

import javax.persistence.*;

/**
 * Created by qzh225 on 5/3/17.
 */
public class Role {

    private int rID;
    private String rRole;
    private boolean adminFlag;

    public Role () {}

    public Role (int id, String role, boolean admin) {
        this.rID = id;
        this.rRole = role;
        this.adminFlag = admin;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public String getrRole() {
        return rRole;
    }

    public void setrRole(String rRole) {
        this.rRole = rRole;
    }

    public boolean isAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(boolean adminFlag) {
        this.adminFlag = adminFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (rID != role.rID) return false;
        if (adminFlag != role.adminFlag) return false;
        return rRole != null ? rRole.equals(role.rRole) : role.rRole == null;
    }

    @Override
    public int hashCode() {
        int result = rID;
        result = 31 * result + (rRole != null ? rRole.hashCode() : 0);
        result = 31 * result + (adminFlag ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rID=" + rID +
                ", rRole='" + rRole + '\'' +
                ", adminFlag=" + adminFlag +
                '}';
    }
}

