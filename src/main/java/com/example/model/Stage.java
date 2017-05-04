package com.example.model;

import javax.persistence.*;

/**
 * Created by qzh225 on 5/3/17.
 */
public class Stage {

    private int sId;
    private String sStage;

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
