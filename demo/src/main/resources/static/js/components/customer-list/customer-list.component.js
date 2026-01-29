app.component('customerList', {
	templateUrl: getComponentPath('customer-list'),
	controller: function ($scope, $controller) {
		
		$controller('ListController', 
			{
				$scope: $scope,
			});
			
			$scope.init("customer")
	}
});