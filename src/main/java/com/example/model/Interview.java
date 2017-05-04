package com.example.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by qzh225 on 5/4/17.
 */

@Entity
@Table (name="seedhub.interview")
public class Interview {

    @Id
    @SequenceGenerator(name="interviewSeq", sequenceName = "interview_int_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interviewSeq")
    @Column(name="int_id")
    private int intId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="class_id")
    private SeedClass seedClass;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="applicant_id")
    private User applicant;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="interviewer_id")
    private User interviewer;
    @Column(name="interview_dt")
    private Timestamp interviewDt;
    @Column (name="int_type")
    private String intType;


    @OneToMany(mappedBy = "interview")
    private Set<InterviewRatings> interviewRatings;

    public Interview(){}

    public Interview(SeedClass seedClass, User applicant, User interviewer, Timestamp interviewDt, String intType) {
        this.seedClass = seedClass;
        this.applicant = applicant;
        this.interviewer = interviewer;
        this.interviewDt = interviewDt;
        this.intType = intType;
    }

    public int getIntId() {
        return intId;
    }

    public void setIntId(int intId) {
        this.intId = intId;
    }

    public SeedClass getSeedClass() {
        return seedClass;
    }

    public void setSeedClass(SeedClass seedClass) {
        this.seedClass = seedClass;
    }

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    public User getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(User interviewer) {
        this.interviewer = interviewer;
    }

    public Timestamp getInterviewDt() {
        return interviewDt;
    }

    public void setInterviewDt(Timestamp interviewDt) {
        this.interviewDt = interviewDt;
    }

    public String getIntType() {
        return intType;
    }

    public void setIntType(String intType) {
        this.intType = intType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interview interview = (Interview) o;

        if (intId != interview.intId) return false;
        if (seedClass != null ? !seedClass.equals(interview.seedClass) : interview.seedClass != null) return false;
        if (applicant != null ? !applicant.equals(interview.applicant) : interview.applicant != null) return false;
        if (interviewer != null ? !interviewer.equals(interview.interviewer) : interview.interviewer != null)
            return false;
        if (interviewDt != null ? !interviewDt.equals(interview.interviewDt) : interview.interviewDt != null)
            return false;
        return intType != null ? intType.equals(interview.intType) : interview.intType == null;
    }

    @Override
    public int hashCode() {
        int result = intId;
        result = 31 * result + (seedClass != null ? seedClass.hashCode() : 0);
        result = 31 * result + (applicant != null ? applicant.hashCode() : 0);
        result = 31 * result + (interviewer != null ? interviewer.hashCode() : 0);
        result = 31 * result + (interviewDt != null ? interviewDt.hashCode() : 0);
        result = 31 * result + (intType != null ? intType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "intId=" + intId +
                ", seedClass=" + seedClass +
                ", applicant=" + applicant +
                ", interviewer=" + interviewer +
                ", interviewDt=" + interviewDt +
                ", intType='" + intType + '\'' +
                '}';
    }
}
