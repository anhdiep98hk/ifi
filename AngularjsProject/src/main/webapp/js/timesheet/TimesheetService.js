/**
 * 
 */
'use strict';

angular.module('myApp').factory('TimesheetService',['$localStorage','$http','$q','urls',
	function($localStorage,$http,$q,urls){
		var factory = {
				loadAllTimesheet:  loadAllTimesheet,
				getAllTimesheets:  getAllTimesheets,
				getTimesheet: getTimesheet,
				createTimesheet:createTimesheet,
				updateTimesheet:updateTimesheet,
				removeTimesheet:removeTimesheet
		};
		
		return factory;
		
		
		
		function loadAllTimesheet(){
				var deferred = $q.defer();
				$http.get(urls.TIMESHEET_SERVICE_API)
				.then(function(response) {
					$localStorage.timesheets = response.data;
					deferred.resolve(response);
				},function(errResponse){
					deferred.reject(errResponse);
				}
			);
			return deferred.promise;
		}
		
		function getAllTimesheets() {
			return $localStorage.timesheets;
		}
		
		function getTimesheet(id) {
			var deferred = $q.defer();
			$http.get(urls.TIMESHEET_SERVICE_API + id)
			.then(function(response) {
				deferred.resolve(response.data);
			}, function(errResponse) {
				deferred.reject(errResponse);
			});
			return deferred.promise;
		}
		
		function createTimesheet(timesheet) {
			var defferred = $q.defer();
			$http.post(urls.TIMESHEET_SERVICE_API, timesheet).then(
					function(response) {
						loadAllTimesheet();
						defferred.resolve(response.data);
					},function(errResponse){
						defferred.reject(errResponse);
					}
			);
			return defferred.promise;
		}
		
		function updateTimesheet(id,timesheet) {
			var defferred = $q.defer();
			$http.put(urls.TIMESHEET_SERVICE_API + id, timesheet).then(
					function(response) {
						loadAllTimesheet();
						defferred.resolve(response.data);
					},
					function(errResponse) {
						defferred.reject(errResponse);
					}
			);
			return defferred.promise;
		}
		
		function removeTimesheet(id) {
			var defferred = $q.defer();
			$http.delete(urls.TIMESHEET_SERVICE_API+id).then(
					function(response) {
						loadAllTimesheet();
						defferred.resolve(response.data);
					},
					function(errResponse){
						defferred.reject(errResponse);
					}
			);
			return defferred.promise;
		}
	}
]);