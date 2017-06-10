angular.module('onlinePharmacy')


    .service('AuthenticationService', function ($rootScope, $http, $q, $location, Path) {
        let self = this;
        let user = undefined;
        let HEADER = {headers: {"content-type": "application/x-www-form-urlencoded"}}

        this.getUser = () => {
            return user;
        }

        this.hasRole = (role) => {
            return user && user.roles && user.roles.indexOf(role) !== -1;
        };

        this.isLogged = () => {
            return $rootScope.authenticated && !!user;
        }

        this.authenticate = (callback) =>
            $http.get(Path.USER)
                .success((data) => {
                    $rootScope.authenticated = !!data.username;
                    user = data;
                    callback && callback();
                })
                .error(() => {
                    $rootScope.authenticated = false;
                    callback && callback();
                });

        this.login = (credentials) => {
            let deferred = $q.defer();

            $http.post(Path.LOGIN, $.param(credentials), HEADER)
                .success((data) => {
                    self.authenticate(() => $rootScope.authenticated ? deferred.resolve() : deferred.reject());
                })
                .error((data) => {
                    $rootScope.authenticated = false;
                    deferred.reject();
                });

            return deferred.promise;
        };

        this.logout = () =>
            $http.post(Path.LOGOUT, {})
                .success(() => {
                    $rootScope.authenticated = false;
                    user = undefined;
                    $rootScope.cart = undefined;
                    navigateToHomePage();
                })
                .error(() => {
                    $rootScope.authenticated = false;
                    user = undefined;
                    navigateToHomePage();
                });

        navigateToHomePage = () => {
            $location.path("/");
            $(".nav").find(".active").removeClass("active");
            $("#home").addClass("active");
        }
    });
