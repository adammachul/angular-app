angular.module('listonic')

    .service('ListsService', function ($rootScope, $localStorage, AuthenticationService) {

        this.addList = (list) => {
            let username = AuthenticationService.getUser().username;
            if(!localStorage[username]) {
                $localStorage[username] = {
                    lists: []
                };
            }
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