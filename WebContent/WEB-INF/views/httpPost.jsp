<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

</head>

<body>

<h1>httpPost</h1>

<div ng-app="myApp" ng-controller="myCtrl"> 	
<h1>{{myWelcome}}</h1>
  <p>The button has been clicked {{count}} times.</p>

<input type="button" value="post" ng-click="trialPost()">
</div>

<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) { 
      $scope.myWelcome = "Rahul";
      $scope.count = 0;
      
      var req = {
    		  method: 'POST',
    		  url: '/SpringMVC/test',
    		  headers: {
    		    /* 'Content-Type': undefined */
    		  },
    		  data: { }
    		 }
      
      

      $scope.trialPost= function() {
    	  
    	  
          $scope.count++;
          
          $http(req).then(success,fail)
          
          function success(data,status,headers,config){
        	  alert("success");
          }
          
          function fail(){
        	  alert("fail");
          }
      };

});
</script>

</body>
</html>