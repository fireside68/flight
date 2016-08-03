angular.module('app').service('UserService', ['$http', '$routeParams', function($http, $routeParams){
	
	var url = 'user/';
	var iUrl = 'itinerary/'
	
	this.user = {}
	this.listAllUsers = function() { return $http.get(url + 'listAllUsers/') }
	this.getUserById = function(id) { return $http.get(url + 'getUserById/' + id) }
	this.lookupEmail = function(email) { return $http.get(url + 'lookupEmail/' + email) }
	this.lookupUsername = function(username) { return $http.get(url + 'lookupUsername/' + username) }
	this.addNewUser = function(newUser) { return $http.post(url + 'addNewUser/', user) }
	this.updateUser = function(updateUser) { return $http.post(url + 'updateUser/', updateUser) }
	this.getItinerary = function(id) { return $http.get(url + 'getItinerary/' + id)}
	
	this.setUser = function(user) { this.user = user }
}])