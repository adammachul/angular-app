angular.module('onlinePharmacy')

    .controller('cartController', function ($scope, $localStorage, CartService) {
        $scope.drugs = CartService.getCartProducts();
        $scope.getTotalCost = CartService.getTotalCost;
    });