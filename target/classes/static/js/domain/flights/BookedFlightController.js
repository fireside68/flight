angular.module('app').controller(
		'BookedFlightController',
		[
				'FlightsService',
				'UserService',
				'MapService',
				'flightData',
				'$rootScope',
				'$http',
				'$scope',
				'$location',
				function(FlightsService, UserService, MapService, flightData, $rootScope, $http,
						$scope, $location) {

					var ctrl = this
					
					$scope.itinerary = flightData.data
					$scope.itinerary.user = UserService.user.id
					$scope.flight = $scope.itinerary.flights
					if(flightData === undefined || flightData === null || flightData === "") {
						alert("information error")
					} else {
						console.dir(JSON.stringify(flightData.data))
					}
					$scope.origin = $scope.flight[0].origin
					$scope.destination = $scope.flight[$scope.flight.length-1].destination
					$scope.flightTime = 0
					$scope.offset = 0
					
					for(var i = 0; i < $scope.flight.length; i++) {
						
						$scope.flightTime += $scope.flight[i].flightTime
						$scope.offset += $scope.flight[i].offset
					}
					
					ctrl.colors = ['#FF2222', '#DDDD22', '#2222FF', '#22DDDD', '22FF22']
					ctrl.colorNum = 0
					
					ctrl.geoLines = [];
					

					var map = new google.maps.Map(document
							.getElementById('map'), {
						zoom : 6,
						center : {
							lat : 27.6648,
							lng : -81.5158
						}
					});
					
					ctrl.addPoly = function addPoly(pointA, pointB, color) {
						console.dir("adding POLLLYYYY")
						ctrl.geoLines.push(new google.maps.Polyline({
							path: [ pointA.getPosition(), pointB.getPosition() ],
							strokeColor : color,
							strokeOpacity : 1.0,
							strokeWeight : 3,
							geodesic : true,
							map : map,
							icons: [{
				                icon: {path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW},
				                offset: '100%'
				            }]
						}));
					}
					
					this.initializeMap = function() {
						var origin = null;
						MapService.getMarkersByCities(map, $scope.flight).then(function(result) {
							origin = result[0];
							var col = ctrl.colors[0]
							for (var i = 1; i < result.length; i++) {
								ctrl.addPoly(origin, result[i], col);
								origin = result[i];
								col = ctrl.colors[i+1]
							}
						});
					}
					
					if ($scope.flight === null || $scope.flight === undefined) {
						$location.path('flight/')
					} else {
						this.initializeMap();
					}
					
					$scope.reserveFlight = function() {
						FlightsService.updateItinerary($scope.itinerary).then(function($rootScope) {
							$rootScope.$apply(function() {
								$location.path('/user')
								console.log($location.path)
							})
						})
					}


				} ])
