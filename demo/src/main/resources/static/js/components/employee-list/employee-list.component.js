app.component('employeeList', {
	templateUrl: getComponentPath('employee-list'),
	controller: function ($scope, $controller) {
		
		$controller('ListController', 
			{
				$scope: $scope,
			});
			
			$scope.init("employee")
	}
});