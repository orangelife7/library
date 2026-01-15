app.component('orderDetails', {
    templateUrl: '/js/components/order-details/order-details.component.html',
    controller: function ($scope, $controller) {
        
        
        $controller('DetailsController', {
            $scope: $scope,
        });
            $scope.init("order");
    }
});