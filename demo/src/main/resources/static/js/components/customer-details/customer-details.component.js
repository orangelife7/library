app.component('customerDetails', {
    templateUrl: '/js/components/customer-details/customer-details.component.html',
    controller: function ($scope, $controller) {
        
        
        $controller('DetailsController', {
            $scope: $scope,
        });
            $scope.init("customer");
    }
});