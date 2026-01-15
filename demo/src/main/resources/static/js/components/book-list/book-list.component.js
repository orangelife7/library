app.component('bookList', {
	templateUrl: '/js/components/book-list/book-list.component.html',
	controller: function($scope, $controller) {
		
		$controller('ListController',
			{
				$scope: $scope,
			});
			
			$scope.init("book")
	}
});