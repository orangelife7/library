app.component('bookModal', {
	bindings: {
		resolve: '<',
	close: '&'	
	 },
	 templateUrl: getComponentPath('book-modal'),
	 controller: function(HttpService, $controller, $scope) {
	 		const vm = this;
	 		
	 		$controller('ListController', 
	 				{ 
	 					$scope: $scope 
	 				});
	 				
	 		    $scope.init("book");
	 		
	 			vm.selectedBookId = null;

	 			vm.selectExisting = function() {
	 			    vm.resolve.select(vm.selectedBookId);
	 		};
	 	}
});