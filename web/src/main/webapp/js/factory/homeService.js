(function () {
    'use strict';

    angular
        .module('yummy')
        .factory('homeService', homeService);

    homeService.$inject = ['$http'];

    function homeService($http) {

        var webApi = "http://localhost:8080/ordertracking/";


        var service = {
            getRestaurantsByFoodAndCity: getRestaurantsByFoodAndCity,
            getRestaurantsByName: getRestaurantsByName,
            getRestaurantsByLocation: getRestaurantsByLocation,
            searchRestaurantsByName : searchRestaurantsByName
        };

        return service;


        function getRestaurantsByFoodAndCity(filters) {
            return $http.get(webApi + 'restaurant/foodWise?fo='+filters.foodName +'&ci='+filters.location).then(handleSuccess, handleError('Error getting drivers'));
        }

        function getRestaurantsByName(filters) {
            return $http.post(webApi + 'restaurant/restaurantwise?res='+filters.restaurantName).then(handleSuccess, handleError('Error getting single driver'));
        }

        function getRestaurantsByLocation(filters) {
            return $http.post(webApi + 'restaurant/locationwise?loc='+filters.nearestCity ).then(handleSuccess, handleError('Error getting single driver'));
        }


        function name1(filters) {
            return $http.get(webApi + 'api/drivers?id=' + driver.id).then(handleSuccess, handleError('Error getting single driver'));
        }
        function name2(filters) {
            return $http.get(webApi + 'api/drivers?id=' + driver.id).then(handleSuccess, handleError('Error getting single driver'));
        }

        function searchRestaurantsByName(name) {
            return $http.get(webApi + 'foodservice/checkSampleRestaurant?letter=' + name).then(handleSuccess, handleError('Error getting single driver'));
        }


        // UNDONE: Duplicate method on all services
        function handleSuccess(res) {
            return res.data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }





})();



