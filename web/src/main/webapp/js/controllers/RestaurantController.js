

(function () {
    'use strict';

    angular
        .module('yummy')
        .controller('restaurantController', restaurantController);

    restaurantController.$inject = ['$scope', 'restaurantService','$state','$mdDialog','$rootScope','$mdToast'];

    function restaurantController($scope , restaurantService,$state ,$mdDialog,$rootScope,$mdToast) {


        $scope.imagePath = 'images/hotel1.jpg';

            restaurantService.getAllRestaurants($scope.filters).then(function (data) {

                $scope.restuarentsAll = data ;

            });


        $scope.heroImage = {
            background: 'url(js/Lib/slider/images/dextop2.jpg)'
        };



        var last = {
            bottom: false,
            top: true,
            left: false,
            right: true
        };

        $scope.toastPosition = angular.extend({}, last);

        $scope.getToastPosition = function () {
            sanitizePosition();

            return Object.keys($scope.toastPosition)
                .filter(function (pos) {
                    return $scope.toastPosition[pos];
                })
                .join(' ');
        };

        function sanitizePosition() {
            var current = $scope.toastPosition;

            if (current.bottom && last.top) current.top = false;
            if (current.top && last.bottom) current.bottom = false;
            if (current.right && last.left) current.left = false;
            if (current.left && last.right) current.right = false;

            last = angular.extend({}, current);
        }

        $scope.viewRestaurant = function (restaurant) {



            if (!($rootScope.loggedIn)) {

                $state.go('restaurant');

                var pinTo = $scope.getToastPosition();

                $mdToast.show(
                    $mdToast.simple()
                        .textContent('Please Signin!')
                        .position(pinTo)
                        .hideDelay(3000)
                );

            }else {

                $state.go('findus', {restaurant: restaurant});

            }

        };

        //start cutom dialog

        $scope.status = '  ';
        $scope.customFullscreen = false;
        $scope.showAdvanced = function(ev , restaurant) {




                // $state.go('dialog' , {restaurant22 : restaurant} );




           // $scope.restaurant = restaurant;

            // restaurantService.getAllRestaurants($scope.filters).then(function (data) {
            //
            //     $scope.restuarentsAll = data ;
            //
            // });

            $mdDialog.show({


                controller: DialogController,
                templateUrl: 'views/dialog1.tmpl.jsp',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:true,
                fullscreen: $scope.customFullscreen,
                locals: {
                    items: restaurant
                }
            })
                .then(function(answer) {
                    $scope.status = 'You said the information was "' + answer + '".';
                }, function() {
                    $scope.status = 'You cancelled the dialog.';
                });
        };

        //

         function DialogController($scope, $mdDialog , items , restaurantService  ) {




             restaurantService.getAllCommentsByRestaurant(items.Restaurant_ID).then(function success(data) {
                 $scope.comments =  data;



             });




                 // data[0].CommentData



            $scope.hide = function() {
                $mdDialog.hide();
            };

            $scope.cancel = function() {
                $mdDialog.cancel();
            };

            $scope.answer = function(answer) {
                $mdDialog.hide(answer);
            };
        }
        //end cutom dialog


    }


})();



