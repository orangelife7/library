app.directive ('task9', function() {
	return {
		restrict: 'E',
		templateUrl: '/js/directives/task9/task9.directive.html',
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
				
			scope.$watch('people.length', function(newVal, oldVal)  {
					
			if(newVal === oldVal) return;
			if(newVal < oldVal) {
				console.log('Usunieto osobe. Teraz liczba osob wynosi: ' + newVal);
			} 
			if (newVal === 0){
			console.log('Lista jest pusta.')
				}
			});
		}
	}	
});