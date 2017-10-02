/**
 * Created by chinthaka on 9/29/17.
 */
(function () {
    'use strict';

    angular
        .module('yummy')
        .factory('findusService', findusService)
        .config(function ($mdThemingProvider) {
            $mdThemingProvider.theme('dark-grey').backgroundPalette('grey').dark();
            $mdThemingProvider.theme('dark-orange').backgroundPalette('orange').dark();
            $mdThemingProvider.theme('dark-purple').backgroundPalette('deep-purple').dark();
            $mdThemingProvider.theme('dark-blue').backgroundPalette('blue').dark();
        });

    findusService.$inject = ['$http'];

    function findusService($http) {

        var webApi = "http://localhost:8080/ordertracking/";


        var service = {
            getRestaurantsByFoodAndCity: getRestaurantsByFoodAndCity,
            getRestaurantsByName: getRestaurantsByName,
            getRestaurantsByLocation: getRestaurantsByLocation,
            getAllFood_Items: getAllFood_Items,

        };

        return service;


        function getRestaurantsByFoodAndCity(filters) {
            return $http.get(webApi + 'foodservice/foodWise?fo=' + filters.foodName + '&ci=' + filters.location).then(handleSuccess, handleError('Error getting drivers'));
        }

        function getRestaurantsByName(filters) {
            return $http.get(webApi + 'foodservice/restaurantWise?res=' + filters.restaurantName).then(handleSuccess, handleError('Error getting single driver'));
        }

        function getRestaurantsByLocation(filters) {
            return $http.get(webApi + 'foodservice/locationWise?loc=' + filters.nearestCity).then(handleSuccess, handleError('Error getting single driver'));
        }

        function getAllFood_Items(filters) {
            return $http.post(webApi + 'restaurant/food_items?rid=' + filters.Restuarant_ID).then(handleSuccess, handleError('Error getting single driver'));
        }


        function name1(filters) {
            return $http.get(webApi + 'api/drivers?id=' + driver.id).then(handleSuccess, handleError('Error getting single driver'));
        }

        function name2(filters) {
            return $http.get(webApi + 'api/drivers?id=' + driver.id).then(handleSuccess, handleError('Error getting single driver'));
        }


        // UNDONE: Duplicate method on all services
        function handleSuccess(res) {
            return res.data;
        }

        function handleError(error) {
            return function () {
                return {success: false, message: error};
            };
        }
    }


})();

