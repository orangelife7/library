app.component('bookList', {
  templateUrl: getComponentPath('book-list'),
  controller: function($scope, $controller, HttpService) {

    $controller('ListController', 
		{ 
			$scope: $scope 
		});
    $scope.init("book");
  }
});