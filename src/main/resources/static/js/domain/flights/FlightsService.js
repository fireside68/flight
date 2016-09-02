angular.module('app').service(
		'FlightsService',
		['$http', '$timeout', '$location',
				function($http, $timeout, $location) {

					var url = 'flight/'
					var locUrl = 'location/'
					var itineraryUrl = 'itinerary/'

					this.bookedFlight = {}
					this.listFlights = {}
					this.getAllLocations = function() { return $http.get(locUrl) }

					this.getFlights = function() {
						return $http.get('flights')
					}

					this.getFlight = function() {
						return this.bookedFlight
					}

					this.setFlight = function(flight) {
						this.bookedFlight = flight
					}

					this.getFlightPath = function(origin, dest) {
						return $http.get('flights/getItinerary', {params: { from : origin, to: dest }})
					}

					this.updateItinerary = function(itinerary) { return $http.post(itineraryUrl + 'updateItinerary', itinerary) }

				} ])
