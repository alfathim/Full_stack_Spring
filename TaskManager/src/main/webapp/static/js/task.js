

  
  var taskApp = angular.module("TaskManager",[]);

   

  
  taskApp.controller("TaskController",function($scope,$http,$filter){
	  
	  loadData();
	  
	   

	  $scope.removeTask = function (task){
		  alert("deleting ---"+task.name);
		  $http({
			  method:"DELETE",
			  url:'http://localhost:8080/deleteTask/'+task.id
		  }).then(onSuccess,onError);
		  
	  };
	  
	  
	  
	  
	  $scope.editTask = function (task){		
		   
		  $scope.pageTask = task;
		  var sd = task.startDate;
		  var ed = task.endDate;
		
		  $scope.pageTask.startDate = $filter('date')(sd,'yyyy-MM-dd');
		  $scope.pageTask.endDate  = $filter('date')(ed,'yyyy-MM-dd');
		  
	  };

	   $scope.resetTask = function (task){		
		   
		  $scope.pageTask = [];
		  $scope.pageTask.priority =0;
		  
		  
	  };
	  
	 

	  
	  $scope.submitTask = function() {
	      alert("submit");
          var method = "";
          var url = "";
         
              //If Id is present, it's edit operation - PUT operation
              method = "POST";
              url = 'http://localhost:8080/addTask' ;
         

          $http({
              method : method,
              url : url,
              data : angular.toJson($scope.pageTask),
              headers : {
                  'Content-Type' : 'application/json'
              }
          }).then( onSuccess, onError );
      };
	  
	  //priavte method
	  function loadData(){
		   $http({
			  method : 'GET',
	          url : 'http://localhost:8080/tasks'
		  }
		  ).then(function successCallback(response) {
			  alert("sucess"+ response);
	          $scope.tasks = response.data;
	      }, function errorCallback(response) {
	    	  alert("error  =="+response);
	    	  $scope.tasks = response;
	      });
	  }
	  
	  function onSuccess(response){
		  alert("oncsucess");
		  loadData();
	  }
	  
	  function onError(response){
		   alert("erorr "+ response);
		  console.log(response.statusText);
	  }
  }	  
  );
  
 