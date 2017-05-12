package com.example.model;

import javax.persistence.*;

/**
 * Created by qzh225 on 5/4/17.
 */

@Entity
@Table (name="interview_ratings")
public class InterviewRatings {

    @Id
    @SequenceGenerator(name="interviewRatingsSeq", sequenceName = "interview_ratings_rat_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interviewRatingsSeq")
    @Column (name="rat_id")
    private int ratId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="int_id")
    private Interview interview;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="q_id")
    private Question question;
    @Column(name="rating")
    private int rating;
    @Column(name="comments")
    private String comments;

    public InterviewRatings(){}

    public InterviewRatings(int ratId, Interview interview, Question question, int rating, String comments) {
        this.ratId = ratId;
        this.interview = interview;
        this.question = question;
        this.rating = rating;
        this.comments = comments;
    }

    public int getRatId() {
        return ratId;
    }

    public void setRatId(int ratId) {
        this.ratId = ratId;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterviewRatings that = (InterviewRatings) o;

        if (ratId != that.ratId) return false;
        if (rating != that.rating) return false;
        if (interview != null ? !interview.equals(that.interview) : that.interview != null) return false;
        if (question != null ? !question.equals(that.question) : that.question != null) return false;
        return comments != null ? comments.equals(that.comments) : that.comments == null;
    }

    @Override
    public int hashCode() {
        int result = ratId;
        result = 31 * result + (interview != null ? interview.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + rating;
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InterviewRatings{" +
                "ratId=" + ratId +
                ", interview=" + interview +
                ", question=" + question +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }
}
