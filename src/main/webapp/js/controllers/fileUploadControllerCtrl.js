
yotaTestApp.controller('fileUploadController', ['$scope', '$http', '$location', function($scope, $http, $location){

    var path = $location.absUrl();
    path = path.substring(0, path.indexOf("#"));

    $scope.uploadFile = function(files) {
        var formData = new FormData();
        formData.append("file", files[0]);

        $http.post(path + 'upload', formData, {
            withCredentials: true,
            headers: {
                "Content-Type": undefined
            },
            transformRequest: angular.identity
        }).success(function(data){
            $location.path("/");
        }).error(function(data){
            $location.path("/");
        });
    };

}]);
