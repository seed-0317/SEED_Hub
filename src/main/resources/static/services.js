
angular.module("DogModule").service("EmployeeService", function($http) {

    var myService = this;

    myService.getEmployee = function(name) {
        return $http({
            method : "get",
            url : "employee/" + name
        });
    };

    myService.getUser = function(eid) {
        return $http({
            method : "get",
            url: "user/" + eid
        })
    }

});

