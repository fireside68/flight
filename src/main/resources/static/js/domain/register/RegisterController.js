angular.module('app').controller('RegisterController', ['RegisterService', '$timeout', '$location', function(RegisterService, $timeout, $location) {
	
	var ctrl = this

	ctrl.addNewUser = function () {
		var newUser = {
		"username": ctrl.username,
		"password": ctrl.password,
		"firstName": ctrl.firstName,
		"lastName": ctrl.lastName,
		"email": ctrl.email
		}

		RegisterService.addNewUser(newUser).then(function(result) {
			ctrl.user = result.data;
			console.dir(ctrl.user)
			$timeout(function() { $location.path('/register/redirectRegister.html') }, 1000)
		})
	}


}])