app.component('bookDetails', {
  templateUrl: getComponentPath('book-details'),
  controller: function ($scope, $controller, HttpService, ModalService) {

    $controller('DetailsController', { $scope: $scope });
    $scope.init("book");

		$scope.createPhysicalBook = function() {	
			let callback = function(id) {
				return HttpService.post('/api/physical-book/' + id + '/update', {book: $scope.item.id})
				.then(function (){
					$scope.$emit('DATA_CHANGED');
				});
			};
			ModalService.createByModal('physicalBook', 'physical-book', callback, 'C');
		}
											 
	}
});