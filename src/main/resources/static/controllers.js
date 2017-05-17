angular.module("DogModule").controller("homeCtrl", function(UserService, $state, $cookies) {

    var homeCtrl = this;

    homeCtrl.user = $cookies.getObject('user');
});

angular.module("DogModule").controller("loginCtrl", function(UserService, $state, $cookies) {

    var loginCtrl=this;

    $cookies.remove('user');

    loginCtrl.createNewUser = function(){
        // console.log('loginCtrl.createNewUser');
        $state.go('createUser');
    };

    loginCtrl.getUser = function(eid){
        // console.log('loginCtrl.getUser');
        var promise = UserService.getUser(eid);

        promise.then(function(response) {
            //SUCCESS
            // console.log('loginCtrl.getUser was successful');

            $cookies.putObject('user', response.data);
            loginCtrl.user = $cookies.getObject('user');

            //route based on user role
            if (loginCtrl.user.role.rID === 4) {  //Program Team
                $state.go('admin');
            }
            else if (loginCtrl.user.role.rID === 5) {  //Interviewer
                $state.go('admin');
            }
            else if (loginCtrl.user.role.rID === 3) {  //Manager
                $state.go('manager');
            }
            else {  //Applicant
                $state.go('home');
            }

        }), function() {
            console.log('loginCtrl.getUser was not successful');
            alert("Failure: " + JSON.stringify({data: response.data}));

            $state.go('login');
        }
    }
});


angular.module("DogModule").controller("createUserCtrl", function(UserService, $state, $cookies) {

    var createUserCtrl = this;

    createUserCtrl.user = $cookies.getObject('user');

    createUserCtrl.createUser = function (eid, email, firstName, lastName) {
        // console.log('createUserCtrl.createUser with data');
        var promise = UserService.postUser(eid, email, firstName, lastName);

        promise.then(function (response) {
            // console.log('createUserCtrl.createUser was successful');
            $cookies.putObject('user',response.data);

            $state.go('home');
        }), function () {
            console.log('createUserCtrl.createUser was not successful');
            alert("Failure: " + JSON.stringify({data: response.data}));

            $state.reload();
        }
    }
});

angular.module("DogModule").controller("newClassCtrl", function(UserService, $state, $cookies) {
    var newClassCtrl = this;
    newClassCtrl.user = $cookies.getObject('user');

    var promise = UserService.getClassList();

    promise.then(function (response) {
        //success
        newClassCtrl.classList = response.data;
    }, function (response) {
        console.log('newClassCtrl.getClassList failed');
        alert("Failure: " + JSON.stringify({data: response.data}));
    });

    newClassCtrl.postSeedClass = function (c_yr, c_num, c_loc, c_app_open_dt, c_app_deadline, c_bootcamp_dt) {

        var promise = UserService.postSeedClass(c_yr, c_num, c_loc, c_app_open_dt, c_app_deadline, c_bootcamp_dt);

        promise.then(function (response) {
            // console.log('newClassCtrl.postSeedClass was successful');
            $state.go('newClass');
            $state.reload();
        }), function (response) {
            //FAILURE
            console.log('newClassCtrl.postSeedClass failed');
            alert("Failure: " + JSON.stringify({data: response.data}));

            $state.reload();
        }
    };
});

angular.module("DogModule").controller("viewAppsCtrl", function(UserService, $state, $cookies) {
    var viewAppsCtrl = this;

    viewAppsCtrl.viewapps = [];

    viewAppsCtrl.user = $cookies.getObject('user');

    var promise = UserService.getAllApplications();
    promise.then(function (response) {
        //SUCCESS
        // console.log('viewAppsCtrl.getAllApplication was successful');
        // console.log(response.data);

        viewAppsCtrl.viewapps =response.data;
    }), function (response) {
        //FAILURE
        console.log('viewAppsCtrl.getAllApplication was not successful');
        alert("Failure: " + JSON.stringify({data: response.data}));
    }
});

angular.module("DogModule").controller("adminCtrl", function(UserService, $state, $cookies) {
    var adminCtrl = this;
    adminCtrl.user=$cookies.getObject('user');
});


angular.module("DogModule").controller("userResourceCtrl", function(UserService, $state, $cookies) {
    var adminCtrl = this;
    adminCtrl.user=$cookies.getObject('user');
});


