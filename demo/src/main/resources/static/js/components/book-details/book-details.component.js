app.component('bookDetails', {
    templateUrl: getComponentPath('book-details'),
    controller: function ($scope, $controller) {
        
        
        $controller('DetailsController', {
            $scope: $scope,
        });
            $scope.init("book");
    }
});