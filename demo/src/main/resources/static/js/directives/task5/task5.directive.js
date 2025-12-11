app.directive('task5', function() {
	return {
		restict: 'E',
		templateUrl: '/js/directives/task5/task5.directive.html',
		link: function(scope) {
			scope.isBlocked = false;
		}
	}
});