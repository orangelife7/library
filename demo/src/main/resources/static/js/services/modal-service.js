app.service('ModalService', function($uibModal, HttpService) {
	
	this.createByModal = function(entityName, entityUrl, callback, mode) {
		
				let modalInstance = $uibModal.open({
				component: entityName + "Modal",
				resolve: {
				
				mode: function() {
					return mode;
				},
				
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



