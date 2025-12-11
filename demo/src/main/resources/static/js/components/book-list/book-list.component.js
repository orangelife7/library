app.component('bookList', {
	templateUrl: '/js/components/book-list/book-list.component.html',
	controller: function($http) {
		const ctrl = this;
		
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