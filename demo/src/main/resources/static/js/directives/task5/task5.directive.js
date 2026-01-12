app.directive('task5', function() {
	return {
		restrict: 'E',
		templateUrl: '/js/directives/task5/task5.directive.html',
		link: function(scope) {
			scope.isBlocked = false;
		}
	}
});