/**
 * 
 */
'use strict'
angular.module('myApp').controller('PersonalController', ['PersonalService','$scope',function(PersonalService,$scope){
	var self = this;
	self.personal = {};
	self.personals = [];
	
	self.getAllPersonals = getAllPersonals;
	
	function getAllPersonals(){
		return PersonalService.getAllPersonals();
	}
}])