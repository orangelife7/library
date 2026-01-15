angular.module('app').component('customerList', {
	templateUrl: '/js/components/customer-list/customer-list.component.html',
	controller: function ($scope, $controller) {
		
		$controller('ListController', 
			{
				$scope: $scope,
			});
			
			$scope.init("customer")
	}
});