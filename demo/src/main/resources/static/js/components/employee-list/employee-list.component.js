app.component('employeeList', {
  templateUrl: getComponentPath('employee-list'),
  controller: function($scope, $controller, HttpService) {

    $controller('ListController', 
		{ 
			$scope: $scope 
		});
    $scope.init("employee");

   
    $scope.form = {};
     
	$scope.createEmployee = function() {
      HttpService.post('/api/employee/create', $scope.form)
        .then(function() {
          $scope.$emit('DATA_CHANGED');

      
          $scope.form = {};
        });
    };
  }
});