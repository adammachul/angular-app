let onlinePharmacy = angular.module('onlinePharmacy', ['ngRoute', 'ngResource', 'ui.bootstrap', 'ngStorage']);

onlinePharmacy.config(function ($routeProvider) {
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
        .when('/administration', {
            templateUrl: 'js/administration/administration.html',
            controller: 'administrationController'
        })
        .otherwise('/error.html');
});
