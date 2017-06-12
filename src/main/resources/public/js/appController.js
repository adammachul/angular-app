angular.module('listonic')

.controller('appController', function ($rootScope, $scope, $http, AuthenticationService, UserService, Role) {
    $scope.credentials = {};
    // $scope.authenticated = true;
    // $scope.username = "adam";
    AuthenticationService.authenticate( () => {
        $scope.username = AuthenticationService.getUser().username;
    });
    $scope.login = () => {
        AuthenticationService.login($scope.credentials).then(() => {
            $scope.error = false;
            $scope.username = AuthenticationService.getUser().username;
        }, () => {
            $scope.error = true;
        })
    };
    $scope.logout = AuthenticationService.logout;

    $scope.hasAdminRole = () => AuthenticationService.hasRole(Role.ADMIN);
    $scope.isLogged = () => AuthenticationService.isLogged();
    $scope.register = (user) => UserService.register(user);

    $scope.verifyUsername = (username) => {
        let input = $("#newUsername")[0];
        UserService.verifyUsername(username).then(
            (result) => {
                if(result.data === 'true'){
                    input.setCustomValidity('Selected username already exists');
                }else {
                    input.setCustomValidity('');
                }
            }
        );
    }
    $scope.verifyEmail = (email) => {
        let input = $("#newEmail")[0];
        if(!email) {
            input.setCustomValidity('Please provide a valid email address');
            return;
        }
        UserService.verifyEmail(email).then(
            (result) => {
                if(result.data === 'true'){
                    input.setCustomValidity('Selected email already exists');
                }else {
                    input.setCustomValidity('');
                }
            }
        );
    }

});
