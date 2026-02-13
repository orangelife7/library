app.component('employeeModal', {
	bindings: {
		resolve: '<',
	close: '&'	
	 },
	 templateUrl: getComponentPath('employee-modal'),
	 controller: function(HttpService, $controller, $scope) {
	 		const vm = this;
	 		
	 		$controller('ListController', 
	 				{ 
	 					$scope: $scope 
	 				});
	 				
	 		    $scope.init("employee");
	 		
	 			vm.selectedEmployeeId = null;

	 			vm.selectExisting = function() {
	 			    vm.resolve.select(vm.selectedEmployeeId);
	 		};
	 	}
});