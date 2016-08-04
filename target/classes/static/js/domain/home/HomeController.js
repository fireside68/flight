angular.module('app').controller('HomeController', ['$scope', '$interval', '$http', 'HomeService', function($scope, $interval, $http, HomeService){

	var slideIndex = 0;


function carousel() {
	var i;
	var x = document.getElementsByClassName("mySlides");
	for (i = 0; i < x.length; i++) {
		x[i].style.display = "none";
	}
	slideIndex++;
	if (slideIndex > x.length) {slideIndex = 1}
	x[slideIndex-1].style.display = "block";
	setTimeout(carousel, 7000); // Change image every 7 seconds
}
carousel();

}]);
