angular.module('app').component('orderList', {
	templateUrl: '/js/components/order-list/order-list.component.html',
	controller: function ($scope, $controller) {
		
		$controller('ListController', 
			{
				$scope: $scope,
			});
			
			$scope.init("order")
	}
});