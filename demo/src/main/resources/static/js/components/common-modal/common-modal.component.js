app.component('commonModal', {
	bindings: {
		entityLabel: '@',
		onClose: '&',
		mode: '<'
	},
		transclude: {
			formSlot: '?formSlot',
			selectSlot: '?selectSlot'
		},
		templateUrl: getComponentPath('common-modal')
});