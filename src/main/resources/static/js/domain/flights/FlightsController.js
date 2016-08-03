angular.module('app')
		.controller(
				'FlightsController',
				[
						'FlightsService',
						'LoginService',
						'factory',
						'$scope',
						'$http',
						'$interval',
						'$routeParams',
						function(FlightsService, LoginService, factory, $scope, $http, $interval,
								$routeParams) {
							
							$scope.flights = factory.data
							//var flights = $scope.flights
							

							//$scope.$FlightsService = FlightsService
							this.getFlights = function() {
								$interval(function(){
								FlightsService.getFlights().then(
										function(result) {
											flightList = result.data
											$scope.flights = result.data
											
											 })
										}, 10000)
							}

							this.getFlights()
							
							$scope.getFlight = function(flight) {
								console.dir(flight)
								$location.path('#/flights/' + flight)
							}

						} ])