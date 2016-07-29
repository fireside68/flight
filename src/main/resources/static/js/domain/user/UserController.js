angular.module('app').controller(
		'UserController',
		[
				'UserService',
				'LoginService',
				'$http',
				'$routeParams',
				'$window',
				'$scope',
				function(UserService, LoginService, $http, $routeParams,
						$window, $scope) {
					
					$scope.username = LoginService.username.username
					
					var name = LoginService.username.username
					
					UserService.lookupUsername(LoginService.username.username)
						.then(function (result) {
							UserService.user = result.data
							console.dir(UserService.user)
								})
								console.dir(UserService.user)
					
				this.updateUser = function(user){
						UserService.updateUser(user);
					}
					
				this.getItinerary = function(name){
					UserService.getItinerary(name)
				}
					


				} ])
