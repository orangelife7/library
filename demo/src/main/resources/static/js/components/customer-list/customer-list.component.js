app.component('customerList', {
  templateUrl: getComponentPath('customer-list'),
  controller: function($scope, $controller, HttpService) {

    $controller('ListController', 
		{ 
			$scope: $scope 
		});
    $scope.init("customer");

   
    $scope.form = {};
     
	$scope.createCustomer = function() {
      HttpService.post('/api/customer/create', $scope.form)
        .then(function() {
          $scope.$emit('DATA_CHANGED');

      
          $scope.form = {};
        });
    };
  }
});