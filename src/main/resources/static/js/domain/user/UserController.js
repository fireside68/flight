angular.module('app').controller(
		'UserController',
		[
				'UserService',
				'LoginService',
				'$http',
				'$rootScope',
				'$routeParams',
				'$location',
				'$scope',
				function(UserService, LoginService, $http, $rootScope, $routeParams,
						$location, $scope) {



					$scope.user = UserService.user
					var name = $scope.user.username
					$scope.newUser = {
						"id": UserService.user.id,
						"username": $scope.username,
						"password": $scope.password,
						"firstName": $scope.firstName,
						"lastName": $scope.lastName,
						"email": $scope.email
					}


					this.updateUser = function(user) {
						UserService.updateUser(user).then(function(){
							$location.path('/user')
						});
					}

					this.getItinerary = function(name) {
						UserService.getItinerary(name)
					}

				} ])
