package com.example.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by qzh225 on 5/4/17.
 */

@Entity
@Table(name="seedhub.questions")
public class Question {

    @Id
    @SequenceGenerator(name="questionSeq", sequenceName = "questions_q_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionSeq")
    @Column (name="q_id")
    private int qId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_id")
    private SeedClass seedClass;
    @Column(name="q_seq")
    private int qSequence;
    @Column(name="q_text")
    private String qText;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rt_id")
    private RatingType ratingType;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private Set<InterviewRatings> interviewRatings;

    public Question(){}

    public Question(int qId, SeedClass seedClass, int qSequence, String qText, RatingType ratingType) {
        this.qId = qId;
        this.seedClass = seedClass;
        this.qSequence = qSequence;
        this.qText = qText;
        this.ratingType = ratingType;
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public SeedClass getSeedClass() {
        return seedClass;
    }

    public void setSeedClass(SeedClass seedClass) {
        this.seedClass = seedClass;
    }

    public int getqSequence() {
        return qSequence;
    }

    public void setqSequence(int qSequence) {
        this.qSequence = qSequence;
    }

    public String getqText() {
        return qText;
    }

    public void setqText(String qText) {
        this.qText = qText;
    }

    public RatingType getRatingType() {
        return ratingType;
    }

    public void setRatingType(RatingType ratingType) {
        this.ratingType = ratingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question questions = (Question) o;

        if (qId != questions.qId) return false;
        if (qSequence != questions.qSequence) return false;
        if (seedClass != null ? !seedClass.equals(questions.seedClass) : questions.seedClass != null) return false;
        if (qText != null ? !qText.equals(questions.qText) : questions.qText != null) return false;
        return ratingType != null ? ratingType.equals(questions.ratingType) : questions.ratingType == null;
    }

    @Override
    public int hashCode() {
        int result = qId;
        result = 31 * result + (seedClass != null ? seedClass.hashCode() : 0);
        result = 31 * result + qSequence;
        result = 31 * result + (qText != null ? qText.hashCode() : 0);
        result = 31 * result + (ratingType != null ? ratingType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "qId=" + qId +
                ", seedClass=" + seedClass +
                ", qSequence=" + qSequence +
                ", qText='" + qText + '\'' +
                ", ratingType=" + ratingType +
                '}';
    }
}
