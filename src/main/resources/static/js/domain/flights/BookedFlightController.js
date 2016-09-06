angular.module('app').controller(
		'BookedFlightController',
		[
				'FlightsService',
				'UserService',
				'MapService',
				'$routeParams',
				'$http',
				'$scope',
				function(FlightsService, UserService, MapService, $routeParams, $http,
						$scope) {

					var ctrl = this
			
					ctrl.bookedFlight = JSON.parse($routeParams.flight)
					
					
//					$scope.reserveFlight = function(bookedFlight){
//						var itinerary = {
//						"trip": bookedFlight,
//						"userId": UserService.user.id
//						}
//
//						FlightsService.updateItinerary(itinerary).then(function(result){
//							ctrl.response = result.data
//							console.dir(result.data)
//						})
//					}

					var map = new google.maps.Map(document
							.getElementById('map'), {
						zoom : 6,
						center : {
							lat : 27.6648,
							lng : -81.5158
						}
					});



				} ])
