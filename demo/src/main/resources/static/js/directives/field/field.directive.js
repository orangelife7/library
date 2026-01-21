app.directive('field', function($http) {
	return {
		restrict: 'E',
		scope: {
			entityName: '@',
			entity: '=',
			fieldName: '@',
			editable: '<'
		},
	templateUrl: '/js/directives/field/field.directive.html',
	link: function(scope) {
		console.log('field' + scope.entityName+scope.fieldName);
		scope.edit=false;
		
		function isEditable() {
		    return scope.editable != false; 
		 }
		
		scope.start = function() {
			if (!isEditable()) return; 
			if(!scope.entity || !scope.entity.id) return; 
			scope.old = scope.entity[scope.fieldName];
			scope.val = scope.old;
			scope.edit = true;
		};
		
		scope.cancel = function() {
			scope.entity[scope.fieldName] = scope.old;
			scope.edit = false;
		};
		
		scope.save = function() {
			if (!isEditable()) return;  
			let payload = {};
			payload[scope.fieldName] = scope.val;
		
			
			let entityPath = camelToKebabCase(scope.entityName);
			$http.post('/api/' + entityPath + '/' + scope.entity.id + '/update', payload)
			.then(function() {
				scope.entity[scope.fieldName] = scope.val;
				scope.edit = false;
				
				
				console.log('Zapisano pole: "' + scope.fieldName + '" =', scope.val);
				}, function() {
					scope.entity[scope.fieldName] = scope.old;
					scope.edit = false;
				});
		};
		
		function camelToKebabCase(str) {
		  return str
		    .replace(/([a-z0-9])([A-Z])/g, '$1-$2')
		    .toLowerCase();
		}
		
		scope.isEditable = isEditable;
	  }
   };
});

