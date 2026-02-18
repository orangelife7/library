app.component('paginator', {
	bindings: {
		page: '<',
		size: '<',
		sort: '<',
		totalPages: '<',
		totalElements: '<',
		onChange: '&'
	},
	templateUrl: getComponentPath('paginator'),
	controller: function() {
	
		let vm = this;
		vm.sizes = [10, 20, 50, 100];	
		
		vm.$onChanges = function() {
		  vm.p = vm.page != null ? vm.page : 0;
		  vm.s = vm.size || 20;
		  vm.tp = vm.totalPages || 0;
		  vm.te = vm.totalElements || 0;
		  vm.so = vm.sort || 'id,asc';
		  vm.pi = vm.p +1;
		};		
		
		vm.go = function(p, s, so) {
			if (so != null) vm.so = so;
			if (s != null) vm.s = s, p = 0; 
			p = (p == null) ? ((parseInt(vm.pi, 10) || 1) - 1) : p;
			p = vm.tp ? Math.max(0, Math.min(p, vm.tp - 1)) : 0;
			vm.p = p; vm.pi = p +1;
			vm.onChange({ page: p, size: vm.s, sort: vm.so });
		};
	}
	
});