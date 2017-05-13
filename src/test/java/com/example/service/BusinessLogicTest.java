package com.example.service;

import com.example.model.*;
import com.example.repositories.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import java.util.List;
import static org.apache.coyote.http11.Constants.a;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = {"com.example"})
public class BusinessLogicTest {

//    public Application retrieveApplication(int id)
//    public Role retrieveRole(int rid)
//    public Stage retrieveStage(int sid)
//    public User retrieveUser(String eId)
//    public User createUser(String eId, String email, String firstName, String lastName)
//    public User createUser(User newUser)
//    public Interview retrieveInterview(int intId)
//    public List<Interview> retrieveApplicantInterview(int applicantUId)
//    public InterviewRatings retrieveInterviewRatings(int ratId)
//    public List<InterviewRatings> retrieveApplicantInterviewRatings(int intId)
//    public Question retrieveQuestion(int qId)
//    public List<Question> retrieveClassTypeQuestions(int cId, String qType)
//    public RatingType retrieveRatingType(int rtId)
//    public List<RatingType> retrieveAllRatingTypes()
//    public SeedClass retrieveSeedClass(int cId)
//    public List<SeedClass> retrieveAllSeedClass()
//    public StatusChange retrieveStatusChange(int shId)
//    public List<StatusChange> retrieveAllStatusChanges()
//    public List<StatusChange>  retrieveUserStatusChanges(int uId)
//    public StatusChange saveStatusChange(StatusChange statusChange)

    BusinessLogic businessLogic = new BusinessLogic();

    @Mock @Autowired
    ApplicationRepo applicationRepo;
    @Mock @Autowired
    RoleRepo roleRepo;
    @Mock @Autowired
    StageRepo stageRepo;

//    @Mock
//    InterviewRatingsRepo interviewRatingsRepo;
//    @Mock
//    InterviewRepo interviewRepo;
//    @Mock
//    QuestionsRepo questionsRepo;
//    @Mock
//    RatingTypeRepo ratingType;
//    @Mock
//    SeedClassRepo seedClassRepo;
//    @Mock
//    StatusChange statusChange;
//    @Mock
//    UserRepo userRepo;

    @Test
    public void retrieveApplicationTest() {
       when(applicationRepo.findByApplicantUId(1)).thenReturn(new Application());
       when(applicationRepo.findByApplicantUId(-1)).thenReturn(null);

       Application expected = new Application();
       Application actual_one = businessLogic.retrieveApplication(1);
       Application actual_two = businessLogic.retrieveApplication(-1);
       assertEquals("businessLogic.retrieveApplication(1)", expected, actual_one);
       assertNull("businessLogic.retrieveApplication(-1)", actual_two);
    }

    @Test
    public void retrieveRoleTest() {
        Role expected = new Role(1,"The best", true);

        when(roleRepo.findByRId(1)).thenReturn(expected);
        when(roleRepo.findByRId(-1)).thenReturn(null);

        Role actual_one = businessLogic.retrieveRole(1);
        Role actual_two = businessLogic.retrieveRole(-1);
        assertEquals("businessLogic.retrieveRole(1)", expected, actual_one);
        assertNull("businessLogic.retrieveRole(-1)", actual_two);
    }

    @Test
    public void retrieveStageTest() {
        Stage expected = new Stage(1,"	Registered");

        when(stageRepo.findBySId(1)).thenReturn(expected);
        when(stageRepo.findBySId(-1)).thenReturn(null);

        Stage actual_one = businessLogic.retrieveStage(1);
        Stage actual_two = businessLogic.retrieveStage(-1);
        assertEquals("businessLogic.retrieveRole(1)", expected, actual_one);
        assertNull("businessLogic.retrieveRole(-1)", actual_two);
    }
}
