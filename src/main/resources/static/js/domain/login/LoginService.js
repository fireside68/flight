angular.module('app').service(
		'LoginService',
		[ '$http', '$routeParams', '$window',
				function($http, $routeParams, $window) {

					var url = 'user/loginUser'
					this.isLoggedIn = false
					this.username = {}
					this.loginUser = function(login) {
						return $http.post(url, login)
					};

					this.checkLogin = function() {
						return this.isLoggedIn
					}

					this.setLoggedIn = function(flag) {
						this.isLoggedIn = flag
					}
					
					this.setUsername = function(response){
						this.username = response
					}

				} ])