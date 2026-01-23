app.directive('field', function($http, $timeout) {
	
	let editing = false;
	
	return {
		restrict: 'E',
		scope: {
			entityName: '@',
			entity: '=',
			fieldName: '@',
			editable: '<',
			type: '@?'
		},
	templateUrl: '/js/directives/field/field.directive.html',
	link: function(scope, element) {
		
		if(!scope.type) {
			scope.type = 'text';
		}
		scope.edit=false;
		
		function isEditable() {
		    return scope.editable != false; 
		 }
		
		 
	/*	function toDateTimeLocal(value) {
		      return ('' + value).slice(0, 16); 
		  }

		 function fromDateTimeLocal(value) {
		      return value; 
		  }
	*/	 
		 
		scope.start = function() {
			if (editing) return;
			if (!isEditable()) return; 
			if(!scope.entity || !scope.entity.id) return; 
			editing = true;
			scope.old = scope.entity[scope.fieldName];
			scope.val = scope.old;
			
			
	/*		if (scope.type === 'localDateTime') {
			       scope.val = toDateTimeLocal(scope.old);
			 }
	*/				
					
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
		
				
	/*		
			if (scope.type === 'localDateTime') {
			        payload[scope.fieldName] = fromDateTimeLocal(scope.val);
			 }
	*/		
				   		   
			
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
		
		scope.chooseBoolean = function(value) {
		      scope.val = value;  
			  scope.entity[scope.fieldName] = value; 
		      scope.save();        
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

