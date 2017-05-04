package com.example.model;

/**
 * Created by qzh225 on 5/3/17.
 */
public class Application {

    private int appId;
    private User applicant;
    private User manager;
    private SeedClass seedClass;
    private String dept;
    private String techSkillsLangs;
    private String education;
    private String techOrgs;
    private String seedSuccess;
    private String comments;

    public Application (){}

    public Application(int appId, User applicant, User manager, SeedClass seedClass, String dept, String techSkillsLangs, String education, String techOrgs, String seedSuccess, String comments) {
        this.appId = appId;
        this.applicant = applicant;
        this.manager = manager;
        this.seedClass = seedClass;
        this.dept = dept;
        this.techSkillsLangs = techSkillsLangs;
        this.education = education;
        this.techOrgs = techOrgs;
        this.seedSuccess = seedSuccess;
        this.comments = comments;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Application that = (Application) o;

        if (appId != that.appId) return false;
        if (applicant != null ? !applicant.equals(that.applicant) : that.applicant != null) return false;
        if (manager != null ? !manager.equals(that.manager) : that.manager != null) return false;
        if (seedClass != null ? !seedClass.equals(that.seedClass) : that.seedClass != null) return false;
        if (dept != null ? !dept.equals(that.dept) : that.dept != null) return false;
        if (techSkillsLangs != null ? !techSkillsLangs.equals(that.techSkillsLangs) : that.techSkillsLangs != null)
            return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (techOrgs != null ? !techOrgs.equals(that.techOrgs) : that.techOrgs != null) return false;
        if (seedSuccess != null ? !seedSuccess.equals(that.seedSuccess) : that.seedSuccess != null) return false;
        return comments != null ? comments.equals(that.comments) : that.comments == null;
    }

    @Override
    public int hashCode() {
        int result = appId;
        result = 31 * result + (applicant != null ? applicant.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (seedClass != null ? seedClass.hashCode() : 0);
        result = 31 * result + (dept != null ? dept.hashCode() : 0);
        result = 31 * result + (techSkillsLangs != null ? techSkillsLangs.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (techOrgs != null ? techOrgs.hashCode() : 0);
        result = 31 * result + (seedSuccess != null ? seedSuccess.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
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
                '}';
    }
}
