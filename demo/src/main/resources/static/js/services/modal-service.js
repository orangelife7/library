app.service('ModalService', function($uibModal, HttpService) {
	
	this.createByModal = function(entityName, entityUrl, callback) {
		
				let modalInstance = $uibModal.open({
				component: entityName + "Modal",
				resolve: {
				callback: function() {
					return function(form) {
						
						HttpService.post(`/api/${entityUrl}/create`, form)
							.then(function(id) {
								modalInstance.close();
								if(callback) {
									callback(id);
						}
									
					});
				};
						
			},
				
				select: function() {
							return function(id) {
								modalInstance.close();
								if(callback) {
									callback(id);
						}
					};
				}
			}
		});
		
	}
	
	
});



