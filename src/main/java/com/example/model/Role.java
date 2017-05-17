package com.example.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="roles")
public class Role {

    @Id
    @SequenceGenerator(name = "roleIDSequence", sequenceName = "roles_r_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleIDSequence")
    @Column(name="r_id")
    private int rId;
    @Column(name="r_role", unique = true)
    private String rRole;
    @Column(name="admin_flag")
    private boolean adminFlag;

    @OneToMany(mappedBy = "role", fetch=FetchType.LAZY)
    private Set<User> users;

    public Role () {}

    public Role (int id, String role, boolean admin) {
        this.rId = id;
        this.rRole = role;
        this.adminFlag = admin;
    }

    public int getrID() {
        return rId;
    }

    public void setrID(int rID) { //be careful with capital letters...
        this.rId = rID;
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

        if (rId != role.rId) return false;
        if (adminFlag != role.adminFlag) return false;
        return rRole != null ? rRole.equals(role.rRole) : role.rRole == null;
    }

    @Override
    public int hashCode() {
        int result = rId;
        result = 31 * result + (rRole != null ? rRole.hashCode() : 0);
        result = 31 * result + (adminFlag ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rID=" + rId +
                ", rRole='" + rRole + '\'' +
                ", adminFlag=" + adminFlag +
                '}';
    }
}