angular.module("DogModule").controller("addUserCtrl", function(UserService, $state, $cookies) {
    var addUserCtrl = this;
    addUserCtrl.user=$cookies.getObject('user');

    var promise1=UserService.getAllRoles();

    promise1.then(function(response){
        addUserCtrl.roles= response.data;
        // console.log(response.data);
    }), function (response) {
        console.log('addUserCtrl.getAllRoles was not successful');
        alert("Failure: " + JSON.stringify({data: response.data}));
    };

    var promise2=UserService.getAllStages();

    promise2.then(function(response){
        addUserCtrl.stages=response.data;
        // console.log(response.data);
    }), function (response) {
        console.log('addUserCtrl.getAllStages was not successful');
        alert("Failure: " + JSON.stringify({data: response.data}));
    };

    addUserCtrl.createUser = function (eid, email, firstName, lastName, role, stage) {
        console.log(role);
        console.log(stage);
        var promise = UserService.postCreatedUser(eid, email, firstName, lastName, role, stage);

        promise.then(function (response) {
            // console.log('addUserCtrl.createUser was successful');

            $state.go('admin');
        }), function (response) {
            console.log('addUserCtrl.createUser was not successful');
            alert("Failure: " + JSON.stringify({data: response.data}));

            $state.reload();
        }
    }
});

