var app = angular.module('app', ['ngRoute', 'ui.bootstrap']);


app.run(function($rootScope, HttpService) {
	$rootScope.fieldConfig = {};
	
	$rootScope.INTERVAL_MS = 60000;
	
	HttpService.get('/field-configuration')
		.then(function(response) {
			$rootScope.fieldConfig = response;
		});
});

app.controller('HelloController', function($scope) {
	
});