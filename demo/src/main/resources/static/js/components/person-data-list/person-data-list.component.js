app.component('personDataList', {
	templateUrl: '/js/components/person-data-list/person-data-list.component.html',
	controller: function($scope) {
		const ctrl = this;
		
		ctrl.people = [
			{name: 'Karol', age: 31, city: 'Kraków', saved: false},
			{name: 'Janek', age: 38, city: 'Wroclaw', saved: false},
			{name: 'Kasia', age: 25, city: 'Warszawa', saved: false},
			{name: 'Miki', age: 30, city: 'Rzeszow', saved: false},
			{name: 'Zosia', age: 35, city: 'Poznan', saved: false}
		];
		
		ctrl.createPerson = function() {
			ctrl.people.push({});
		}
		
		//Odbieranie zdarzenia deleteRequest przez rodzica
		$scope.$on('deleteRequest', function(event, index) {
			console.log("Usunieto osobe o indexie: " + index);
			
			ctrl.people.splice(index, 1); //Usuniecie z listy
			});
			
			
		//Rozgłaszanie zdarzenia do potomka
		ctrl.editAll = function() {
			$scope.$broadcast('EDIT_ALL');
		}
		
		ctrl.saveAll = function() {
			$scope.$broadcast('SAVE_ALL');
		}
				
		}	
});