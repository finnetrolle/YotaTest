/**
 * Created by finnetrolle on 22.05.2015.
 */

var yotaTestApp = angular.module('yotaTestApp', ['ngRoute']);

yotaTestApp.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'views/home.html',
            controller: 'homeController'
        })
        .when('/upload', {
            templateUrl: 'views/upload.html',
            controller: 'fileUploadController'
        })
        .when('/document/:id', {
            templateUrl: 'views/document.html',
            controller: 'documentController'
        })
        .otherwise('/');

});