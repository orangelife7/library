app.directive('task11', function() {
	return {
		restrict: 'E',
		templateUrl: '/js/directives/task11/task11.directive.html',
		link: function(scope){
			scope.person = {name: 'Anna', age: 22, city: 'Rzeszow'};
		}
	}	
});