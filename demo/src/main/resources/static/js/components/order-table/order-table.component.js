app.component('orderTable', {
	bindings: {
		list: '<',
		sort: '=',
		onSort: '&'
	},
	templateUrl: getComponentPath('order-table'),
});