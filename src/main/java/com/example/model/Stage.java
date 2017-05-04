package com.example.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by qzh225 on 5/3/17.
 */
@Entity
@Table(name="seedhub.stages")
public class Stage {
    @Id
    @SequenceGenerator(name = "stageIDSequence", sequenceName = "stages_s_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stageIDSequence")
    @Column(name="s_id")
    private int sId;
    @Column(name="s_stage", unique = true)
    private String sStage;

    @OneToMany(mappedBy = "stage", fetch = FetchType.LAZY)
    Set<User> users;

    public Stage(){}

    public Stage(int id, String stage) {
        this.sId = id;
        this.sStage = stage;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsStage() {
        return sStage;
    }

    public void setsStage(String sStage) {
        this.sStage = sStage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stage stage = (Stage) o;

        if (sId != stage.sId) return false;
        return sStage != null ? sStage.equals(stage.sStage) : stage.sStage == null;
    }

    @Override
    public int hashCode() {
        int result = sId;
        result = 31 * result + (sStage != null ? sStage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "sId=" + sId +
                ", sStage='" + sStage + '\'' +
                '}';
    }
}
