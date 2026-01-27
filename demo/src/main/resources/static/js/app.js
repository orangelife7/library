var app = angular.module('app', ['ngRoute']);


app.run(function($rootScope, $http) {
	$rootScope.fieldConfig = {};
	
	$http.get('/field-configuration')
		.then(function(response) {
			console.log(response);
			$rootScope.fieldConfig = response.data || {};
		}, function() {
			$rootScope.fieldConfig = {};
		});
});


app.controller('HelloController', function($scope, $http) {
	
});