angular.module("DogModule").controller("interviewCtrl", function(UserService, $state, $cookies) {
    var interviewCtrl = this;
    interviewCtrl.interviewer=$cookies.getObject('user');
    interviewCtrl.applicant = null;
    interviewCtrl.applicantSet = [];
    interviewCtrl.intType = null;
    interviewCtrl.intTypeSet = [];
    interviewCtrl.selectedSeedClass = null;
    interviewCtrl.questionSet = [];
    interviewCtrl.answerSet = [];
    interviewCtrl.interview = [];
    var promise = UserService.getQuestionList();
    promise.then(function (response) {
        //SUCCESS
        interviewCtrl.questionSet = response.data;
        // console.log(JSON.stringify({data: interviewCtrl.questionSet}));
    }), function (response) {
        //FAILURE
        alert("Failure retrieving question list: " + JSON.stringify({data: response.data}));
    };
    var promise1 = UserService.getClassList();
    promise1.then(function (response) {
        //SUCCESS
        interviewCtrl.classSet = response.data;
    }), function (response) {
        //FAILURE
        console.log('interviewCtrl.getClassList has failed');
        alert("Failure retrieving class list: " + JSON.stringify({data: response.data}));
    };

    interviewCtrl.classSelected = function() {
        // build the intTypeSet to include only the types contained in the selected class
        var len = interviewCtrl.questionSet.length;
        var i =0;
        var j =0;
        var dupe = false;

        while (i<len) {  //cycle through each question and see if the question is for this class

            if (interviewCtrl.questionSet[i].seedClass.cId === interviewCtrl.selectedSeedClass.cId){
                //if the type is n ot in intTypeSet, add it
                j=0;
                dupe = false;
                while(j<interviewCtrl.intTypeSet.length && dupe !== true) {
                    if (interviewCtrl.intTypeSet[j] === interviewCtrl.questionSet[i].qType){
                        dupe= true;
                    }
                    j++;
                }
                if (dupe !== true){
                    interviewCtrl.intTypeSet.push(interviewCtrl.questionSet[i].qType);
                }
            }
            i++;
        }
        interviewCtrl.intTypeSet.sort();
        interviewCtrl.intType = interviewCtrl.intTypeSet[0];

        //retrieve the applicants for the selected class

        var promise2 = UserService.getClassApplicants(interviewCtrl.selectedSeedClass.cId);
        promise2.then(function (response) {
            //SUCCESS
            interviewCtrl.applicantSet = response.data;
        }), function (response) {
            //FAILURE
            console.log('interviewCtrl.getClassApplicants failed');
            alert("Failure retrieving applicant list: " + JSON.stringify({data: response.data}));
        };

        interviewCtrl.typeSelected();

    };


    function Answer(question,interview,rating,comments,ratingSet)
    {
        this.question=question;
        this.interview=interview;
        this.rating=rating;
        this.comments=comments;
        this.ratingSet = ratingSet;
    };

    function InterviewRating(question,interview,rating,comments)
    {
        this.question=question;
        this.interview=interview;
        this.rating=rating;
        this.comments=comments;
    };

    interviewCtrl.typeSelected = function() {
        //get questions(seedclass,intType)
        //build display qset including answer fields to display

        var qSet = [];
        var q;
        var p =[];
        var scaleSet = [];

        function addScale(i) {
            var answer;
            p[i] = UserService.getRatingScalesForRatingType(qSet[i].ratingType.rtId);
            p[i].then(function(response) {
                //SUCCESS
                scaleSet[i]= response.data;
                scaleSet[i].sort(function (a, b) {
                    return a.rsNum - b.rsNum
                });
                answer = new Answer(qSet[i], interviewCtrl.interviewer, null, null, scaleSet[i]);
                interviewCtrl.answerSet.push(answer);
                interviewCtrl.answerSet.sort(function (a, b) {
                    return a.question.qSequence - b.question.qSequence
                });
                return scaleSet[i];
            }),function (response) {
                //FAILURE
                console.log('interviewCtrl.getScaleSet failed');
                alert("Failure retrieving scale set: " + JSON.stringify({data: response.data}));
            };
        };

        var promise3 = UserService.getClassTypeQuestionList(interviewCtrl.selectedSeedClass.cId,interviewCtrl.intType);

        promise3.then(function (response) {
            //SUCCESS
            qSet = response.data;

            var answer;
            var len = qSet.length;
            var i=0;
            var b;

            interviewCtrl.answerSet = [];
            for (i=0; i<len; i++) {
                //need to define the scaleSet for each question

                b = new addScale(i);

            }

        }), function (response) {
            //FAILURE
            console.log("interviewCtrl.getClassTypeQuestionList")
            alert("Failure retrieving questions for class and type: " + JSON.stringify({data: response.data}));
        };
    };

    interviewCtrl.saveAnswers = function(){

        // NEED TO SAVE INTERVIEW FIRST, GET THE INTERVIEW OBJECT BACK
        // AND USE THAT TO SAVE THE ANSWERS
        var tint = {
            intId: null,
            seedClass: interviewCtrl.selectedSeedClass,
            applicant: interviewCtrl.applicant.applicant,
            interviewer: interviewCtrl.interviewer,
            interviewDt: Date.now(),
            intType: interviewCtrl.intType
        }

        var len = interviewCtrl.answerSet.length;
        var promise = [];

        var promise1 = UserService.postInterview(tint);
        promise1.then(function (response) {
            //SUCCESS
            interviewCtrl.interview = response.data;
          //  interviewCtrl.interview = new Interview(tint);
            //now save the ratings
            for (i=0; i<len; i++){
                rating = new InterviewRating(interviewCtrl.answerSet[i].question, interviewCtrl.interview, interviewCtrl.answerSet[i].rating, interviewCtrl.answerSet[i].comments);

                promise[i] = UserService.postAnswer(rating);
                promise[i].then(function (response) {

                }), function (response) {
                    //FAILURE
                    console.log('interviewCtrl.postAnswers failed');
                    alert("Failure: " + JSON.stringify({data: response.data}));

                }
            }
            $state.reload();

        }), function (response) {
            //FAILURE
            console.log('interviewCtrl.postInterview failed');
            alert("Failure: " + JSON.stringify({data: response.data}));
        }




    };
});

