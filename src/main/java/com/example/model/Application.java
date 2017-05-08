package com.example.model;

import javax.persistence.*;

/**
 * Created by qzh225 on 5/3/17.
 */
@Entity
@Table (name = "application")
public class Application {

    @Id
    @SequenceGenerator(name = "applicationSequence", sequenceName = "application_app_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "applicationSequence")
    @Column(name = "app_id")
    private int appId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="u_id")
    private User applicant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mgr_id")
    private User manager;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_id")
    private SeedClass seedClass;

    @Column(name = "dept")
    private String dept;

    @Column(name = "techskills_languages")
    private String techSkillsLangs;

    @Column(name = "education")
    private String education;

    @Column(name = "tech_orgs")
    private String techOrgs;

    @Column(name = "seed_success")
    private String seedSuccess;

    @Column(name = "comments")
    private String comments;

    @Column(name="curr_role")
    private String currRole;

    @Column(name="curr_level")
    private String currLevel;

    @Column(name="strong_plus")
    private boolean strongPlus;

    @Column(name="mgr_approval")
    private boolean mgrApproval;


    public Application (){}

    public Application(User applicant, User manager, SeedClass seedClass, String dept, String techSkillsLangs, String education, String techOrgs, String seedSuccess, String comments, String currRole, String currLevel, boolean strongPlus, boolean mgrApproval) {
        this.applicant = applicant;
        this.manager = manager;
        this.seedClass = seedClass;
        this.dept = dept;
        this.techSkillsLangs = techSkillsLangs;
        this.education = education;
        this.techOrgs = techOrgs;
        this.seedSuccess = seedSuccess;
        this.comments = comments;
        this.currRole = currRole;
        this.currLevel = currLevel;
        this.strongPlus = strongPlus;
        this.mgrApproval = mgrApproval;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public SeedClass getSeedClass() {
        return seedClass;
    }

    public void setSeedClass(SeedClass seedClass) {
        this.seedClass = seedClass;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getTechSkillsLangs() {
        return techSkillsLangs;
    }

    public void setTechSkillsLangs(String techSkillsLangs) {
        this.techSkillsLangs = techSkillsLangs;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTechOrgs() {
        return techOrgs;
    }

    public void setTechOrgs(String techOrgs) {
        this.techOrgs = techOrgs;
    }

    public String getSeedSuccess() {
        return seedSuccess;
    }

    public void setSeedSuccess(String seedSuccess) {
        this.seedSuccess = seedSuccess;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCurrRole() {
        return currRole;
    }

    public void setCurrRole(String currRole) {
        this.currRole = currRole;
    }

    public String getCurrLevel() {
        return currLevel;
    }

    public void setCurrLevel(String currLevel) {
        this.currLevel = currLevel;
    }

    public boolean isStrongPlus() {
        return strongPlus;
    }

    public void setStrongPlus(boolean strongPlus) {
        this.strongPlus = strongPlus;
    }

    public boolean isMgrApproval() {
        return mgrApproval;
    }

    public void setMgrApproval(boolean mgrApproval) {
        this.mgrApproval = mgrApproval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Application)) return false;

        Application that = (Application) o;

        if (getAppId() != that.getAppId()) return false;
        if (isStrongPlus() != that.isStrongPlus()) return false;
        if (isMgrApproval() != that.isMgrApproval()) return false;
        if (getApplicant() != null ? !getApplicant().equals(that.getApplicant()) : that.getApplicant() != null)
            return false;
        if (getManager() != null ? !getManager().equals(that.getManager()) : that.getManager() != null) return false;
        if (getSeedClass() != null ? !getSeedClass().equals(that.getSeedClass()) : that.getSeedClass() != null)
            return false;
        if (getDept() != null ? !getDept().equals(that.getDept()) : that.getDept() != null) return false;
        if (getTechSkillsLangs() != null ? !getTechSkillsLangs().equals(that.getTechSkillsLangs()) : that.getTechSkillsLangs() != null)
            return false;
        if (getEducation() != null ? !getEducation().equals(that.getEducation()) : that.getEducation() != null)
            return false;
        if (getTechOrgs() != null ? !getTechOrgs().equals(that.getTechOrgs()) : that.getTechOrgs() != null)
            return false;
        if (getSeedSuccess() != null ? !getSeedSuccess().equals(that.getSeedSuccess()) : that.getSeedSuccess() != null)
            return false;
        if (getComments() != null ? !getComments().equals(that.getComments()) : that.getComments() != null)
            return false;
        if (getCurrRole() != null ? !getCurrRole().equals(that.getCurrRole()) : that.getCurrRole() != null)
            return false;
        return getCurrLevel() != null ? getCurrLevel().equals(that.getCurrLevel()) : that.getCurrLevel() == null;
    }

    @Override
    public int hashCode() {
        int result = getAppId();
        result = 31 * result + (getApplicant() != null ? getApplicant().hashCode() : 0);
        result = 31 * result + (getManager() != null ? getManager().hashCode() : 0);
        result = 31 * result + (getSeedClass() != null ? getSeedClass().hashCode() : 0);
        result = 31 * result + (getDept() != null ? getDept().hashCode() : 0);
        result = 31 * result + (getTechSkillsLangs() != null ? getTechSkillsLangs().hashCode() : 0);
        result = 31 * result + (getEducation() != null ? getEducation().hashCode() : 0);
        result = 31 * result + (getTechOrgs() != null ? getTechOrgs().hashCode() : 0);
        result = 31 * result + (getSeedSuccess() != null ? getSeedSuccess().hashCode() : 0);
        result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
        result = 31 * result + (getCurrRole() != null ? getCurrRole().hashCode() : 0);
        result = 31 * result + (getCurrLevel() != null ? getCurrLevel().hashCode() : 0);
        result = 31 * result + (isStrongPlus() ? 1 : 0);
        result = 31 * result + (isMgrApproval() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Application{" +
                "appId=" + appId +
                ", applicant=" + applicant +
                ", manager=" + manager +
                ", seedClass=" + seedClass +
                ", dept='" + dept + '\'' +
                ", techSkillsLangs='" + techSkillsLangs + '\'' +
                ", education='" + education + '\'' +
                ", techOrgs='" + techOrgs + '\'' +
                ", seedSuccess='" + seedSuccess + '\'' +
                ", comments='" + comments + '\'' +
                ", currRole='" + currRole + '\'' +
                ", currLevel='" + currLevel + '\'' +
                ", strongPlus=" + strongPlus +
                ", mgrApproval=" + mgrApproval +
                '}';
    }
}
