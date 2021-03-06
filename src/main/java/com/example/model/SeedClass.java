package com.example.model;

import javax.persistence.*;
import java.sql.Timestamp;




@Entity
@Table(name = "seedclass")
public class SeedClass {
    @Id
    @SequenceGenerator(name = "seedclassSequence", sequenceName = "seedclass_c_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seedclassSequence")

    @Column(name = "c_id")
    private int cId;

    @Column(name = "c_yr")
    private int cYr;

    @Column(name = "c_num")
    private int cNum;

    @Column(name = "c_loc")
    private String cLoc;

    @Column(name = "c_app_open_dt")
    private Timestamp cAppOpenDate;

    @Column(name = "c_app_deadline")
    private Timestamp cAppDeadline;

    @Column(name = "c_bootcamp_dt")
    private Timestamp cBootcampDate;

    public SeedClass(){}

    public SeedClass(int cId, int cYr, int cNum, String cLoc, Timestamp cAppOpenDate, Timestamp cAppDeadline, Timestamp cBootcampDate) {
        this.cId = cId;
        this.cYr = cYr;
        this.cNum = cNum;
        this.cLoc = cLoc;
        this.cAppOpenDate = cAppOpenDate;
        this.cAppDeadline = cAppDeadline;
        this.cBootcampDate = cBootcampDate;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getcYr() {
        return cYr;
    }

    public void setcYr(int cYr) {
        this.cYr = cYr;
    }

    public int getcNum() {
        return cNum;
    }

    public void setcNum(int cNum) {
        this.cNum = cNum;
    }

    public String getcLoc() {
        return cLoc;
    }

    public void setcLoc(String cLoc) {
        this.cLoc = cLoc;
    }

    public Timestamp getcAppOpenDate() {
        return cAppOpenDate;
    }

    public void setcAppOpenDate(Timestamp cAppOpenDate) {
        this.cAppOpenDate = cAppOpenDate;
    }

    public Timestamp getcAppDeadline() {
        return cAppDeadline;
    }

    public void setcAppDeadline(Timestamp cAppDeadline) {
        this.cAppDeadline = cAppDeadline;
    }

    public Timestamp getcBootcampDate() {
        return cBootcampDate;
    }

    public void setcBootcampDate(Timestamp cBootcampDate) {
        this.cBootcampDate = cBootcampDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeedClass seedClass = (SeedClass) o;

        if (cId != seedClass.cId) return false;
        if (cYr != seedClass.cYr) return false;
        if (cNum != seedClass.cNum) return false;
        if (cLoc != null ? !cLoc.equals(seedClass.cLoc) : seedClass.cLoc != null) return false;
        if (cAppOpenDate != null ? !cAppOpenDate.equals(seedClass.cAppOpenDate) : seedClass.cAppOpenDate != null)
            return false;
        if (cAppDeadline != null ? !cAppDeadline.equals(seedClass.cAppDeadline) : seedClass.cAppDeadline != null)
            return false;
        return cBootcampDate != null ? cBootcampDate.equals(seedClass.cBootcampDate) : seedClass.cBootcampDate == null;
    }

    @Override
    public int hashCode() {
        int result = cId;
        result = 31 * result + cYr;
        result = 31 * result + cNum;
        result = 31 * result + (cLoc != null ? cLoc.hashCode() : 0);
        result = 31 * result + (cAppOpenDate != null ? cAppOpenDate.hashCode() : 0);
        result = 31 * result + (cAppDeadline != null ? cAppDeadline.hashCode() : 0);
        result = 31 * result + (cBootcampDate != null ? cBootcampDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SeedClass{" +
                "cId=" + cId +
                ", cYr=" + cYr +
                ", cNum=" + cNum +
                ", cLoc='" + cLoc + '\'' +
                ", cAppOpenDate=" + cAppOpenDate +
                ", cAppDeadline=" + cAppDeadline +
                ", cBootcampDate=" + cBootcampDate +
                '}';
    }
}
