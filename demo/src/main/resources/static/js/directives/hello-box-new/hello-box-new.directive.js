//Zadanie 11
app.directive('helloBoxNew', function() {
	return {
		restrict: 'E',
		scope: {user: '<'},
		templateUrl: '/js/directives/hello-box-new/hello-box-new.directive.html'
	};
});