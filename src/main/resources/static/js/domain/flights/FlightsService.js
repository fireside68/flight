angular.module('app').service(
		'FlightsService',
		['$http', '$timeout', '$location',
				function($http, $timeout, $location) {

					var url = 'flight/'
					
					this.bookedFlight = {}
					this.listFlights = {}

					this.getFlights = function() {
						return $http.get('flights')
					}
					
					this.getFlight = function() {
						return this.bookedFlight
					}
					
					this.setFlight = function(flight) {
						this.bookedFlight = flight
					}
					
					this.updateItinerary = function(itinerary) { return $http.post(iUrl + 'updateItinerary', itinerary) }

				} ])