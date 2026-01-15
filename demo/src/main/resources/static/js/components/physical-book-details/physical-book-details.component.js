app.component('physicalBookDetails', {
    templateUrl: '/js/components/physical-book-details/physical-book-details.component.html',
    controller: function ($scope, $controller) {
        
        
        $controller('DetailsController', {
            $scope: $scope,
        });
            $scope.init('physical-book');
    }
});