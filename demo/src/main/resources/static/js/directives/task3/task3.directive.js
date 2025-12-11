app.directive('task3', function() {
	return {
		restrict: 'E',
		templateUrl: '/js/directives/task3/task3.directive.html',
		link: function(scope) {
			scope.showPanel = false;
		}
	}
});