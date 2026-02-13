app.controller('ListController', function($scope, HttpService, $interval, $rootScope, $uibModal, ModalService) {

	const vm = this;

	$scope.list = [];

	$scope.init = function(entityUrl) {
		$scope.entityUrl = entityUrl;
		$scope.entityName = entityUrl.replace(/-./g, s => s[1].toUpperCase());
		$scope.initList(`http://localhost:8080/api/${entityUrl}/list`);
	}

	$scope.initList = function(url) {
		$scope.load = function() {
			HttpService.get(url).then(function(response) {
				$scope.list = response;
			})
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
	
	$scope.form = {};
	
	$scope.createByForm = function() {
      HttpService.post(`/api/${$scope.entityUrl}/create`, $scope.form)
        .then(function() {
          $scope.$emit('DATA_CHANGED');

      
          $scope.form = {};
        });
    }; 
	
	$scope.createByModal = function() {
		let callback = function() {
			$scope.$emit('DATA_CHANGED');
		}
		ModalService.createByModal($scope.entityName, $scope.entityUrl, callback);
	}

});

