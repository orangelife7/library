app.component('orderList', {
	templateUrl: getComponentPath('order-list'),
	controller: function ($scope, $controller) {
		
		$controller('ListController', 
			{
				$scope: $scope,
			});
			
			$scope.init("order")
	}
});