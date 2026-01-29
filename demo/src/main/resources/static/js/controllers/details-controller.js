app.controller('DetailsController', function ($scope, $http, $interval, $routeParams, $rootScope) {

	const vm = this;
	
    $scope.init = function (entityUrl) {
        $scope.initDetails(`http://localhost:8080/api/${entityUrl}/${$routeParams.id}`);
    };

    $scope.initDetails = function (url) {
        $scope.load = function () {
            $http.get(url)
               .then(function (response) {
                  $scope.item = response.data;
           }).catch(function (error) {
			console.error('Blad: ' + error)
			});
        };

        $scope.load();
        vm.interval = $interval($scope.load, $rootScope.INTERVAL_MS);
    };
	
	$scope.$on('UPLOAD_FIELDS', function() {
	    $scope.load();
	  });
	
	$scope.$on('$destroy', function() {
		if(vm.interval) {
			$interval.cancel(vm.interval);
		}
	});
});