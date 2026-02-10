app.component('addressList', {
  templateUrl: getComponentPath('address-list'),
  controller: function($scope, $controller, HttpService) {

    $controller('ListController', 
		{ 
			$scope: $scope 
		});
    $scope.init("address");

   
    $scope.form = {};
     
	$scope.createAddress = function() {
      HttpService.post('/api/address/create', $scope.form)
        .then(function() {
          $scope.$emit('DATA_CHANGED');

      
          $scope.form = {};
        });
    };
  }
});