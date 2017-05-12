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

    myService.getApplication = function (eid) {
        return $http({
            method: "GET",
            url: "application/" + eid
        })
    };

    myService.postApplication = function (eId, mgr_email, selectedSeedClass, dept, techskills_languages, education, tech_orgs, seed_success, comments, curr_role, curr_level, strong_plus) {
        return $http({
            method: "POST",
            url: "application/" + eId,
            data: {
                "seedClass" : selectedSeedClass,
                "mgr_email": mgr_email,
                "dept": dept,
                "techskills_languages": techskills_languages,
                "education": education,
                "tech_orgs": tech_orgs,
                "seed_success": seed_success,
                "comments": comments,
                "curr_role": curr_role,
                "curr_level": curr_level,
                "strong_plus": strong_plus
            }
        })
    };

    myService.getClassList = function () {
        return $http({
            method: "GET",
            url: "seedclass/"
        })
    };

    myService.getQuestionList = function () {
        return $http({
            method: "GET",
            url: "question/"
        })
    };


    myService.getRatingTypes = function () {
        return $http({
            method: "GET",
            url: "ratingtype/"
        })
    };

    myService.postQuestion = function(question) {
        return $http({
            method: "POST",
            url: "question/",
            data: question
        })
    };

});