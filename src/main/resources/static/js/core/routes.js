angular.
  module('app').
  config(['$routeProvider', 'baseRoute',
    function config($routeProvider, baseRoute) {

      $routeProvider.
      	when('/map', {
          
          templateUrl: baseRoute + "map/template.html",
          controller: 'MapController',
          controllerAs: 'mapController'
          
        }).
        when('/flights', {
          templateUrl: baseRoute + "flights/flightsTemplate.html",
          controller: 'FlightsController',
          controllerAs: 'flightsController',
          resolve: {
        	  factory: function(FlightsService){
        		  return FlightsService.getFlights()
        	  }
          }
        }).
        when('/flights/flightsSearchTemplate.html', {
        	templateUrl: baseRoute + "flights/flightsSearchTemplate.html",
        	controller: 'FlightsController',
        	controllerAs: 'flightsController',
        	resolve: {
        		factory: function($q, $rootScope, $location, LoginService, FlightsService){
        			checkRouting($q, $rootScope, $location, LoginService)
        			return FlightsService.getFlights()
        		}
        		}
        }).
        when('/flights/:flight', {
        	templateUrl: baseRoute + "flights/bookFlightTemplate.html",
        	controller: 'BookedFlightController',
        	controllerAs: 'bookedFlightController',
        	resolve: {
        		factory: function($q, $rootScope, $location, LoginService, FlightsService){
        			checkRouting($q, $rootScope, $location, LoginService)
        			FlightsService.getFlight()
        		}
        	}
        }).
        when('/home', {
        	templateUrl: baseRoute + "home/home.html",
        	controller: 'HomeController',
        	controllerAs: 'homeController',
        }).
        when('/user', {
        	templateUrl: baseRoute + "user/userTemplate.html",
        	controller: 'UserController',
        	controllerAs: 'userController',
        	resolve: {
        		factory: checkRouting
        	}
        }).
        when('/user/findUser/:username', {
    	  templateUrl: baseRoute + "user/findUser/:username",
    	  controller: 'UserController',
    	  controllerAs: 'userController',
    	  resolve: {
    		  factory: checkRouting
    	  }
      }).
        when('/login', {
        	templateUrl: baseRoute + "login/loginTemplate.html",
        	controller: 'LoginController',
        	controllerAs: 'loginController'
        }).
        when('/login/loginUnsuccessfulTemplate.html', {
        	templateUrl: baseRoute + '/login/loginUnsuccessfulTemplate.html',
        	controller: 'LoginController',
        	controllerAs: 'loginController'
          }).
          when('/login/userNotFoundTemplate.html', {
        	  templateUrl: baseRoute + '/login/userNotFoundTemplate.html',
        	  controller: 'LoginController',
        	  controllerAs: 'loginController'
          }).
          when('/register', {
        	  templateUrl: baseRoute + '/register/registerTemplate.html',
        	  controller: 'RegisterController',
        	  controllerAs: 'registerController'
          }).
          when('register/redirectRegister', {
        	  templateUrl: baseRoute + '/register/redirectRegister.html',
        	  controller: 'RegisterController',
        	  controllerAs: 'registerController',
        	  resolve: {
        		  redirect: function($timeout) { $timeout(function() { $location.path('/login') }, 3000) }
        	  }
          }).        
        otherwise('/flights');
    }
  ]);


var checkRouting = function($q, $rootScope, $location, LoginService){
	if(LoginService.checkLogin() === false){
		alert("You must be logged in to access this page")
		$location.path('/home');
	}
}

//var getFlights = function(HomeService, $rootScope, $scope, $http, $interval) {
//	$scope.getFlights = HomeService.getFlights()
//	$interval(function(){
//	$scope.getFlights().then(function(result){
//		$rootScope.flights = result.data
//		console.dir(result.data)
//	}, 8000)
//	})
//}