angular.module("DogModule").controller("applicationCtrl", function(UserService, $state, $cookies) {

    var findX = function (array, id) {
        if (array === undefined || id === undefined) {
            return;
        }
        for (var i = 0; i < array.length; i++) {
            if (array[i].cId === id) {
                return i;
            }
        }

    }

    var applicationCtrl = this;
    applicationCtrl.ExistingApplicationData = [];
    applicationCtrl.SelectedApplicationData = {
        applicant: null,
        appId: null,
        comments: null,
        currLevel: null,
        currRole: null,
        dept: null,
        education: null,
        managerEmail: null,
        mgrApproval: null,
        seedClass: null,
        seedSuccess: null,
        strongPlus: null,
        techOrgs: null,
        techSkillsLangs: null
    };

    applicationCtrl.user = $cookies.getObject('user');
    // console.log (applicationCtrl.user);
    var i = 0;
    var existingApplicationData = UserService.getApplication(applicationCtrl.user.uId);

    existingApplicationData.then(function (response) {
        console.log(response.data);
        applicationCtrl.ExistingApplicationData = response.data;
        if (applicationCtrl.ExistingApplicationData.length <= 1) {
            applicationCtrl.SelectedApplicationData = applicationCtrl.ExistingApplicationData[0];
        }
        else {
            applicationCtrl.SelectedApplicationData = applicationCtrl.ExistingApplicationData[0];

            for (i = 1; i < applicationCtrl.ExistingApplicationData.length; i++) {
                if (applicationCtrl.SelectedApplicationData.appId < applicationCtrl.ExistingApplicationData[i].appId) {
                    applicationCtrl.SelectedApplicationData = applicationCtrl.ExistingApplicationData[i];
                }
            }
        }
        if (applicationCtrl.classSet) {
            console.log ("Selected: " + JSON.stringify(applicationCtrl.SelectedApplicationData));
            // var dog = findX(applicationCtrl.classSet, applicationCtrl.SelectedApplicationData.seedClass.cId);
            if (dog !== undefined) {
                applicationCtrl.x = dog;
            }
        }
    }),
        function (response) {
            console.log('applicationCtrl.getApplication has failed');
    };

    applicationCtrl.getApplication = function () {
        $state.go('application');
    };

    var promise1 = UserService.getClassList();

    promise1.then(function (response) {
        //SUCCESS
        applicationCtrl.classSet = response.data;
        if (applicationCtrl.SelectedApplicationData) {
            var dog = findX(applicationCtrl.classSet, applicationCtrl.SelectedApplicationData.seedClass.cId);
            if (dog !== undefined) {
                applicationCtrl.x = dog;
            }
        }
        // console.log(JSON.stringify({data: applicationCtrl.classSet}));
    }), function (response) {
        //FAILURE
        console.log("applicationCtrl.getClassList has failed");
        alert("Failure retrieving class list: " + JSON.stringify({data: response.data}));
    };

    applicationCtrl.postApplication = function () {
        console.log(applicationCtrl.SelectedApplicationData);
        // console.log(mgr_email, selectedSeedClass, dept, techskills_languages, education, tech_orgs, seed_success, comments, curr_role, curr_level, strong_plus);

        var promise = UserService.postApplication(applicationCtrl.SelectedApplicationData);

        promise.then(function (response) {
            //SUCCESS
            // console.log('applicationCtrl.postApplication was successful');
            $state.go('home');
        }), function (response) {
            //FAILURE
            console.log('applicationCtrl.postApplication was not successful');
            alert("Failure: " + JSON.stringify({data: response.data}));

            $state.reload();
        }
    };
    // applicationCtrl.getExistingApplicationData = function(uid)
});


