angular.module("DogModule").controller("HomeCtrl", function() {

});

angular.module("DogModule").controller("AboutCtrl", function(EmployeeService) {


    var aboutCtrl = this;

    aboutCtrl.doSomething = function(name) {

        var promise = EmployeeService.getEmployee(name);

        promise.then(function(response) {
            //SUCCESS
            aboutCtrl.employee = response.data;
        }, function() {
            //FAILURE
        });

    };

});

angular.module("DogModule").controller("LoginCtrl", function(EmployeeService) {



});