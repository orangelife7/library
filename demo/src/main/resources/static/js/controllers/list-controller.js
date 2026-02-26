app.controller('ListController', function($scope, HttpService, $interval, $rootScope, $uibModal, ModalService) {

	const vm = this;

	$scope.list = [];
	$scope.page = 0;
	$scope.size = 5;
	$scope.sort = ['id,asc'];
	$scope.totalPages = 50;
	$scope.totalElements = 1000;

	$scope.onPageChange = function(page, size, sort) {
		console.log(page, size, sort);
		$scope.page = page;
		$scope.size = size;
		$scope.sort = sort;
		$scope.load();
	};

	$scope.init = function(entityUrl) {
		$scope.entityUrl = entityUrl;
		$scope.entityName = entityUrl.replace(/-./g, s => s[1].toUpperCase());
		$scope.initList(`http://localhost:8080/api/${entityUrl}/list`);
	}

	$scope.initList = function(url) {
		$scope.load = function() {
			const sortParam = (Array.isArray($scope.sort) ? $scope.sort : [$scope.sort]).map(String);
			 
			HttpService.get(url, {
			  params: { page: $scope.page, size: $scope.size, sort: sortParam }
			}).then(function(response) {
				console.log(response);
				$scope.list = response.content != null ? response.content : response;
				$scope.totalPages = response.totalPages != null ? response.totalPages : 0;
				$scope.totalElements = response.totalElements != null ? response.totalElements : ($scope.list ? $scope.list.length : 0);
			});
		};
		
		
		$scope.load();
		$scope.$broadcast('sortChanged', $scope.sort);
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
		ModalService.createByModal($scope.entityName, $scope.entityUrl, callback, 'C');
	}

	$scope.$on('sortHeaderClicked', function(event, field) {
		$scope.sortBy(field);	
	});
	
	$scope.$on('sortClearClicked', function(event, field) {
		const arr = (Array.isArray($scope.sort) ? $scope.sort : [$scope.sort]).filter(Boolean);
		const filtered = arr.filter(s =>
			!String(s).startsWith('id,') && String(s).split(',')[0] != field
		);
		$scope.sort = (filtered.length ? filtered : []).concat('id,asc');
		$scope.$broadcast('sortChanged', $scope.sort);
		$scope.onPageChange(0, $scope.size, $scope.sort);
	});
	
	$scope.sortBy = function(field) {
		
		const arr = (Array.isArray($scope.sort) ? $scope.sort : [$scope.sort]).filter(Boolean);
		const found = arr.find(s => s.split(',')[0] === field);
		const direction = (found && found.split(',')[1] === 'asc') ? 'desc' : 'asc';
		
		const rest = arr.filter (s =>
			!s.startsWith('id') && s.split(',')[0] != field
		);
		$scope.sort = rest.concat(field + ',' + direction, 'id,asc');
		$scope.$broadcast('sortChanged', $scope.sort);
		$scope.onPageChange(0, $scope.size, $scope.sort);
	}
	
});

