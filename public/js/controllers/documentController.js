/**
 * Created by finnetrolle on 22.05.2015.
 */


yotaTestApp.controller('documentController', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams){

    $scope.id = $routeParams.id;

    $scope.document = null;

    $http.get('/document/' + $scope.id)
        .success(function(data){
            $scope.document = data;
        }).error(function(data){
            $scope.document = null;
        });

}]);
