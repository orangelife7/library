app.component('addressDetails', {
    templateUrl: getComponentPath('address-details'),
    controller: function ($scope, $controller) {
        
        
        $controller('DetailsController', {
            $scope: $scope,
        });
            $scope.init("address");	
    }
});