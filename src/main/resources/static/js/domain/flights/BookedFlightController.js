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
					ctrl.locations = {}


					ctrl.bookedFlight = JSON.parse($routeParams.flight)
					ctrl.pointA = ctrl.bookedFlight.origin.toLowerCase()
					ctrl.pointB = ctrl.bookedFlight.destination.toLowerCase()
					ctrl.itinerary = FlightsService.getFlightPath(ctrl.pointA, ctrl.pointB).then(function(result){
						ctrl.flightPath = result.data
						console.dir(ctrl.flightPath)
						console.dir(UserService.user)
						return result.data

						//FlightsService.upateItinerary(ctrl.flightPath)
					})

					$scope.reserveFlight = function(bookedFlight){
						var itinerary = {
						"trip": bookedFlight,
						"userId": UserService.user.id
						}

						FlightsService.updateItinerary(itinerary).then(function(result){
							ctrl.response = result.data
							console.dir(result.data)
						})
					}

					var map = new google.maps.Map(document
							.getElementById('map'), {
						zoom : 6,
						center : {
							lat : 27.6648,
							lng : -81.5158
						}
					});

					FlightsService.getAllLocations().then(function(result){
						ctrl.locations = result.data
					})

					MapService.getMarkerByCityName(map, ctrl.pointA).then(function(markerA) {
							MapService.getMarkerByCityName(map, ctrl.pointB).then(
							function(marker) {
								ctrl.addPoly(markerA, marker, '#47167C');
							})
					})

					ctrl.addPoly = function addPoly(pointA, pointB, color) {
						geodesicPoly = new google.maps.Polyline({
							strokeColor : color,
							strokeOpacity : 1.0,
							strokeWeight : 3,
							geodesic : true,
							map : map
						});

						geodesicPoly.setPath([pointA.getPosition(),
								pointB.getPosition() ]);
					}

				} ])
