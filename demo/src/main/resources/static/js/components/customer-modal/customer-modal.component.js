app.component('customerModal', {
	bindings: {
		resolve: '<',
	close: '&'	
	 },
	 templateUrl: getComponentPath('customer-modal'),
	 controller: function(HttpService, $controller, $scope) {
		const vm = this;
		
		$controller('ListController', 
				{ 
					$scope: $scope 
				});
				
		    $scope.init("customer");
		
			vm.selectedCustomerId = null;

			vm.selectExisting = function() {
			    vm.resolve.select(vm.selectedCustomerId);
		};
	}
});