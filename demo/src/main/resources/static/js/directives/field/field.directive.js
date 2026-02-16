app.directive('field', function(HttpService, $timeout, $rootScope, ModalService) {

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

			scope.INPUT_TYPES = ['text', 'localDateTime'];
			scope.SAVE_CANCEL_TYPES = ['text', 'localDateTime'];
			const DATE_TIME_FORMAT = 'YYYY-MM-DD HH:mm';
			
			scope.active = false;

			
			
			function setInputType() {
				if (scope.type === 'localDateTime') {
					scope.inputType = 'datetime-local';
				} else if (scope.type === 'boolean') {
					scope.inputType = 'checkbox';
				} else {
					scope.inputType = 'text';
				}
			}

			let fieldInfo = $rootScope.fieldConfig[scope.entityName][scope.fieldName];
			scope.type = fieldInfo.type;
			scope.nullable = fieldInfo.nullable;
			scope.targetEntityName = fieldInfo.entityName;
			setInputType();
			
			scope.isEditable = function() {
				return scope.editable != false;
			}
			

			scope.entityId = function() {
				return scope.entity[scope.fieldName]?.id || null;
			};

			scope.entityUrl = function() {
				return scope.fieldName;
			};

			
			scope.activate = function() {
				if ($rootScope.activeField && $rootScope.activeField !== scope) {
					$rootScope.activeField.active = false;
				}
				$rootScope.activeField = scope;
				scope.active = true;

				let currentVal = scope.entity[scope.fieldName];
				   if (isDate()) {
				   scope.val = parseToDate(currentVal);
				   } else {
				    scope.val = currentVal;
				   }

				   if (scope.isEditable()) {
				      $timeout(function() {
				      let i = element[0].querySelector('input');
				      if (i) i.focus();
				   }, 0);
				      }
				   };


			
				 scope.cancel = function() {
			        scope.active = false;
			      };

				  
			      scope.save = function() {
			        if (!scope.isEditable()) return;
					
			        let payload = {};
			        payload[scope.fieldName] = scope.val;

					if(scope.type === 'entity') {
						payload[scope.fieldName] = scope.val ? String(scope.val.id) : null;
					}
					
			        if (isDate()) {
			          payload[scope.fieldName] = scope.val
			            ? toLocalDateTimeString(scope.val)
			            : null;
			        }

					let entityPath = camelToKebabCase(scope.entityName);
			        HttpService.post('/api/' + entityPath + '/' + scope.entity.id + '/update', payload)
			          .then(function() {
			            scope.active = false;
			            scope.$emit('DATA_CHANGED');
			          }, function() {
			            scope.active = false;
			          });
			      };

	      scope.clear = function() {
			if (scope.type === 'entity' && !scope.nullable) return;
			if (scope.type !== 'entity' && !scope.isEditable()) return;
	        scope.val = scope.entity[scope.fieldName] = null;
	        scope.save();
	      };

		  scope.chooseEntity = function(mode) {
			console.log(mode)
			if(scope.type !== 'entity' || !scope.isEditable()) return;
			
			ModalService.createByModal(scope.targetEntityName, scope.targetEntityName, function(id) {
				let newEntity = {id: id};
				scope.val = newEntity;
				scope.entity[scope.fieldName] = newEntity;
				scope.save();
				
				},
				mode
			);
		  };
		  
		  
	      scope.chooseBoolean = function(value) {
	        scope.val = value;
	        scope.entity[scope.fieldName] = value;
	        scope.save();
	      };

	      scope.key = function(e) {
	        if (e.key === 'Enter') scope.save();
	        if (e.key === 'Escape') scope.cancel();
	      };

	      function isDate() {
	        return scope.type === 'localDateTime';
	      }

	      function camelToKebabCase(str) {
	        return str.replace(/([a-z0-9])([A-Z])/g, '$1-$2').toLowerCase();
	      }

	      function parseToDate(value) {
	        if (!value) {
	          return null;
	        }
	        const m = moment(value, DATE_TIME_FORMAT, true);
	        return m.isValid()
	          ? m.format('YYYY-MM-DD[T]HH:mm')
	          : null;
	      }

	      function toLocalDateTimeString(date) {
	        let momentDate = moment(date);
	        let formattedDate = momentDate.format(DATE_TIME_FORMAT);
	        return formattedDate;
	      }

	      scope.getValue = function() {
	        if (scope.entity == null) {
	          return "-";
	        }
	        let value = scope.entity[scope.fieldName];
	        if (value == null) {
	          return '-';
	        }
	        if (scope.type == 'boolean') {
	          return value ? 'TAK' : 'NIE';
	        }
	        if (scope.type == 'entity') {
	          return value.label;
	        }
	        return value;
	      };
	    }
	  };
	});