
angular.module("DogModule").service("UserService", function($http) {

    var myService = this;

    myService.getUser = function(eid) {
        return $http({
            method : "get",
            url: "user/" + eid
        })
    }

});

