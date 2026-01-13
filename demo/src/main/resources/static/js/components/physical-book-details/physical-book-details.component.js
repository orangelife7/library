app.component('physicalBookDetails', {
    templateUrl: '/js/components/physical-book-details/physical-book-details.component.html',
    controller: function($http, $routeParams, $interval) {
        const ctrl = this;

        ctrl.$onInit = function() {
            ctrl.load();
			
		$interval(function() {
			ctrl.load();
			 }, 5000);
        };
		
        ctrl.load = function() {
            $http.get('http://localhost:8080/api/physical-book/' + $routeParams.id)
                .then(function(response) {
                    ctrl.physicalBook = response.data;
                })
                .catch(function(error) {
                    console.error('Błąd:', error);
                });
        };
    }
});