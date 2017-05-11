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

    myService.postApplication = function (eId, u_id, mgr_id, c_id, dept, techskills_languages, education, tech_orgs, seed_success, comments, curr_role, curr_level, strong_plus) {
        return $http({
            method: "POST",
            url: "application/" + eid,
            data: {
                "u_id": u_id,
                "mgr_id": mgr_id,
                "c_id": c_id,
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

    myservice.getQuestionList = function () {
        return $http({
            method: "GET",
            url: "questions/"
        })
    };


    myservice.getRatingTypes = function () {
        return $http({
            method: "GET",
            url: "ratingtype/"
        })
    };

    myservice.postQuestion = function() {
        return $http({
            method: "POST",
            url: "questions/"
        })
    };

});