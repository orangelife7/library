var app = angular.module('app', []);

app.controller('HelloController', function($scope, $http) {
	
	$scope.message = "Hello!";
	
	/* 
	$http.get('/api/hello').then(function(response) {
        $scope.message = response.data;
    });
	*/
});
