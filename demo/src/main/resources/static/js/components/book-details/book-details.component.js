app.component('bookDetails', {
    templateUrl: '/js/components/book-details/book-details.component.html',
    controller: function ($scope, $controller) {
        
        
        $controller('DetailsController', {
            $scope: $scope,
        });
            $scope.init("book");
    }
});