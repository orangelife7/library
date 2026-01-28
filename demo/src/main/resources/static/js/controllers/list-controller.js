app.controller('ListController', function($scope, $http, $interval) {

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

	$scope.create = function() {
		$http.post(`http://localhost:8080/api/${$scope.entityUrl}/create`, {})
			.then(function() {
				$scope.load();
			});
		}
		
	$scope.delete = function(id) {
		$http.post(`http://localhost:8080/api/${$scope.entityUrl}/${id}/delete`, {})
			.then(function() {
				$scope.load();
		});
	}
		
		
		$scope.load();
		vm.interval = $interval($scope.load, 60000);
	};
	
	$scope.$on('UPLOAD_FIELDS', function() {
	      $scope.load();
	  });

	$scope.$on('$destroy', function() {
		if (vm.interval) {
			$interval.cancel(vm.interval);
		}
	});

});