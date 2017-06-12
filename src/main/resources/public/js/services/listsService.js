angular.module('listonic')

    .service('ListsService', function ($rootScope, $localStorage, $http, Path, AuthenticationService) {
        let self = this;

        this.settings = {
            listAdded: false
        };

        this.addList = (list) => {
            $http.post(Path.LISTS, list).success( (data) => {
               console.log("dodano liste");
               self.settings.listAdded = true;
            });
        }

        this.updateElements = (id, element) => {
            $http.put(Path.LISTS + id, element).success( (data) => {
               console.log("update elementow")
            });
        }

        this.addElement = (id,element) => {
            $http.post(Path.LISTS  + id, element).success( (data) => {
               console.log("dodano element");
            });
        }

        this.deleteElement = (path) => {
            $http.delete(Path.LISTS + path).success( (data) => {
               console.log("usunieto element");
            });
        }

        this.deleteList = (path) => {
            $http.delete(Path.LISTS + path).success( (data) => {
                console.log("usunieto liste");
            });
        }

        this.getLists = () => {
            let user = AuthenticationService.getUser();
            if (user && user.username) {
                let username = user.username;
                if($localStorage[username] && localStorage[username].lists) {
                    return $localStorage[username].lists;
                }
            }
        }

    })