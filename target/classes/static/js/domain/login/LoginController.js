angular
		.module('app')
		.controller(
				'LoginController',
				[
						'LoginService',
						'UserService',
						'$location',
						'$window',
						'$timeout',
						function(LoginService, UserService, $location, $window, $timeout) {

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
													var response = result.data;
													if (response.username === 'unregistered') {
														$location
																.path('/login/userNotFoundTemplate.html');
													} else if (response.username === 'invalid') {
														$location
																.path('/login/loginUnsuccessfulTemplate.html');
													} else {														
														LoginService
																.setLoggedIn(true)						
														LoginService
																.setUsername(response.username)
														UserService.setUser(response)
														console.dir(UserService.user)
														$location.path('/user')
													}
												});

							}
						} ])