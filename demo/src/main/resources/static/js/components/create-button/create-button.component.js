app.component('createButton', {
    bindings: {
        entityUrl: '@',
        label: '@'
    },
    templateUrl: getComponentPath('create-button'),
	controller: function(HttpService, $scope) {
		
		this.create = function() {
			let url = 'http://localhost:8080/api/' + this.entityUrl + '/create';
		
		HttpService.post(url, {})
		.then(function() {
			$scope.$emit('DATA_CHANGED')	;
			})
		};
	}
});