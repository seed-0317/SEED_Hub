package com.example.model;

import javax.persistence.*;


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

    //@ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "mgr_email")
    private String managerEmail;

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

    public Application(User applicant, String managerEmail, SeedClass seedClass, String dept, String techSkillsLangs, String education, String techOrgs, String seedSuccess, String comments, String currRole, String currLevel, boolean strongPlus, boolean mgrApproval) {
        this.applicant = applicant;
        this.managerEmail = managerEmail;
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

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
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
        if (o == null || getClass() != o.getClass()) return false;

        Application that = (Application) o;

        if (appId != that.appId) return false;
        if (strongPlus != that.strongPlus) return false;
        if (mgrApproval != that.mgrApproval) return false;
        if (!applicant.equals(that.applicant)) return false;
        if (managerEmail != null ? !managerEmail.equals(that.managerEmail) : that.managerEmail != null) return false;
        if (seedClass != null ? !seedClass.equals(that.seedClass) : that.seedClass != null) return false;
        if (dept != null ? !dept.equals(that.dept) : that.dept != null) return false;
        if (techSkillsLangs != null ? !techSkillsLangs.equals(that.techSkillsLangs) : that.techSkillsLangs != null)
            return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (techOrgs != null ? !techOrgs.equals(that.techOrgs) : that.techOrgs != null) return false;
        if (seedSuccess != null ? !seedSuccess.equals(that.seedSuccess) : that.seedSuccess != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (currRole != null ? !currRole.equals(that.currRole) : that.currRole != null) return false;
        return currLevel != null ? currLevel.equals(that.currLevel) : that.currLevel == null;
    }

    @Override
    public int hashCode() {
        int result = appId;
        result = 31 * result + applicant.hashCode();
        result = 31 * result + (managerEmail != null ? managerEmail.hashCode() : 0);
        result = 31 * result + (seedClass != null ? seedClass.hashCode() : 0);
        result = 31 * result + (dept != null ? dept.hashCode() : 0);
        result = 31 * result + (techSkillsLangs != null ? techSkillsLangs.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (techOrgs != null ? techOrgs.hashCode() : 0);
        result = 31 * result + (seedSuccess != null ? seedSuccess.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (currRole != null ? currRole.hashCode() : 0);
        result = 31 * result + (currLevel != null ? currLevel.hashCode() : 0);
        result = 31 * result + (strongPlus ? 1 : 0);
        result = 31 * result + (mgrApproval ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Application{" +
                "appId=" + appId +
                ", applicant=" + applicant +
                ", managerEmail='" + managerEmail + '\'' +
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