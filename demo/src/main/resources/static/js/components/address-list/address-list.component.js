app.component('addressList', {
  templateUrl: getComponentPath('address-list'),
  controller: function($scope, $controller, HttpService) {

    $controller('ListController', 
		{ 
			$scope: $scope 
		});
    $scope.init("address");
  }
});