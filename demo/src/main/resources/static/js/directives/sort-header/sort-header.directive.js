app.directive('sortHeader', function() {
  return {
    restrict: 'A',
    scope: { sortHeader: '@' },
    link: function(scope, element) {

      let arrow = angular.element('<span></span>');
	  arrow.css('cursor', 'pointer');
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
		var entry = sort.find(function(s) {
			return String(s).split(',')[0] === scope.sortHeader;
		});
		
		
		var parts = (sort[0] || '').split(',');
		var fieldName = parts[0];
		var direction = parts[1];
			   
		if (entry) {
			var parts = String(entry).split(',');
			var direction = parts[1];
			
		    arrow.text(direction === 'asc' ? '▲' : '▼');
		    clearButton.show();
		   } else {
		    arrow.text('');
		    clearButton.hide();
		   }  
		});

		clearButton.hide();
	 }
  };
});