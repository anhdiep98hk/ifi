/**
 * 
 */
'use strict'

angular.module('myApp').factory('PersonalService',['$localStorage','$http','$q','urls',
	function($localStorage,$http,$q,urls){
		var factory = {
				loadAllPersonals: loadAllPersonals,
				getAllPersonals: getAllPersonals
		};
		
		return factory;
		
		function loadAllPersonals(){
			var deferred = $q.defer();
			$http.get(urls.PERSONAL_SERVICE_API)
			.then(function(response) {
				$localStorage.personals = response.data;
				deferred.resolve(response);
			},function(errResponse){
				deferred.reject(errResponse);
			}
			);
			return deferred.promise;
		}
		
		function getAllPersonals() {
			return $localStorage.personals;
		}
		
		function getPersonal(id) {
			var deferred = $q.defer();
			$http.get(urls.PERSONAL_SERVICE_API + id)
			.then(function(response) {
				deferred.resolve(response.data);
			}, function(errResponse) {
				deferred.reject(errResponse);
			});
			return deferred.promise;
		}
		
		
	};
]);