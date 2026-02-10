app.component('bookList', {
  templateUrl: getComponentPath('book-list'),
  controller: function($scope, $controller, HttpService) {

    $controller('ListController', 
		{ 
			$scope: $scope 
		});
    $scope.init("book");

   
    $scope.form = {};
     
	$scope.createBook = function() {
      HttpService.post('/api/book/create', $scope.form)
        .then(function() {
          $scope.$emit('DATA_CHANGED');

      
          $scope.form = {};
        });
    };
  }
});