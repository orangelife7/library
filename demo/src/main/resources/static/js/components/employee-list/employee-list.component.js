app.component('employeeList', {
	templateUrl: '/js/components/employee-list/employee-list.component.html',
	controller: function($http, $interval) {
		const ctrl = this;
		
		ctrl.$onInit = function() {
			ctrl.load();
			
			
		$interval(function() {
			ctrl.load();
		}, 5000);
	}
		
		ctrl.load = function() {
			$http.get('http://localhost:8080/api/employee/list')
			.then(function(response) {
				console.log(response.data);
				ctrl.employees = response.data;
			})
			.catch(function(error) {
				console.error('Błąd:' + error);
			})
		};
	}
	
});