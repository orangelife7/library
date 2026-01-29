app.component('employeeDetails', {
    templateUrl: getComponentPath('employee-details'),
    controller: function ($scope, $controller) {
        
        
        $controller('DetailsController', {
            $scope: $scope,
        });
            $scope.init("employee");
    }
});