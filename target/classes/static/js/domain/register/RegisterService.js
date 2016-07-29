angular.module('app').service('RegisterService', ['$http', '$timeout', function($http, $timeout) {
	
	var url = 'user/'
		
	this.user = {}
	
	this.addNewUser = function(user) { return $http.post(url + 'addNewUser'), user }
}])