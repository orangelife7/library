app.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            template: '<dashboard />'
        })
		.when('/task1', {
		 	template: '<task1 />'
		})
		.when('/task2', {
			template: '<task2 />'
		})
		.when('/task3', {
			template: '<task3 />'
		})
		.when('/task4', {
			template: '<task4 />'
		}) 
		.when('/task5', {
			template: '<task5 />'
		})
		.when('/task6', {
			template: '<task6 />'
		})
		.when('/task7', {
			template: '<task7 />'
		})
		.when('/task8', {
			template: '<task8 />'
		})
		.when('/task9', {
			template: '<task9 />'
		})
		.when('/task10', {
			template: '<task10 />'
		})
		.when('/task11', {
			template: '<task11 />'
		})
		.when('/task12', {
			template: '<task12 />'
		})
		.when('/task13', {
			template: '<task13 />'
		})
		.when('/task14', {
			template: '<task14 />'
		})
		.when('/task15', {
			template: '<task15 />'
		})	
		.when('/book-list', {
			template: '<book-list />'
		})												 
        .otherwise({
            template: '<error/>'
        });
});