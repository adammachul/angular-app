angular.module('listonic')

    .controller('listsController', function ($scope, $localStorage, $http, ListsService) {
        $scope.content = "User Lists";

        let update = () => {
            $http.get("/lists")
                .success((data) => {
                $scope.lists = data;
            });
        }
        update();

        $scope.addList = (list) => {
            ListsService.addList(list);
            update();
        };
    });