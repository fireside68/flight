angular.module('app').controller(
		'BookedFlightController',
		[
				'FlightsService',
				'MapService',
				'$routeParams',
				'$http',
				'$scope',
				function(FlightsService, MapService, $routeParams, $http,
						$scope) {

					var ctrl = this
					console.dir(FlightsService.listFlights)
					$scope.bookedFlight = JSON.parse($routeParams.flight)
					ctrl.getMarkerByCityName = MapService.getMarkerByCityName()
					pointA = $scope.bookedFlight.origin
					pointB = $scope.bookedFlight.destination

					console.dir(pointA)
					console.dir(pointB)

					var map = new google.maps.Map(document
							.getElementById('map'), {
						zoom : 6,
						center : {
							lat : 27.6648,
							lng : -81.5158
						}
					});

					MapService.getMarkerByCityName(map, pointA).then(
							function(marker, pointB) {
								ctrl.addPoly(pointB, marker, '#CC0099');
							})

					ctrl.addPoly = function addPoly(pointA, pointB, color) {

						geodesicPoly = new google.maps.Polyline({
							strokeColor : color,
							strokeOpacity : 1.0,
							strokeWeight : 3,
							geodesic : true,
							map : map
						});

						geodesicPoly.setPath([ctrl.pointA.getPosition(),
								ctrl.pointB.getPosition() ]);
					}

				} ])
