let listonic = angular.module('listonic', ['ngRoute', 'ngResource', 'ui.bootstrap', 'ngStorage']);

listonic.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'js/home/home.html',
            controller: 'homeController'
        })
        .when('/drugcatalog', {
            templateUrl: 'js/drugCatalog/drugCatalog.html',
            controller: 'drugCatalogController'
        })
        .when('/cart', {
            templateUrl: 'js/cart/cart.html',
            controller: 'cartController'
        })
        .when('/mylists', {
            templateUrl: 'js/lists/lists.html',
            controller: 'listsController'
        })
        .when('/administration', {
            templateUrl: 'js/administration/administration.html',
            controller: 'administrationController'
        })
        .otherwise('/error.html');
});
