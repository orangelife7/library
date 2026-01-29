app.controller('DetailsController', function ($scope, HttpService, $interval, $routeParams, $rootScope) {

	const vm = this;
	
    $scope.init = function (entityUrl) {
        $scope.initDetails(`http://localhost:8080/api/${entityUrl}/${$routeParams.id}`);
    };

    $scope.initDetails = function (url) {
        $scope.load = function () {
            HttpService.get(url)
               .then(function (response) {
                  $scope.item = response;
           })
        };

        $scope.load();
        vm.interval = $interval($scope.load, $rootScope.INTERVAL_MS);
    };
	
	$scope.$on('DATA_CHANGED', function() {
	    $scope.load();
	  });
	
	$scope.$on('$destroy', function() {
		if(vm.interval) {
			$interval.cancel(vm.interval);
		}
	});
});