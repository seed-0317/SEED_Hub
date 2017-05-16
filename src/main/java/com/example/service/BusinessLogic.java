package com.example.service;

import com.example.model.*;
import com.example.repositories.*;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BusinessLogic {

    @Autowired
    private ApplicationRepo applicationRepo;
    public Application retrieveApplication(int id) {
        return applicationRepo.findByApplicantUId(id);
    }
    public List<Application> retrieveApplicationByCId(int id) {
        return applicationRepo.findBySeedClassCId(id);
    }
    public Application application(Application newApplication) {
        return applicationRepo.save(newApplication);
    }

    public List<Application> retrieveAllApplications() {
        List<Application> list = applicationRepo.findAll();
        int i;
        for (i=0;i<list.size();i++){
            //loop and print
            System.out.println(list.get(i));
        }
        return list;
    }



    public Application application(String eId, int SeedClass,Application newApplication) {
        User user = retrieveUser(eId);
        SeedClass seedClass = retrieveSeedClass(SeedClass);
        newApplication.setApplicant(user);
        newApplication.setSeedClass(seedClass);
        return applicationRepo.save(newApplication);
    }

    @Autowired
    private RoleRepo roleRepo;

    public Role retrieveRole(int rid) { return roleRepo.findByRId(rid);
    }

    public List<Role> retrieveAllRoles() {
        return roleRepo.findAll();
    }

    @Autowired
    private StageRepo stageRepo;

    public Stage retrieveStage(int sid) {
        return stageRepo.findBySId(sid);
    }

    public List<Stage> retrieveAllStages() {
        return stageRepo.findAll();
    }

    @Autowired
    private UserRepo userRepo;

    public User retrieveUser(String eId) {
        return userRepo.findByEId(eId);
    }

    public User createUser(User newUser){
        if (newUser.getRole() == null ){
            Role two = retrieveRole(2);
            newUser.setRole(two);
        }
        if (newUser.getStage() == null ){
            Stage one = retrieveStage(1);
            newUser.setStage(one);
        }
        return userRepo.save(newUser);
    }

    @Autowired
    private InterviewRepo interviewRepo;

    public Interview retrieveInterview(int intId) {
        return interviewRepo.findByIntId(intId);
    }

    public List<Interview> retrieveApplicantInterview(int applicantUId) {
        return interviewRepo.findByApplicantUId(applicantUId);
    }

    @Autowired
    private InterviewRatingsRepo interviewRatingsRepo;

    public InterviewRatings retrieveInterviewRatings(int ratId) {
        return interviewRatingsRepo.findByRatId(ratId);
    }

    public List<InterviewRatings> retrieveApplicantInterviewRatings(int intId) {
        return interviewRatingsRepo.findByInterviewIntId(intId);
    }

    @Autowired
    private QuestionsRepo questionsRepo;

    public Question retrieveQuestion(int qId) {
        return questionsRepo.findByQId(qId);
    }

    public List<Question> retrieveClassTypeQuestions(int cId, String qType) {
        return questionsRepo.findBySeedClassCIdAndQType(cId, qType);
    }

    public List<Question> retrieveAllQuestions(){
        return questionsRepo.findAll();
    }
    public Question postQuestion(Question question) {
        System.out.println("In Business Logic Post question = " + question);
        return questionsRepo.save(question);
    }


    @Autowired
    private RatingTypeRepo ratingTypeRepo;

    public RatingType retrieveRatingType(int rtId) {
        return ratingTypeRepo.findByRtId(rtId);
    }

    public List<RatingType> retrieveAllRatingTypes() {
        return ratingTypeRepo.findAll();
    }

    @Autowired
    private SeedClassRepo seedClassRepo;

    public SeedClass retrieveSeedClass(int cId) {
         return seedClassRepo.findByCId(cId);
    }
    public List<SeedClass> retrieveAllSeedClass(){
         return seedClassRepo.findAll();
    }
    public SeedClass seedClass(SeedClass seedClass) {
        return seedClassRepo.save(seedClass);
    }

    @Autowired
    private StatusChangeRepo statusChangeRepo;

    public StatusChange retrieveStatusChange(int shId)   {
        return statusChangeRepo.findByShId(shId)   ;
    }
    public List<StatusChange> retrieveAllStatusChanges()  {
        return statusChangeRepo.findAll();
    }
    public List<StatusChange>  retrieveUserStatusChanges(int uId)   {
        return statusChangeRepo.findByUserUId(uId) ;
    }
    public StatusChange saveStatusChange(StatusChange statusChange) {
        return statusChangeRepo.save(statusChange);
    }
}


