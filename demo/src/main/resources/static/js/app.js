var app = angular.module('app', ['ngRoute', 'ui.bootstrap']);


app.run(function($rootScope, $http) {
	$rootScope.fieldConfig = {};
	
	$http.get('/field-configuration')
		.then(function(response) {
			$rootScope.fieldConfig = response.data;
		});
});

app.controller('HelloController', function($scope, $http) {
	
});