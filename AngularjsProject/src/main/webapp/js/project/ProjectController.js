
'use strict';
angular.module('myApp').controller('TimesheetController', ['TimesheetService','$scope',function(TimesheetService,$scope){
	var self = this;
	self.timesheet = {};
	self.timesheets = [];
	
	self.submit = submit;
	self.getAllTimesheets = getAllTimesheets;
	self.createTimesheet = createTimesheet;
	self.updateTimesheet = updateTimesheet;
	self.removeTimesheet = removeTimesheet;
	self.timesheetToSubmit = timesheetToSubmit;
	self.reset = reset;
	
	
	self.successMessage = '';
	self.errorMessage = '';
	self.done = false;
	

	
	function submit(){
		if(self.timesheet.idTimesheet === undefined || self.timesheet.idTimesheet === null){
			createTimesheet(self.timesheet);
		}else{
			updateTimesheet(self.timesheet.id,self.timesheet);
		}
	}
	
	function getAllTimesheets(){
		return TimesheetService.getAllTimesheets();
	}
	
	function createTimesheet(timesheet) {
		TimesheetService.createTimesheet(timesheet).then(
				function(response) {
					self.successMessage = 'Timesheet created successfully';
					self.errorMessage = '';
					self.done = true;
					self.timesheet = {};
					$scope.timesheetForm.$setPristine();
				},function(errResponse){
					self.errorMessage = 'Error while createing Timesheet: '+ errResponse;
					self.successMessage = '';
				}
		);
		
	}
	
	function updateTimesheet(id,timesheet) {
		TimesheetService.updateTimesheet(id, timesheet).then(
				function(response){
					self.successMessage = 'Timesheet updated successfully';
					self.errorMessage = '';
					self.done = true;
					$scope.timesheetForm.$setPristine();
				}, function(errResponse){
					self.errorMessage = 'Error while updateing Timesheet: '+errResponse;
					self.successMessage = '';
				}
		);
	}
	function removeTimesheet(id) {
		
		TimesheetService.removeTimesheet(id).then(
					function (response) {
						self.successMessage = 'Timesheet deleted successfully';
						self.errorMessage = '';
						self.done = true;
					}
			);
		
	}
	
	function timesheetToSubmit(id) {
		self.successMessage = '';
		self.errorMessage = '';
		TimesheetService.getTimesheet(id).then(
				function(timesheet) {
					self.timesheet = timesheet;
				}
		);
	}
	function reset(){
        self.successMessage='';
        self.errorMessage='';
        self.timesheet={};
        $scope.timesheetForm.$setPristine();
    }
}])


