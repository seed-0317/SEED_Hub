/**
 * app.js
 *
 * DogModule configuration and routing
 *
 * @author Taylor Kemper
 */

var app = angular.module("DogModule", ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider) {

    var helloState = {
        name: 'home',
        url: '/',
        templateUrl: 'templates/home.html',
        controller: 'HomeCtrl',
        controllerAs: 'squirrel'
    };

    var aboutState = {
        name: 'about',
        url: '/about',
        templateUrl: 'templates/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'fox'
    };

    var loginState = {
        name: 'login',
        url: '/login',
        templateUrl: 'templates/login.html',
        controller: 'LoginCtrl',
        controllerAs: 'loginData'
    };


    $stateProvider.state(helloState);
    $stateProvider.state(aboutState);
    $stateProvider.state(loginState);

    //default routing
    $urlRouterProvider.otherwise('/');

});

