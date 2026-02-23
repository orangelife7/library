app.directive('sortHeader', function() {
  	return {
    	restrict: 'A',
   		scope: {
      		sortKey: '@sortHeader',
      		sort: '=',
      		onSort: '&'
    },
    link: function(scope, element) {
      element.css('cursor', 'pointer');

      function getPrimarySort() {
        const value = scope.sort;
        return Array.isArray(value) ? (value[0] || '') : (value || '');
      }

      function updateArrow() {
        const [field, direction] = getPrimarySort().split(',');
        const baseText = element.text().replace(/[▲▼]/g, '').trim();

        if (field === scope.sortKey)
          element.text(baseText + (direction === 'asc' ? ' ▲' : ' ▼'));
        else
          element.text(baseText);
      }

      element.on('click', function() {
        scope.$apply(function() {
          scope.onSort({ field: scope.sortKey });
        });
      });

      scope.$watch('sort', updateArrow, true);

      updateArrow();
    }
  };
});