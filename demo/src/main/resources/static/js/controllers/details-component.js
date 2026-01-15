app.controller('DetailsController', function ($scope, $http, $interval, $routeParams) {

    $scope.init = function (entityUrl) {
        $scope.initDetails(`http://localhost:8080/api/${entityUrl}/${$routeParams.id}`);
    };

    $scope.initDetails = function (url) {
        $scope.load = function () {
            $http.get(url)
               .then(function (response) {
                  $scope.item = response.data;
           })
			.catch(function (error) {
			console.error('Blad: ' + error)
			});
        };

        $scope.load();
        $interval($scope.load, 5000);
    };
});