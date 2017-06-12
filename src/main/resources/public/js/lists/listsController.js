angular.module('listonic')

    .controller('listsController', function ($scope, $filter, $localStorage, $http, ListsService, AuthenticationService) {
        $scope.content = "User Lists";
        $scope.userData = AuthenticationService.getUser();

        let update = () => {
            $http.get("/lists")
                .success( (data) => {
                    $scope.lists = data;
                    $scope.filteredLists = $filter('filter')(data, {'user': AuthenticationService.getUser()});
                    $scope.filtered = data.content.filter( (users) => users.user.username == AuthenticationService.getUser().username );
                    console.log(AuthenticationService.getUser());
                    console.log("lista filtrowana: " + $scope.filteredLists);
            });
        }
        update();

        $scope.addList = (list) => {
            list.user = AuthenticationService.getUser();
            ListsService.addList(list);
            update();
        };

        $scope.deleteList = (listId) => {
            ListsService.deleteList("/" + listId);
            update();
        };
    });