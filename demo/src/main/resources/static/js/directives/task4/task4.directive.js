app.directive('task4', function(){
	return{
		restict: 'E',
		templateUrl: '/js/directives/task4/task4.directive.html',
		link: function(scope) {
			scope.active = true;
		}
	} 
});