angular.module("DogModule").controller("buildIntCtrl", function(UserService, $state, $cookies) {
    var buildIntCtrl = this;
    var promise1 = UserService.getClassList();
    var promise2 = UserService.getRatingTypes();
    buildIntCtrl.user=$cookies.getObject('user');

    promise1.then(function (response) {
        //SUCCESS
        buildIntCtrl.classSet = response.data;
        // console.log(JSON.stringify({data: buildIntCtrl.classSet}));
    }), function (response) {
        //FAILURE
        console.log('buildIntCtrl.getClassList was not successful');
        alert("Failure: " + JSON.stringify({data: response.data}));
    };

    promise2.then(function (response) {
        //SUCCESS
        buildIntCtrl.ratingTypes = response.data;
        // console.log(JSON.stringify({data: buildIntCtrl.ratingTypes}));
    }), function (response) {
        //FAILURE
        console.log('buildIntCtrl.getRatingTypes was not successful');
        alert("Failure: " + JSON.stringify({data: response.data}));
    };
    //buildIntCtrl.questionSet = UserService.getQuestionList();

    buildIntCtrl.selectedQuestions =[];
    buildIntCtrl.selectedSeedClass = null;
    buildIntCtrl.qType = null;
    buildIntCtrl.qSeq = 1;
    buildIntCtrl.qText = null;
    buildIntCtrl.ratingType = null;

    buildIntCtrl.addQuestion = function() {
        //check for data before adding
        if (buildIntCtrl.selectedSeedClass === null ||
            buildIntCtrl.qText === null ||
            buildIntCtrl.ratingType === null ||
            buildIntCtrl.qType === null  ||
            ! (buildIntCtrl.qSeq >0)) {
                alert("Please enter all required fields and try again.");
        }
        else{
            var question = {
                qId: null,
                seedClass : buildIntCtrl.selectedSeedClass,
                qSequence : buildIntCtrl.qSeq,
                qText: buildIntCtrl.qText,
                ratingType: buildIntCtrl.ratingType,
                qType: buildIntCtrl.qType
            };

            buildIntCtrl.selectedQuestions.push(question);
            buildIntCtrl.qSeq++;
            buildIntCtrl.qText = null;
            buildIntCtrl.ratingType = null;
        }
    };

    buildIntCtrl.removeQuestion = function(seq){
        //remove the question with sequence # seq
        // and reorder remaining questions in selectedQuestions

         var questSet = [];
         var question = null;
         var len = buildIntCtrl.selectedQuestions.length;
         var i=0;
         while( i< len) {
             question = buildIntCtrl.selectedQuestions.shift();
             if (question.qSequence !== seq){
                 if (question.qSequence > seq) {
                     question.qSequence--;
                 }
                 questSet.push(question);
             }
             i++;
         }
        buildIntCtrl.selectedQuestions = questSet;
        buildIntCtrl.qSeq =len;
    };
    buildIntCtrl.moveQuestionUp = function(seq){
        //swap the question with sequence # = seq
        // with the one with seq-1 in selectedQuestions and sort

        var questSet = [];
        var question = null;
        var swapQ = null;
        var len = buildIntCtrl.selectedQuestions.length;
        var i=0;
        if (seq>1){
            while (i<len){
                question = buildIntCtrl.selectedQuestions.shift();
                if (question.qSequence === seq-1) {
                    // swap this and the next and assign their qSequence
                    swapQ = question;
                    swapQ.qSequence = seq;
                    question = buildIntCtrl.selectedQuestions.shift();
                    question.qSequence = seq-1;
                    questSet.push(question);
                    questSet.push(swapQ);
                    i++;
                    i++; // already handled the next
                }
                else {
                    questSet.push(question);
                    i++;
                }
            }
            buildIntCtrl.selectedQuestions = questSet;
        }
    };

    buildIntCtrl.moveQuestionDown = function(seq){
        //swap the question with sequence # seq
        // with the one with seq+1 in selectedQuestions and sort

        var questSet = [];
        var question = null;
        var swapQ = null;
        var len = buildIntCtrl.selectedQuestions.length;
        var i=0;
        if (seq<len){
            while (i<len){
                question = buildIntCtrl.selectedQuestions.shift();
                if ((question.qSequence === seq)  && (seq !== len)) {
                    // swap this and the next and assign their qSequence
                    swapQ = question;
                    swapQ.qSequence = seq+1;
                    question = buildIntCtrl.selectedQuestions.shift();
                    question.qSequence = seq;
                    questSet.push(question);
                    questSet.push(swapQ);
                    i++;
                    i++; // already handled the next
                }
                else {
                    questSet.push(question);
                    i++;
                }
            }
            buildIntCtrl.selectedQuestions = questSet;
        }
    };
    buildIntCtrl.postQuestions = function(){
        //for each question in selectedQuestions, UserService.postQuestion(...)
        var question = null;
        var promise= [];
        var ok = true;
        if (!(buildIntCtrl.selectedQuestions.length >0)){
            alert("Nothing to Submit! Please add questions and try again.");
        }
        else {
          var i =0  ;
            // console.log("In controllers.js, selectedQuestions: " +JSON.stringify(buildIntCtrl.selectedQuestions));
          while (buildIntCtrl.selectedQuestions.length >0) {
              i++;
              question = buildIntCtrl.selectedQuestions.shift();
              // console.log("In controllers.js, question.seedClass: "  +question.SeedClass);
              // console.log("In controllers.js, selectedQuestions: "  +buildIntCtrl.selectedQuestions);
              promise[i] = UserService.postQuestion(question.seedClass, question.qSequence, question.qText, question.ratingType, question.qType) ;
              promise[i].then(function (response) {
                  //SUCCESS
                  // console.log("Question posted: " +JSON.stringify({data: response.data}));
              }), function (response) {
                  //FAILURE
                  ok = false;
                  console.log('buildIntCtrl.postQuestion was not successful');
                  alert("Failure: " + JSON.stringify({data: response.data}));
              }
          }
        }
    };
});