app.component('bookList', {
	templateUrl: getComponentPath('book-list'),
	controller: function($scope, $controller) {
		
		$controller('ListController',
			{
				$scope: $scope,
			});
			
			$scope.init("book")
	}
});