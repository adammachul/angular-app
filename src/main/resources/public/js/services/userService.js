angular.module('onlinePharmacy')

.service('UserService', function ($http, Path) {

    this.register = (user) => {
        $http.post(Path.REGISTER, user).success( (data) => {
            $("#signUpModal").modal('hide');
        });
    }

    this.verifyUsername = (username) => {
        return $http.post(Path.UNIQUE_USERNAME, username)
    }

    this.verifyEmail = (email) => {
        return $http.post(Path.UNIQUE_EMAIL, email)
    }

});