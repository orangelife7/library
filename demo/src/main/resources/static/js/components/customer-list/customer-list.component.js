app.component('customerList', {
	templateUrl: '/js/components/customer-list/customer-list.component.html',
	controller: function($http, $interval) {
		const ctrl = this;
		
		ctrl.$onInit = function() {
			ctrl.load();
			
			
		$interval(function() {
			ctrl.load();
		}, 5000);
	}
		
	
		ctrl.load = function() {
			$http.get('http://localhost:8080/api/customer/list')
			.then(function(response) {
				console.log(response.data);
				ctrl.customers = response.data;
			})
			.catch(function(error) {
				console.error('Błąd:' + error);
			})
		};
	}
	
});