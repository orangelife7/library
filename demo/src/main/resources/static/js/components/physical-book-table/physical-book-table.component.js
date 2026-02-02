app.component('physicalBookTable', {
	bindings: {
		list: '<',
		showTitle: '<',
		showAuthor: '<'
	},
	templateUrl: getComponentPath('physical-book-table'),
});