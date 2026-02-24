app.component('commonSelectModal', {
	bindings: {
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
			vm.pick = function(id) {
				vm.resolve.select(id);
			};
			
		};
		
	}
});