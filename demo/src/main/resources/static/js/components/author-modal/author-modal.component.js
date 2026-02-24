app.component('authorModal', {
	bindings: {
		resolve: '<',
	close: '&'	
	 },
	 templateUrl: getComponentPath('author-modal'),
});