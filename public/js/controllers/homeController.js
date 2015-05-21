/**
 * Created by finnetrolle on 22.05.2015.
 */

yotaTestApp.controller('homeController', ['$scope', '$http', function ($scope, $http) {

    $scope.documents = [];

    $http.get('/document')
        .success(function (data) {
            $scope.documents = data;
        })
        .error(function (data) {
        });


}]);