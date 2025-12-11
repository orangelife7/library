app.directive('task8', function() {
	return {
		restrict: 'E',
		templateUrl: '/js/directives/task8/task8.directive.html',
		link: function(scope){
			scope.person = {name: 'Anna', age: 22, city: 'Rzeszow'};
		}
	}	
});