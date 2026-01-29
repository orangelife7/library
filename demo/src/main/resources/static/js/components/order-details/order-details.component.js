app.component('orderDetails', {
    templateUrl: getComponentPath('order-details'),
    controller: function ($scope, $controller) {
        
        
        $controller('DetailsController', {
            $scope: $scope,
        });
            $scope.init("order");
    }
});