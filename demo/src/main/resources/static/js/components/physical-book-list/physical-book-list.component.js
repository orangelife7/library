app.component('physicalBookList', {
	templateUrl: getComponentPath('physical-book-list'),
	controller: function ($scope, $controller) {
		
		$controller('ListController', 
			{
				$scope: $scope,
			});
			
		$scope.init("physical-book")	
	}
});