angular.module('app').service('RegisterService', ['$http', '$timeout', function($http, $timeout) {
	
	var url = 'user/addNewUser'
	
	this.addNewUser = function(user) { return $http.post(url, user) }
}])