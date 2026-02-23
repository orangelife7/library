app.directive('sortHeader', function() {
  return {
    restrict: 'A',
    scope: { sortHeader: '@' },
    link: function(scope, element) {

      let arrow = angular.element('<span></span>');
      element.append(arrow);

      element.on('click', function() {
        scope.$emit('sortHeaderClicked', scope.sortHeader);
      });

      scope.$on('sortChanged', function(event, sort) {
        let p = sort[0].split(',');
        if (p[0] === scope.sortHeader)
          arrow.text(p[1] === 'asc' ? '▲' : '▼');
        else
          arrow.text('');
      });

    }
  };
});