angular.module('listonic')

    .controller('listsController', function ($scope, $localStorage, $http, ListsService) {
        $scope.content = "User Lists";
        $scope.inputs = {};

        $scope.settings = {
            listAdded: false
        };

        let update = () => {
            $http.get("/lists")
                .success((data) => {
                $scope.lists = data;
            });
        }
        update();

        $scope.$watch('settings.listAdded', function () {
           update();
           $scope.settings.listAdded = false;
        });

        $scope.lists = ListsService.getLists();
        $scope.addList = (list) => ListsService.addList(list);
    });