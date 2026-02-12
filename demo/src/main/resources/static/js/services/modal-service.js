app.service('ModalService', function($uibModal, HttpService, $rootScope) {
	
	this.createByModal = function(entityName, entityUrl, callback) {
		
				let modalInstance = $uibModal.open({
				component: entityName + "Modal",
				resolve: {
				callback: function() {
					return function(form) {
						
						HttpService.post(`/api/${entityUrl}/create`, form)
							.then(function(id) {
								$rootScope.$broadcast('DATA_CHANGED');
								modalInstance.close();
								if(callback) {
									callback(id);
								}	
							});
						}
				}}});
			
	}
	
	
});