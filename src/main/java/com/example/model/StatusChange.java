package com.example.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by qzh225 on 5/3/17.
 */
@Entity
@Table(name="seedhub.status_hist")

public class StatusChange {

    @Id
    @SequenceGenerator(name = "statusHistorySequence", sequenceName = "status_hist_sh_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statusHistorySequence")
    @Column(name="sh_id")
    private int shId;
    @Column(name="u_id")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "u_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="s_id")
    private Stage oldStage;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="s_id")
    private Stage newStage;
    @Column(name= "change_ts")
    private Timestamp changeTs;


    public StatusChange(){}

    public StatusChange(int shId, User user, Stage oldStage, Stage newStage, Timestamp changeTs) {
        this.shId = shId;
        this.user = user;
        this.oldStage = oldStage;
        this.newStage = newStage;
        this.changeTs = changeTs;
    }

    public int getShId() {
        return shId;
    }

    public void setShId(int shId) {
        this.shId = shId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stage getOldStage() {
        return oldStage;
    }

    public void setOldStage(Stage oldStage) {
        this.oldStage = oldStage;
    }

    public Stage getNewStage() {
        return newStage;
    }

    public void setNewStage(Stage newStage) {
        this.newStage = newStage;
    }

    public Timestamp getChangeTs() {
        return changeTs;
    }

    public void setChangeTs(Timestamp changeTs) {
        this.changeTs = changeTs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusChange that = (StatusChange) o;

        if (shId != that.shId) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (oldStage != null ? !oldStage.equals(that.oldStage) : that.oldStage != null) return false;
        if (newStage != null ? !newStage.equals(that.newStage) : that.newStage != null) return false;
        return changeTs != null ? changeTs.equals(that.changeTs) : that.changeTs == null;
    }

    @Override
    public int hashCode() {
        int result = shId;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (oldStage != null ? oldStage.hashCode() : 0);
        result = 31 * result + (newStage != null ? newStage.hashCode() : 0);
        result = 31 * result + (changeTs != null ? changeTs.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StatusChange{" +
                "shId=" + shId +
                ", user=" + user +
                ", oldStage=" + oldStage +
                ", newStage=" + newStage +
                ", changeTs=" + changeTs +
                '}';
    }
}
