app.component('physicalBookDetails', {
    templateUrl: getComponentPath('physical-book-details'),
    controller: function ($scope, $controller) {
        
        
        $controller('DetailsController', {
            $scope: $scope,
        });
            $scope.init('physical-book');
    }
});