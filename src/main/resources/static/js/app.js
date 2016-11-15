var app = angular.module('myApp', []);
app.controller('EmailCtrl', function ($scope, $http) {
  $scope.success = false;
  $scope.httpError = false;
  
  $scope.send = function() {
    var input = { 
    		toAddress: $scope.toAddress,
    		subject: $scope.subject,
    		message: $scope.message
    };
    $http.post('/email',input).
      success(function(data){
        $scope.success = true;
        $scope.msg = {};
      }).
      error(function(data){
        $scope.httpError = true;
      });
  }
});