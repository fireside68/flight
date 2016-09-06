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

					this.getFlightPath = function(params) {
						return $http.get('flights/getItinerary', {params: { from : params.origin, to: params.destination }})
					}

					this.updateItinerary = function(itinerary) { return $http.post(itineraryUrl + 'updateItinerary', itinerary) }

				} ])
