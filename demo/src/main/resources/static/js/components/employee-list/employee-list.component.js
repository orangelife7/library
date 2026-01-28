app.component('employeeList', {
	templateUrl: '/js/components/employee-list/employee-list.component.html',
	controller: function ($scope, $controller) {
		
		$controller('ListController', 
			{
				$scope: $scope,
			});
			
			$scope.init("employee")
	}
});