angular.module("DogModule").controller("HomeCtrl", function(UserService, $state, $scope) {

    var homeCtrl = this;

    homeCtrl.createNewUser = function(){
        console.log('homeCtrl.createNewUser');
        $state.go('createUser');
    }

    homeCtrl.createUser = function(eid,email,firstName,lastName){
        console.log('homeCtrl.createUser with data');
        var promise = UserService.postUser(eid,email,firstName,lastName);

        promise.then(function(response){
            console.log('homeCtrl.createUser was successful');
            $scope.user=response.data;
            homeCtrl.user=response.data;
            $state.go('home')
        }), function(){
            console.log('homeCtrl.createUser was not successful');
            $state.reload();
        }
    }

    homeCtrl.getUser = function(eid){
        console.log('homeCtrl.getUser');
        var promise = UserService.getUser(eid);

        promise.then(function(response) {
            //SUCCESS
            console.log('homeCtrl.getUser was successful');
            $scope.user=response.data;
            homeCtrl.user = response.data;
            $state.go('home');
        }), function() {
            console.log('homeCtrl.getUser was not successful');
            $state.go('login');
        }
    }
});

angular.module("DogModule").controller("ApplicationCtrl", function(UserService, $state) {
    var applicationCtrl = this;

    applicationCtrl.getApplication = function(eid){
        $state.go('application');
    }

    applicationCtrl.postApplication = function(eId, u_id, mgr_id, c_id, dept, techskills_languages, education, tech_orgs, seed_success, comments, curr_role, curr_level, strong_plus) {
        var promise = UserService.postApplication(eId, u_id, mgr_id, c_id, dept, techskills_languages, education, tech_orgs, seed_success, comments, curr_role, curr_level, strong_plus);

        promise.then(function (response) {
            //SUCCESS
            console.log('applicationCtrl.postApplication was successful');
            $state.go('home')
        }), function (response) {
            console.log('applicationCtrl.postApplication was not successful');
            $state.reload();
        }
    }
});
