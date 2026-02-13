app.component('bookModal', {
	bindings: {
		resolve: '<',
	close: '&'	
	 },
	 templateUrl: getComponentPath('book-modal'),
});