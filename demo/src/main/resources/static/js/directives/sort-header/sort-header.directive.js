app.directive('sortHeader', function() {
  return {
    restrict: 'A',
    scope: { sortHeader: '@' },
    link: function(scope, element) {

      let arrow = angular.element('<span></span>');
	  arrow.css('cursor', 'pointer');
	  
	  // znacznik kolejności
	  let orderMarker = angular.element('<span> X</span>');
	  element.append(orderMarker);
	  
	  element.append(arrow);
	  let clearButton = angular.element('<span> X</span>');
	  
	  clearButton.css('cursor', 'pointer');
	  element.append(clearButton);

      element.on('click', function() {
        scope.$emit('sortHeaderClicked', scope.sortHeader);
      });
	
	  
	  clearButton.on('click', function(event) {
		event.stopPropagation();
		scope.$emit('sortClearClicked', scope.sortHeader);
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
		  let direction = String(active[index]).split(',')[1];

		  arrow.text(direction === 'asc' ? ' ▲' : ' ▼');
		  orderMarker.text(' [' + (index + 1) + ']');
				  
		    clearButton.show();
		   } else {
		    arrow.text('');
			orderMarker.text('');
		    clearButton.hide();
		   }  
		});

		clearButton.hide();
	 }
  };
});