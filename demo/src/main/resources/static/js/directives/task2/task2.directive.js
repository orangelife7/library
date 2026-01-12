app.directive('task2', function() {
	return {
		restrict: 'E',
		templateUrl: '/js/directives/task2/task2.directive.html',
		link: function(scope) {
			scope.username = "";
		}
	}
});
