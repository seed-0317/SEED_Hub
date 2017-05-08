
angular.module("DogModule").service("EmployeeService", function($http) {

    var myService = this;

    myService.getEmployee = function(name) {
        return $http({
            method : "get",
            url : "employee/" + name
        });
    };


    /**
     * Create Employee
     *
     * @param employee is an object
     * @returns a promise
     */
    myService.createEmployee = function(employee) {
        return $http({
            url: "/employee",
            method: "post",
            data: employee
        });
    };


});
