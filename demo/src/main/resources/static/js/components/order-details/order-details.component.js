app.component('orderDetails', {
    templateUrl: '/js/components/order-details/order-details.component.html',
    controller: function($http, $routeParams, $interval) {
        const ctrl = this;

        ctrl.$onInit = function() {
            ctrl.load();
			
		$interval(function() {
			ctrl.load();
			 }, 5000);
        };
		
        ctrl.load = function() {
            $http.get('http://localhost:8080/api/order/' + $routeParams.id)
                .then(function(response) {
                    ctrl.order = response.data;
                })
                .catch(function(error) {
                    console.error('Błąd:', error);
                });
        };
    }
});