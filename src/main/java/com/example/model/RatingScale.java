package com.example.model;


import javax.persistence.*;

@Entity
@Table(name="rating_scales")
public class RatingScale {

    @Id
    @SequenceGenerator(name="ratingScaleSequence", sequenceName = "rating_scales_rs_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ratingScaleSequence")
    @Column (name="rs_id")
    private int rsId;
    @Column(name = "rs_num")
    private int rsNum;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rt_id")
    private RatingType ratingType;
    @Column(name = "rs_text")
    private String rsText;

    public RatingScale(){}

    public int getRsId() {
        return rsId;
    }

    public void setRsId(int rsId) {
        this.rsId = rsId;
    }

    public int getRsNum() {
        return rsNum;
    }

    public void setRsNum(int rsNum) {
        this.rsNum = rsNum;
    }

    public RatingType getRatingType() {
        return ratingType;
    }

    public void setRatingType(RatingType ratingType) {
        this.ratingType = ratingType;
    }

    public String getRsText() {
        return rsText;
    }

    public void setRsText(String rsText) {
        this.rsText = rsText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RatingScale that = (RatingScale) o;

        if (rsId != that.rsId) return false;
        if (rsNum != that.rsNum) return false;
        if (ratingType != null ? !ratingType.equals(that.ratingType) : that.ratingType != null) return false;
        return rsText != null ? rsText.equals(that.rsText) : that.rsText == null;
    }

    @Override
    public int hashCode() {
        int result = rsId;
        result = 31 * result + rsNum;
        result = 31 * result + (ratingType != null ? ratingType.hashCode() : 0);
        result = 31 * result + (rsText != null ? rsText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RatingScale{" +
                "rsId=" + rsId +
                ", rsNum=" + rsNum +
                ", ratingType=" + ratingType +
                ", rsText='" + rsText + '\'' +
                '}';
    }
}
