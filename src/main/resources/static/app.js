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

    var adminState = {
        name: 'admin',
        url: '/admin',
        templateUrl: 'templates/admin.html',
        controller: 'adminCtrl',
        controllerAs: 'admin'
    };

    var newClassState = {
        name: 'admin.newClass',
        url: '/newclass',
        templateUrl: 'templates/newclass.html',
        controller: 'newClassCtrl',
        controllerAs: 'newClass'
    };

    var addUserState = {
        name: 'admin.addUser',
        url: '/adduser',
        templateUrl: 'templates/adduser.html',
        controller: 'addUserCtrl',
        controllerAs: 'addUser'
    };

    var viewAppsState = {
        name: 'admin.viewApps',
        url: '/viewapps',
        templateUrl: 'templates/viewapps.html',
        controller: 'viewAppsCtrl',
        controllerAs: 'viewApps'
    };

    var buildIntState = {
        name: 'admin.buildInt',
        url: '/buildint',
        templateUrl: 'templates/buildint.html',
        controller: 'buildIntCtrl',
        controllerAs: 'buidInt'
    };

    var interviewState = {
        name: 'admin.interview',
        url: '/interview',
        templateUrl: 'templates/interview.html',
        controller: 'interviewCtrl',
        controllerAs: 'interview'
    };

    $stateProvider.state(homeState);
    $stateProvider.state(loginState);
    $stateProvider.state(createUserState);
    $stateProvider.state(applicationState);
    $stateProvider.state(adminState);
    $stateProvider.state(addUserState);
    $stateProvider.state(viewAppsState);
    $stateProvider.state(newClassState);
    $stateProvider.state(buildIntState);
    $stateProvider.state(interviewState);

    //default routing
    $urlRouterProvider.otherwise('/');
    //$stateProvider.html5Mode(true);
});

