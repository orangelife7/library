app.directive('task4', function(){
	return{
		restrict: 'E',
		templateUrl: '/js/directives/task4/task4.directive.html',
		link: function(scope) {
			scope.active = true;
		}
	} 
});