app.component('authorList', {
  templateUrl: getComponentPath('author-list'),
  controller: function($scope, $controller, HttpService) {

    $controller('ListController', 
		{ 
			$scope: $scope 
		});
    $scope.init("author");
  }
});