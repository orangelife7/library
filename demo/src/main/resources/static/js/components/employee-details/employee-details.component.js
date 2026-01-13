app.component('employeeDetails', {
    templateUrl: '/js/components/employee-details/employee-details.component.html',
    controller: function($http, $routeParams, $interval) {
        const ctrl = this;

        ctrl.$onInit = function() {
            ctrl.load();
			
		$interval(function() {
			ctrl.load();
			 }, 5000);
        };
		
        ctrl.load = function() {
            $http.get('http://localhost:8080/api/employee/' + $routeParams.id)
                .then(function(response) {
                    ctrl.employee = response.data;
                })
                .catch(function(error) {
                    console.error('Błąd:', error);
                });
        };
    }
});