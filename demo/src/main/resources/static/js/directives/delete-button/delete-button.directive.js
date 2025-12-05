//Zadanie 12
app.directive('deleteButton', function() {
	return {
		restrict: 'E',
		scope: {onDelete: '&'},
		templateUrl: '/js/directives/delete-button/delete-button.directive.html',
			link: function(scope) {	
				scope.delete2 = function() {
				scope.onDelete();
				alert("Usunieto!");			
			}	
		}
		
	};
});