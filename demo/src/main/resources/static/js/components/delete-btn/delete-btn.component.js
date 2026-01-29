app.component('deleteBtn', {
    bindings: {
       entityUrl: '@',
       itemId: '<'
    },
    templateUrl: getComponentPath('delete-btn'),
	controller: function(HttpService, $scope) {
		
		this.delete = function() {
			let url = 'http://localhost:8080/api/' + this.entityUrl + '/' + this.itemId + '/delete';
			
			HttpService.post(url, {})
			.then(function() {
			     $scope.$emit('DATA_CHANGED');
			 })
		}
	}
});