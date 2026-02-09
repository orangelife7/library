app.component('addressList', {
	templateUrl: getComponentPath('address-list'),
	controller: function($scope, $controller) {
		
		$controller('ListController',
			{
				$scope: $scope,
			});
			
			$scope.init("address")
	}
});