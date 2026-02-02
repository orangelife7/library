app.service('HttpService', function($http, $q){
	
	function handleSuccess(response) {
		console.log('success')
		return response.data;
	}
	
	function handleError(error) {
		alert("Błąd backend!");
		console.error('HTTP ERROR:', error);
		return $q.reject(error);
	}
	
	function request(promise) {
		return promise
		.then(handleSuccess)
		.catch(handleError);
	}
	
	
	this.get = function(url, config) {
		return request($http.get(url, config));	
	};
	
	this.post = function(url, data, config) {
		return request($http.post(url, data, config));
	};
});
	
