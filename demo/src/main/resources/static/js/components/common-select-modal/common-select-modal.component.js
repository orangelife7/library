app.component('commonSelectModal', {
	bindings: {
		entityLabel: '@',
		entityUrl: '@',
		resolve: '<'
	},
	transclude: true,
	templateUrl: getComponentPath('common-select-modal'),
	
	controller: function($controller, $scope) {
		const vm = this;
		
		vm.$onInit = function() {
			$controller('ListController', { $scope: $scope });
		 	$scope.init(vm.entityUrl);
			vm.selectedId = null;
					
			vm.selectExisting = function() {
				vm.resolve.select(vm.selectedId);
			};
		}
		
	}
});