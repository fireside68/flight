angular
		.module('app')
		.controller(
				'LoginController',
				[
						'LoginService',
						'$location',
						'$window',
						'$timeout',
						function(LoginService, $location, $window, $timeout) {

							this.isLoggedIn = LoginService.isLoggedIn
							
							var ctrl = this
							
							this.login = function() {
								var login = {
									"username" : this.username,
									"password" : this.password
								}
								LoginService
										.loginUser(login)
										.then(
												function(result) {
													this.response = result.data;
													if (this.response.username === 'unregistered') {
														$location
																.path('/login/userNotFoundTemplate.html');
													} else if (this.response.username === 'invalid') {
														$location
																.path('/login/loginUnsuccessfulTemplate.html');
													} else {														
														LoginService
																.setLoggedIn(true)						
														LoginService
																.setUsername(this.response)
														$location.path('/user')
													}
												});

							}
						} ])