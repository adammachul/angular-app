angular.module('listonic')

.controller('drugCatalogController', function ($scope, $http, CartService) {
    $scope.content = "Drug Catalog";

    $scope.settings = {
        currentPage: 1,
        numPerPage: 15,
        maxSize: 5
    };

    let update = () => {
        $http.get("/drugs?page=" + $scope.settings.currentPage + "&size=" + $scope.settings.numPerPage)
            .success((data) => {
                $scope.drugs = data;
                $scope.numPages = function () {
                    return Math.ceil(data.totalElements / $scope.settings.numPerPage);
                };
            });
    };
    update();

    $scope.$watch('settings.currentPage + settings.numPerPage', function () {
        update();
    });

    $scope.addToCart = (drug) => CartService.addToCart(drug);

});
