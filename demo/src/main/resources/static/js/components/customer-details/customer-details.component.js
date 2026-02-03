app.component('customerDetails', {
    templateUrl: getComponentPath('customer-details'),
    controller: function ($scope, $controller) {
        
        
        $controller('DetailsController', {
            $scope: $scope,
        });
            $scope.init("customer");	
    }
});