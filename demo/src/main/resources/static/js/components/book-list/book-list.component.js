app.component('bookList', {
  templateUrl: getComponentPath('book-list'),
  controller: function($scope, $controller, HttpService) {

    $controller('ListController', 
		{ 
			$scope: $scope 
		});
		
		$scope.page = 0;
		$scope,size = 20;
		$scope.sort = 'id,asc';
		$scope.totalPages = 50;
		$scope.totalElements = 1000;
		
		$scope.onPageChange = function(page, size, sort) {
			console.log(page, size, sort);
			$scope.page = page;
			$scope.size = size;
			$scope.sort = sort;
		};
    $scope.init("book");
  }
});