let listonic = angular.module('listonic', ['ngRoute', 'ngResource', 'ui.bootstrap', 'ngStorage']);

listonic.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'js/home/home.html',
            controller: 'homeController'
        })
        .when('/mylists', {
            templateUrl: 'js/lists/lists.html',
            controller: 'listsController'
        })
        .when('/edit/:listId', {
            templateUrl: 'js/lists/listselement.html',
            controller: 'listsElementController'
        })
        .when('/administration', {
            templateUrl: 'js/administration/administration.html',
            controller: 'administrationController'
        })
        .otherwise('/error.html');
});
