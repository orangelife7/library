app.directive('task7', function(){
	return{
		restrict: 'E',
		templateUrl: '/js/directives/task7/task7.directive.html',
		link: function(scope){
			scope.activationCount = 0;
			scope.deactivationCount = 0;
				
			scope.activate = function() {
				scope.isActive = true;
				scope.activationCount++;
			};
				
			scope.deactivate = function() {
				scope.isActive = false;
				scope.deactivationCount++;
			};
		}
	}	
});