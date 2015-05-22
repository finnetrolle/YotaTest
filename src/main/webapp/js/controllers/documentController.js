/**
 * Created by finnetrolle on 22.05.2015.
 */


yotaTestApp.controller('documentController', ['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams, $location){

    $scope.id = $routeParams.id;

    $scope.document = null;

    var path = $location.absUrl();
    path = path.substring(0, path.indexOf("#"));
    $scope.path = path;

    $http.get(path + 'document/' + $scope.id)
        .success(function(data){
            $scope.document = data;
        }).error(function(data){
            $scope.document = null;
        });

    $scope.download = function() {
        $http.get(path + 'download/' + $scope.id);
    }

}]);
