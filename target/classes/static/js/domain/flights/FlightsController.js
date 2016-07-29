angular.module('app')
		.controller(
				'FlightsController',
				[
						'FlightsService',
						'LoginService',
						'$scope',
						'$http',
						'$interval',
						'$routeParams',
						function(FlightsService, LoginService, $scope, $http, $interval,
								$routeParams) {

							$scope.$FlightsService = FlightsService
							this.getFlights = function() {
								// $interval(function(){
								FlightsService.getFlights().then(
										function(result) {
											$scope.flights = result.data
											LoginService.flightList = result.data
											// }, 10000)
										})
							}

							this.getFlights()
							
							$scope.getFlight = function(flight) {
								console.dir(flight)
								$location.path('#/flights/' + flight)
							}

						} ])