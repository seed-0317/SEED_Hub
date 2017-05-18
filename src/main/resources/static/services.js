angular.module("DogModule").service("UserService", function($http) {

    var myService = this;

    myService.getUser = function (eId) {
        return $http({
            method: "GET",
            url: "user/" + eId
        })
    };

    myService.postUser = function (eId, email, fname, lname) {
        return $http({
            method: "POST",
            url: "user/",
            headers: {
                "Content-Type": "application/json"
            },
            data: {
                "eId": eId,
                "email": email,
                "fname": fname,
                "lname": lname
            }
        })
    };

    myService.postCreatedUser = function (eId, email, fname, lname, role, stage) {
        return $http({
            method: "POST",
            url: "user/" + role.rID + "/" + stage.sId,
            headers: {
                "Content-Type": "application/json"
            },
            data: {
                "eId": eId,
                "email": email,
                "fname": fname,
                "lname": lname,
                "role": role,
                "stage": stage
            }
        })
    };


    myService.getApplication = function (eid) {
        return $http({
            method: "GET",
            url: "application/" + eid
        })
    };

    myService.postApplication = function (application) {
        return $http({
            method: "POST",
            url: "application/",
            headers: {
                "Content-Type": "application/json"
            },
            data: application
        })
    };

    myService.getAllStages = function () {
        return $http({
            method: "GET",
            url: "stage"
        })
    };

    myService.getAllRoles = function () {
        return $http({
            method: "GET",
            url: "role"
        })
    };

    myService.getAllApplications = function () {
        return $http({
            method: "GET",
            url: "viewapps/"
        })
    };


    myService.getClassList = function () {
        return $http({
            method: "GET",
            url: "seedclass/"
        })
    };

    myService.postSeedClass = function(c_yr, c_num, c_loc, c_app_open_dt, c_app_deadline, c_bootcamp_dt){
        return $http({
            method:"POST",
            url:"seedclass/",
            data:{
                "cYr":c_yr,
                "cNum":c_num,
                "cLoc":c_loc,
                "cAppOpenDate":c_app_open_dt,
                "cAppDeadline":c_app_deadline,
                "cBootcampDate":c_bootcamp_dt
            }
        })

    };

    myService.getQuestionList = function () {
        return $http({
            method: "GET",
            url: "question/"
        })
    };

    myService.getClassTypeQuestionList = function (cId, qType) {
        return $http({
            method: "GET",
            url: "question/typeandclass/" + qType + "/" + cId
        })
    };

    myService.getRatingTypes = function () {
        return $http({
            method: "GET",
            url: "ratingtype/"
        })
    };

    myService.getRatingScalesForRatingType = function(rtId) {
        return $http({
            method: "GET",
            url: "ratingscale/ratingtype/" + rtId
        })
    };

    myService.postQuestion = function(seedClass, qSequence, qText, ratingType, qType) {
        return $http({
            method: "POST",
            url: "question/",
            headers: {
                "Content-Type": "application/json"
            },
            data: {
                "seedClass" : seedClass,
                "qSequence": qSequence,
                "qText": qText,
                "ratingType": ratingType,
                "qType": qType
            }
        })
    };

    myService.postAnswer = function(answer) {
        return $http({
            method: "POST",
            url: "interviewratings/",
            headers: {
                "Content-Type": "application/json"
            },
            data: answer
        })
    }

    myService.postInterview = function(interview){
        return $http({
            method: "POST",
            url: "interview/",
            headers: {
                "Content-Type": "application/json"
            },
            data: interview
        })
    }


    myService.getClassApplicants = function(cId) {
        return $http({
            method: "GET",
            url: "application/class/" + cId
        })
    };
});