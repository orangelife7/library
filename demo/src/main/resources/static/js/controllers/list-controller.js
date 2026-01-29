app.controller('ListController', function($scope, $http, $interval, $rootScope) {

	const vm = this;

	$scope.list = [];

	$scope.init = function(entityUrl) {
		$scope.entityUrl = entityUrl;
		$scope.initList(`http://localhost:8080/api/${entityUrl}/list`);
	}

	$scope.initList = function(url) {
		$scope.load = function() {
			$http.get(url).then(function(response) {
				$scope.list = response.data;
			}).catch(function(error) {
				console.error('Blad: ' + error)
			});
		};
		
		
		$scope.load();
		vm.interval = $interval($scope.load, $rootScope.INTERVAL_MS);
	};
	
	$scope.$on('DATA_CHANGED', function() {
	      $scope.load();
	  });

	  
	$scope.$on('$destroy', function() {
		if (vm.interval) {
			$interval.cancel(vm.interval);
		}
	});

});