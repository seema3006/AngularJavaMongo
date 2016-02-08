/**
 * 
 */

// routingApp.js

    // create the module and name it routingApp
    var routingApp = angular.module('routingApp', ['ngRoute']);

    // create the controller and inject Angular's $scope
    routingApp.config(function($routeProvider)
    		{
    	      $routeProvider
    	      // route for the home page
              .when('/', {
                  templateUrl : 'view/home.html',
                  controller  : 'mainController'
              })
    	
    	
              // route for the empSearch page
            .when('/empSearch', {
                templateUrl : 'view/searchEmp.html',
                //controller  : 'empController'
                controller :'SearchEmpController'
            })
            
            // route for the department page
            .when('/dept', {
                templateUrl : 'view/dept.html',
                controller  : 'deptController'
            })
            
            // route for the contact page
            .when('/contact', {
                templateUrl : 'view/contact.html',
                controller  : 'contactController'
            })
            
            
    		}
    )
  
    
     // create the controller and inject Angular's $scope
    routingApp.controller('mainController', function($scope) {
        // create a message to display in our view
        $scope.message = 'Everyone come and see how good I look!';
    });
    
    
    routingApp.controller('empController', function($scope) {
        $scope.message = 'Search for an employee.';
    });
    
    
    routingApp.controller('deptController', function($scope) {
        $scope.message = 'List of Departments';
    });

    
    routingApp.controller('contactController', function($scope) {
        $scope.message = 'Contact us at adminangular.com';
    });
    
    routingApp.controller("SearchEmpController", function($scope,$http) {
   	 // window.alert("in controller");
   	  $scope.searchEmp=function()
   	  {
   		//window.alert("in createUser");
   			  $http({
   	      method: 'POST',
   	      url: 'http://localhost:8080/angularPrj/searchEmp',
   	      headers: {'Content-Type': 'application/json'},
   	      data:  $scope.user
   	    }).success(function (data) 
   	      {
   	    	//window.alert("success  : "+data);
   	    	$scope.status=data;
   	    	
   	      });
   		
   		
   	  }
     });
