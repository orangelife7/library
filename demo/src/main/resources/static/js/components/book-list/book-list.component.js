app.component('bookList', {
	templateUrl: '/js/components/book-list/book-list.component.html',
	controller: function($http, $interval) {
		const ctrl = this;
		
		ctrl.$onInit = function() {
			ctrl.load();
			
			$interval(function() {
                ctrl.load();
            }, 5000);
		}
		
		ctrl.load = function() {
			$http.get('http://localhost:8080/api/book/list')
			.then(function(response) {
				console.log(response.data);
				ctrl.books = response.data;
			})
			.catch(function(error) {
					console.error('Blad: ' + error);
				})
		};
		
	}
});