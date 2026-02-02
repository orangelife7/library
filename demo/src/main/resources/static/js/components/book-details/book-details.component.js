app.component('bookDetails', {
  templateUrl: getComponentPath('book-details'),
  controller: function ($scope, $controller, HttpService) {

    $controller('DetailsController', { $scope: $scope });
    $scope.init("book");

    $scope.addPhysicalBook = function () {
      HttpService.post('/api/physical-book/create', {
        book: { id: $scope.item.id },
		catalogNumber: $scope.newCatalogNumber
      }).then(function () {
		$scope.newCatalogNumber = '';
        $scope.$emit('DATA_CHANGED');
      });
    };
  }
});