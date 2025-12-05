var app = angular.module('app', []);

app.controller('HelloController', function($scope, $http) {
	// Zadanie 1
	$scope.message = "Hello!";
	
	// Zadanie 2
	$scope.username = "";
	
	//Zadanie 3
	$scope.showPanel = false;
	
	//Zadanie 4
	$scope.Active = true;
	
	//Zadanie 5
	$scope.isBlocked = false;
	
	//Zadanie 6
	$scope.counter = 0;
	
	$scope.incrementCounter = function() {
		$scope.counter++;
	};
	
	//Zadanie 7
	$scope.activate = function(){
		$scope.isActive = true;
	};
	
	$scope.deactivate = function() {
	$scope.isActive = false;
	};
	
	
	$scope.activationCount = 0;
	$scope.deactivationCount = 0;
	
	$scope.activate = function() {
		$scope.isActive = true;
		$scope.activationCount++;
	};
	
	$scope.deactivate = function() {
			$scope.isActive = false;
			$scope.deactivationCount++;
		};
	
	//Zadanie 8
	$scope.person = {name: 'Anna', age: 22, city: 'Rzeszow'};
	
	 //Zadanie 9
	$scope.people = [
		{name: 'Ola', age: 31, city: 'Rzeszow'},
		{name: 'Joanna', age: 28, city: 'Wrocław'},
		{name: 'Karol', age: 30, city: 'Kraków'}
	]; 
	
	$scope.remove = function(index) {
		if(confirm("Czy na pewno chcesz usunac tego uzytkownika?")){
		$scope.people.splice(index, 1)
		}
	};
	
	$scope.$watch('people.length', function(newVal, oldVal)  {
		
		if(newVal === oldVal) return;
		if(newVal < oldVal) {
			console.log('Usunieto osobe. Teraz liczba osob wynosi: ' + newVal);
			} 
			if (newVal === 0){
				console.log('Lista jest pusta.')
			}
		});
	
	/* 
	$http.get('/api/hello').then(function(response) {
        $scope.message = response.data;
    });
	*/
	
	//
	
});

		
	
	
	
		
			
			
			
