
yotaTestApp.controller('fileUploadController', ['$scope', '$http', '$location', function($scope, $http, $location){

    $scope.uploadFile = function(files) {
        var formData = new FormData();
        formData.append("file", files[0]);

        $http.post('/upload', formData, {
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
