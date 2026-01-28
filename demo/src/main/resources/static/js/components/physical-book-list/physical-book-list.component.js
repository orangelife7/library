app.component('physicalBookList', {
	templateUrl: '/js/components/physical-book-list/physical-book-list.component.html',
	controller: function ($scope, $controller) {
		
		$controller('ListController', 
			{
				$scope: $scope,
			});
			
		$scope.init("physical-book")	
	}
});