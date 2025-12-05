//Zadanie 10
app.directive('helloBox', function() {
		return {
			restrict: 'AE',
			scope: {username: '@'},
			templateUrl: '/js/directives/hello-box/hello-box.directive.html'
		};
			
	});