app.directive('task6', function(){
	return{
		restrict: 'E',
		templateUrl: '/js/directives/task6/task6.directive.html',
		link: function(scope){
			scope.counter = 0;
			scope.incrementCounter = function() {
			scope.counter++;
			};
		}
	}
});