angular.module("DogModule").controller("homeCtrl", function(UserService, $state, $cookies) {

    var homeCtrl = this;

    homeCtrl.user = $cookies.getObject('user');
});

angular.module("DogModule").controller("loginCtrl", function(UserService, $state, $cookies) {

    var loginCtrl=this;

    $cookies.remove('user');

    loginCtrl.createNewUser = function(){
        console.log('loginCtrl.createNewUser');
        $state.go('createUser');
    }

    loginCtrl.getUser = function(eid){
        console.log('loginCtrl.getUser');
        var promise = UserService.getUser(eid);

        promise.then(function(response) {
            //SUCCESS
            console.log('loginCtrl.getUser was successful');

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

    createUserCtrl.user = $cookies.get('user');

    createUserCtrl.createUser = function (eid, email, firstName, lastName) {
        console.log('createUserCtrl.createUser with data');
        var promise = UserService.postUser(eid, email, firstName, lastName);

        promise.then(function (response) {
            console.log('createUserCtrl.createUser was successful');

            $cookies.putObject('user',response.data);

            $state.go('home');
        }), function () {
            console.log('createUserCtrl.createUser was not successful');
            alert("Failure: " + JSON.stringify({data: response.data}));

            $state.reload();
        }
    }
});

angular.module("DogModule").controller("adminCtrl", function(UserService, $state, $cookies) {
    var adminCtrl = this;
    adminCtrl.user=$cookies.getObject('user');
});

angular.module("DogModule").controller("newClassCtrl", function(UserService, $state, $cookies) {
    var newClassCtrl = this;
    newClassCtrl.user=$cookies.getObject('user');
});

angular.module("DogModule").controller("addUserCtrl", function(UserService, $state, $cookies) {
    var addUserCtrl = this;
    addUserCtrl.user=$cookies.getObject('user');
});

angular.module("DogModule").controller("interviewerCtrl", function(UserService, $state, $cookies) {
    var interviewerCtrl = this;
    interviewerCtrl.interviewer=$cookies.getObject('user');

    //get application List
    //save selected applicant as a cookie 'applicant'
    //get questions(seedclass,intType)
    //post interview
    //post interviewResponses

});
// application controller
angular.module("DogModule").controller("applicationCtrl", function(UserService, $state, $cookies) {
    var applicationCtrl = this;

    applicationCtrl.user=$cookies.get('user');

    applicationCtrl.getApplication = function(){
        $state.go('application');
    };

    var promise1 = UserService.getClassList();

    promise1.then(function (response) {
        //SUCCESS
        applicationCtrl.classSet = response.data;
        console.log(JSON.stringify({data: applicationCtrl.classSet}));
    }), function (response) {
        //FAILURE
        alert("Failure retrieving class list: " + JSON.stringify({data: response.data}));
    };

    applicationCtrl.postApplication = function(eId, mgr_id, selectedSeedClass, dept, techskills_languages, education, tech_orgs, seed_success, comments, curr_role, curr_level, strong_plus) {
        var promise = UserService.postApplication(eId, mgr_id, selectedSeedClass, dept, techskills_languages, education, tech_orgs, seed_success, comments, curr_role, curr_level, strong_plus);

        promise.then(function (response) {
            //SUCCESS
            console.log('applicationCtrl.postApplication was successful');
            $state.go('home');
        }), function (response) {
            //FAILURE
            console.log('applicationCtrl.postApplication was not successful');
            alert("Failure: " + JSON.stringify({data: response.data}));

            $state.reload();
        }
    }
});
//end application controller

angular.module("DogModule").controller("buildIntCtrl", function(UserService, $state, $cookies) {
    var buildIntCtrl = this;
    var promise1 = UserService.getClassList();
    var promise2 = UserService.getRatingTypes();
    buildIntCtrl.user=$cookies.getObject('user');

    promise1.then(function (response) {
        //SUCCESS
        buildIntCtrl.classSet = response.data;
        console.log(JSON.stringify({data: buildIntCtrl.classSet}));
    }), function (response) {
        //FAILURE
        alert("Failure retrieving class list: " + JSON.stringify({data: response.data}));
    };

    promise2.then(function (response) {
        //SUCCESS
        buildIntCtrl.ratingTypes = response.data;
        console.log(JSON.stringify({data: buildIntCtrl.ratingTypes}));
    }), function (response) {
        //FAILURE
        alert("Failure retrieving ratingTypes: " + JSON.stringify({data: response.data}));
    };
    //buildIntCtrl.questionSet = UserService.getQuestionList();


    buildIntCtrl.selectedQuestions =[];
    buildIntCtrl.selectedSeedClass = null;
    buildIntCtrl.qType = null;
    buildIntCtrl.qSeq = null;
    buildIntCtrl.qText = null;
    buildIntCtrl.ratingType = null;
    buildIntCtrl.addQuestion = function() {
        var question = {

            "seedClass" : buildIntCtrl.selectedSeedClass,
            "qSequence" : buildIntCtrl.qSeq,
            "qText": buildIntCtrl.qText,
            "ratingType": buildIntCtrl.ratingType,
            "qType": buildIntCtrl.qType
        };
        buildIntCtrl.selectedQuestions.push(question);
    };
    buildIntCtrl.postQuestions = function(){
        //for each question in selectedQuestions, UserService.postQuestion(...)
        var question = null;
        var promise = null;
        var ok = true;
        if (!(buildIntCtrl.selectedQuestions.length >0)){
            alert("Nothing to Submit! Please add questions and try again.");
        }
        else {
          while (buildIntCtrl.selectedQuestions.length >0) {
              question = buildIntCtrl.selectedQuestions.shift();
              promise = UserService.postQuestion(question);
              promise.then(function (response) {
                  //SUCCESS
                  console.log("Question posted: " +JSON.stringify({data: response.data}));
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