/**
 * 
 */

angular.module('app').service('MapService',
		[ '$http', function($http) {

			this.getMarkerByCityName = function(map, name) {

				//Send city name param to URL
				return $http.get('location/name', {params: { name : name }}).then(function(result) {
					return new google.maps.Marker({
						map : map,
						position : {
							
							//Use + to turn string to number
							lat : +result.data.latitude,
							lng : +result.data.longitude
						}
					});
				})

			}
			
			this.getMarkersByCities = function(map, names) {
				var n = [];
				n.push(names[0].origin)
				n.push(names[0].destination)
				for (var i = 1; i < names.length; i++) {
					n.push(names[i].destination)
				}
				
				return $http.get('location/names', {params: { names : n }}).then(function(result) {
					console.dir(JSON.stringify(result.data))
					var res = [];
					for (var i = 0; i < result.data.length; i++) {
						res.push(new google.maps.Marker({
							map : map,
							position : {
								lat : +result.data[i].latitude,
								lng : +result.data[i].longitude
							}
						}));
					}
					console.dir(res)
					return res;
				})
			}

		} ]);