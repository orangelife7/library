app.component('commonModal', {
	bindings: {
		entityLabel: '@',
		onClose: '&'
	},
		transclude: true,
		templateUrl: getComponentPath('common-modal')
});