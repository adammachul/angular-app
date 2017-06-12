angular.module('listonic')

    .controller('listsElementController', function ($scope, $localStorage, $routeParams, $http, ListsService) {
        $scope.content = "User List";
        console.log("route params " + $routeParams.listId);

        let update = () => {
            $http.get("/lists/" + $routeParams.listId)
                .success((data) => {
                $scope.onelist = data;
                $scope.elementsLength = data.elements.length.toString();
        }).then( (data) => {
        });
        }
        update();

        $scope.addElement = (element) => {
            ListsService.addElement("/" + $routeParams.listId, element);
            update();
        }

        $scope.updateElements = (input) => {
            $scope.onelist.elements.push(input.toString());
            ListsService.updateElements("/" + $routeParams.listId, $scope.onelist);
            update();
        }
    });