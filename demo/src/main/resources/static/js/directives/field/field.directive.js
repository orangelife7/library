app.directive('field', function($http, $timeout) {
	
	let editing = false;
	
	return {
		restrict: 'E',
		scope: {
			entityName: '@',
			entity: '=',
			fieldName: '@',
			editable: '<'
		},
	templateUrl: '/js/directives/field/field.directive.html',
	link: function(scope, element) {
		console.log('field' + scope.entityName+scope.fieldName);
		scope.edit=false;
		
		function isEditable() {
		    return scope.editable != false; 
		 }
		
		scope.start = function() {
			if (editing) return;
			if (!isEditable()) return; 
			if(!scope.entity || !scope.entity.id) return; 
			editing = true;
			scope.old = scope.entity[scope.fieldName];
			scope.val = scope.old;
			scope.edit = true;
			$timeout(function(){ var i=element[0].querySelector('input'); if(i) i.focus(); }, 500);

			
		};
		
	
		scope.cancel = function() {
			scope.entity[scope.fieldName] = scope.old;
			scope.edit = false;
			editing = false;
		};
		
		scope.save = function() {
			if (!isEditable()) return;  
			let payload = {};
			payload[scope.fieldName] = scope.val;
		
			
			let entityPath = camelToKebabCase(scope.entityName);
			$http.post('/api/' + entityPath + '/' + scope.entity.id + '/update', payload)
			.then(function() {
				scope.edit = false;
				editing = false;
				scope.$emit('UPLOAD_FIELDS');
				
		
			console.log('Zapisano pole: "' + scope.fieldName + '" =', scope.val);
			}, function() {
				scope.entity[scope.fieldName] = scope.old;
				scope.edit = false;
				editing = false;
			});
		};
		
		function camelToKebabCase(str) {
		  return str
		    .replace(/([a-z0-9])([A-Z])/g, '$1-$2')
		    .toLowerCase();
		}
		
		scope.isEditable = isEditable;
		
		scope.key = function(e) {
			if(e.key === 'Enter') scope.save();
			if(e.key === 'Escape') scope.cancel();
		};
	  }
   };
});

