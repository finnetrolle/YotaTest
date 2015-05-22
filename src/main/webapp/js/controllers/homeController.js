/**
 * Created by finnetrolle on 22.05.2015.
 */

yotaTestApp.controller('homeController', ['$scope', '$http', '$location', function ($scope, $http, $location) {

    $scope.documents = [];

    var path = $location.absUrl();
    path = path.substring(0, path.indexOf("#"));

    $http.get(path + 'document')
        .success(function (data) {
            $scope.documents = data;
        })
        .error(function (data) {
        });


}]);