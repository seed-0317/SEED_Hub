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


angular.module("DogModule").controller("applicationCtrl", function(UserService, $state, $cookies) {
    var applicationCtrl = this;

    applicationCtrl.user=$cookies.get('user');

    applicationCtrl.getApplication = function(eid){
        $state.go('application');
    };

    applicationCtrl.postApplication = function(eId, u_id, mgr_id, c_id, dept, techskills_languages, education, tech_orgs, seed_success, comments, curr_role, curr_level, strong_plus) {
        var promise = UserService.postApplication(eId, u_id, mgr_id, c_id, dept, techskills_languages, education, tech_orgs, seed_success, comments, curr_role, curr_level, strong_plus);

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

angular.module("DogModule").controller("adminCtrl", function(UserService, $state, $cookies) {
    var adminCtrl = this;
    adminCtrl.user=$cookies.getObject('user');
});

angular.module("DogModule").controller("newClassCtrl", function(UserService, $state, $cookies) {
    var newClassCtrl = this;
    newClassCtrl.user=$cookies.getObject('user');

   var promise = UserService.getClassList();

   promise.then(function(response) {
       //success
       newClassCtrl.classList = response.data;
   }, function(response) {
       //failure
   })

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

angular.module("DogModule").controller("buildIntCtrl", function(UserService, $state, $cookies) {
    var buildIntCtrl = this;
    buildIntCtrl.user=$cookies.getObject('user');

    var classSet = UserService.getClassList();

    var questionSet = UserService.getQuestionList();

    var ratingTypes = UserService.getRatingTypes();

    var selectedQuestions =[];

    buildIntCtrl.AddQuestion = function(seedClass, qSeq, qText, ratingType, qType) {
        var question = {
            "seedClass" : seedClass,
            "qSequence" : qSeq,
            "qText": qText,
            "ratingType": ratingType,
            "qType": qType
        };
        selectedQuestions.push(question);
    };

    buildIntCtrl.postQuestions = function(){
        //for each question in selectedQuestions, UserService.postQuestion(...)
        var question = null;
        var promise = null;
        var ok = true;
        while (selectedQuestions.length >0) {
            question = selectedQuestions.shift();
            promise = UserService.postQuestion();
            promise.then(function (response) {
                //SUCCESS
                //Next
            }), function (response) {
                //FAILURE
                ok=false;
                console.log('buildIntCtrl.postQuestion was not successful');
                alert("Failure: " + JSON.stringify({data: response.data}));
            }
        }
        if (ok) {
            alert("Question set succesfully saved!")
        };
    };

});