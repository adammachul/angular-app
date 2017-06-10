angular.module('onlinePharmacy')

    .service('CartService', function ($rootScope, $localStorage, AuthenticationService) {

        this.addToCart = (drug) => {
            let username = AuthenticationService.getUser().username;
            if (!$localStorage[username]) {
                $localStorage[username] = {
                    cart: []
                };
            }
            let drugs = $localStorage[username].cart.filter((product) => product.id === drug.id);
            if (drugs.length) {
                drugs[0].quantity += 1;
            } else {
                drug.quantity = 1;
                $localStorage[username].cart.push(drug)
            }

            $rootScope.cart = this.getTotalCost();
        }

        this.getCartProducts = () => {
            let user = AuthenticationService.getUser();
            if (user && user.username) {
                let username = user.username;
                if ($localStorage[username] && $localStorage[username].cart) {
                    return $localStorage[username].cart;
                }
            };
        }

        this.getTotalCost = () => {
            let drugs = this.getCartProducts();
            if (drugs) {
                let totalCost = 0;
                drugs.forEach((prod) => totalCost += prod.price * prod.quantity);
                return Math.round(totalCost * 100) / 100;
            }
        }

    });