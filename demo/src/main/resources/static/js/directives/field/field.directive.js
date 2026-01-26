app.directive('field', function($http, $timeout) {

	let editing = false;
	let fieldTypeCache = {};
	
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

			function setInputType() {
				if (scope.type === 'localDateTime') {
					scope.inputType = 'datetime-local';
				} else if (scope.type === 'boolean') {
					scope.inputType = 'checkbox';
				} else {
					scope.inputType = 'text';
				} 
			}
		
			if (!scope.type) {
				scope.type = 'text';
			}
			

			scope.edit = false;

			scope.isEditable = function() {
				return scope.editable != false;
			}

			scope.start = function() {
				if (editing) {
					return;
				}
				if (!scope.isEditable()) {
					return;
				}
				if (!scope.entity || !scope.entity.id) {
					return;
				}
			
				let entityPath = camelToKebabCase(scope.entityName);
				$http.get('/api/' + entityPath + '/' + scope.fieldName + '/type')
					.then(function(res) {
					scope.type = res.data.data;
					setInputType();
				});

				editing = true;

				let currentVal = scope.entity[scope.fieldName];
				if (isDate()) {
					scope.val = parseToDate(currentVal);
				} else {
					scope.val = currentVal;
				}

				scope.edit = true;
				$timeout(function() { var i = element[0].querySelector('input'); if (i) i.focus(); }, 500);
			};

			scope.cancel = function() {
				scope.edit = false;
				editing = false;
			};

			scope.save = function() {
				if (!scope.isEditable()) return;
				let payload = {};
				payload[scope.fieldName] = scope.val;

				if (isDate()) {
					payload[scope.fieldName] = toLocalDateTimeString(scope.val);
				}

				let entityPath = camelToKebabCase(scope.entityName);
				$http.post('/api/' + entityPath + '/' + scope.entity.id + '/update', payload)
					.then(function() {
						scope.edit = false;
						editing = false;
						scope.$emit('UPLOAD_FIELDS');

					}, function() {
						scope.edit = false;
						editing = false;
					});
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

		}
	};
});