app.component('employeeDetails', {
    templateUrl: '/js/components/employee-details/employee-details.component.html',
    controller: function ($scope, $controller) {
        
        
        $controller('DetailsController', {
            $scope: $scope,
        });
            $scope.init("employee");
    }
});