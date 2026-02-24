app.component('authorDetails', {
  templateUrl: getComponentPath('author-details'),
  controller: function ($scope, $controller, HttpService, ModalService) {

    $controller('DetailsController', { $scope: $scope });
    $scope.init("author");

		$scope.createBookForAuthor = function() {	
			let callback = function(bookId) {
				return HttpService.post('/api/book/' + bookId + '/update', {author: $scope.item.id})
				.then(function (){
					$scope.$emit('DATA_CHANGED');
				});
			};
			ModalService.createByModal('book', 'book', callback);
		}
											 
	}
});