app.component('personData', {
	bindings: {item: '<', index: '<'},
	templateUrl: getComponentPath('person-data'),
	controller: function($scope) {
		const ctrl = this;
		
		
		//Emitowanie zdarzenia deleteRequest z indexem
		ctrl.remove = function() {
			$scope.$emit('deleteRequest', ctrl.index);
		};
		
		ctrl.save = function() {
			ctrl.item.saved=true;
			console.log("zapisano!");
		};
		
		ctrl.edit = function() {
			ctrl.item.saved=false;
			console.log("przywrócono do edycji!");
		};
		//Odebranie rozgłoszenia od rodzica
		$scope.$on('EDIT_ALL', function(event) {
			ctrl.edit();
			
		});
		
		$scope.$on('SAVE_ALL', function(event) {
			ctrl.save();
		});
		
		//Imie
		$scope.$watch(() => ctrl.item.name, function(newVal, oldVal) {
		    if (newVal === oldVal) return;

		    console.log(
		        'Zmiana wartości pola name osoby o indeksie ' +
		        ctrl.index +
		        '. Stara wartość: ' + oldVal +
		        '. Nowa wartość: ' + newVal
		    );
		});

		//Wiek
		$scope.$watch(() => ctrl.item.age, function(newVal, oldVal) {
			if (newVal === oldVal) return;
			
			console.log(
				'Zmiana wartości pola age osoby o indeksie ' +
				ctrl.index +
				'. Stara wartość: ' + oldVal +
				'. Nowa wartość: ' + newVal
			);
		});
		
		//Miasto
		$scope.$watch(() => ctrl.item.city, function(newVal, oldVal) {
			if (newVal === oldVal) return;
			
			console.log(
				'Zmiana wartości pola city osoby o indeksie ' +
				ctrl.index +
				'. Stara wartość: ' + oldVal +
				'. Nowa wartość: ' + newVal
			);
		});
	}
});



