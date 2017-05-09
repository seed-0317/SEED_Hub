var app = angular.module("DogModule", ['ui.router', 'ngCookies']);

app.config(function($stateProvider, $urlRouterProvider) {

    var homeState = {
        name: 'home',
        url: '/home',
        templateUrl: 'templates/home.html',
        controller: 'homeCtrl',
        controllerAs: 'home'
    };

    var loginState = {
        name: 'login',
        url: '/',
        templateUrl: 'templates/login.html',
        controller: 'loginCtrl',
        controllerAs: 'login'
    };

    var createUserState = {
        name: 'createUser',
        url: '/createUser',
        templateUrl: 'templates/createUser.html',
        controller: 'createUserCtrl',
        controllerAs: 'createUser'
    };

    var applicationState = {
        name: 'application',
        url: '/application',
        templateUrl: 'templates/application.html',
        controller: 'applicationCtrl',
        controllerAs: 'application'
    };

    $stateProvider.state(homeState);
    $stateProvider.state(loginState);
    $stateProvider.state(createUserState);
    $stateProvider.state(applicationState);

    //default routing
    $urlRouterProvider.otherwise('/');
    //$stateProvider.html5Mode(true);
});


// app.controller('homeCtrl',  function($scope, $state) {
//     $scope.state = $state;
// });

