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


angular.module("DogModule").controller("CreateEmployeeCtrl", function(EmployeeService) {

    var data = this;

    data.createEmployee = function(dog) {

        var employee = {
            name : dog
        };

        var promise = EmployeeService.createEmployee(employee);


        promise.then(function(response) {
            //SUCCESS
            console.log("SUCCESS - create employee");
        }, function(response) {
            //FAILURE
            console.log("FAILURE - create employee");
        });

    };


});


