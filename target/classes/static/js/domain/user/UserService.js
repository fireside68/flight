angular.module('app').service('UserService', ['$http', '$routeParams', function($http, $routeParams){
	
	var url = 'user/';
	var iUrl = 'itinerary/'
	
	this.user = {}
	this.listAllUsers = function() { return $http.get(url + 'listAllUsers/') }
	this.lookupEmail = function(email) { return $http.get(url + 'lookupEmail/' + email) }
	this.lookupUsername = function(username) { return $http.get(url + 'lookupUsername/' + username) }
	this.addNewUser = function(newUser) { return $http.post(url + 'addNewUser/' + user) }
	this.updateUser = function(updateUser) { return $http.post(url + 'updateUser' + user) }
	this.getItinerary = function(username) { return $http.get(url + 'getItinerary' + username)}
}])