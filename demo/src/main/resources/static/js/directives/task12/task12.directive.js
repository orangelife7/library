app.directive('task12', function() {
	return {
		restrict: 'E',
		templateUrl: '/js/directives/task12/task12.directive.html',
		link: function(scope){
			scope.people = [
				{name: 'Ola', age: 31, city: 'Rzeszow'},
				{name: 'Joanna', age: 28, city: 'Wrocław'},
				{name: 'Karol', age: 30, city: 'Kraków'}
		];
			scope.remove = function(index) {
				if(confirm("Czy na pewno chcesz usunac tego uzytkownika?")){
				scope.people.splice(index, 1)
				}
			};
		}
	}	
});