app.directive('sortHeader', function() {
  return {
    restrict: 'A',
    scope: { sortHeader: '@' },
	templateUrl: '/js/directives/sort-header/sort-header.directive.html',
	transclude: true,
    link: function(scope, element) {


	  scope.clear = function(event) {
		event.stopPropagation();
		scope.$emit('sortClearClicked', scope.sortHeader);
	  }
	  
	  element.on('click', function() {
	        scope.$emit('sortHeaderClicked', scope.sortHeader);
	  });
	  
      scope.$on('sortChanged', function(event, sort) {
		sort = sort || [];
		let active = sort.filter(function(s) {
			return !String(s).startsWith('id,');
		});
		
		 let index = active.findIndex(function(s) {
		      return String(s).split(',')[0] === scope.sortHeader;
		 });

		 if (index >= 0) {
			scope.orderNumber = index + 1;
			scope.direction = String(active[index]).split(',')[1];
		 } else {
			scope.orderNumber = null;
			scope.direction = null;
		 }
		 	  
		     
		});

		
	 }
  };
});