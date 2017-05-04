package com.example.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by qzh225 on 5/4/17.
 */

@Entity
@Table (name="seedhub.rating_types")
public class RatingType {
    @Id
    @SequenceGenerator(name="ratingTypeSequence", sequenceName = "rating_types_rt_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ratingTypeSequence")
    @Column (name="rt_id")
    private int rtId;
    @Column(name="rt_desc", unique = true)
    private String rDescription;
    @Column(name="rt_scale")
    private int rScale;
    @Column(name="rt_txt_flag")
    private boolean txtFlag;

    @OneToMany(mappedBy = "ratingType" , fetch = FetchType.LAZY)
    private Set<Question> questions;

    public RatingType(){}

    public RatingType(int rtId, String rDescription, int rScale, boolean txtFlag) {
        this.rtId = rtId;
        this.rDescription = rDescription;
        this.rScale = rScale;
        this.txtFlag = txtFlag;
    }

    public int getRtId() {
        return rtId;
    }

    public void setRtId(int rtId) {
        this.rtId = rtId;
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription;
    }

    public int getrScale() {
        return rScale;
    }

    public void setrScale(int rScale) {
        this.rScale = rScale;
    }

    public boolean isTxtFlag() {
        return txtFlag;
    }

    public void setTxtFlag(boolean txtFlag) {
        this.txtFlag = txtFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RatingType that = (RatingType) o;

        if (rtId != that.rtId) return false;
        if (rScale != that.rScale) return false;
        if (txtFlag != that.txtFlag) return false;
        return rDescription != null ? rDescription.equals(that.rDescription) : that.rDescription == null;
    }

    @Override
    public int hashCode() {
        int result = rtId;
        result = 31 * result + (rDescription != null ? rDescription.hashCode() : 0);
        result = 31 * result + rScale;
        result = 31 * result + (txtFlag ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RatingType{" +
                "rtId=" + rtId +
                ", rDescription='" + rDescription + '\'' +
                ", rScale=" + rScale +
                ", txtFlag=" + txtFlag +
                '}';
    }
}
