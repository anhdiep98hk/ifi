var myApp = angular.module('myApp', [ 'ui.router', 'ngStorage' ]);

myApp.constant('', {
	BASE : 'http://localhost:8080',
	PERSONAL_SERVICE_API : 'http://localhost:8080/api/personal/',
	PROJECT_SERVICE_API : 'http://localhost:8080/api/project/',
	TIMESHEET_SERVICE_API : 'http://localhost:8080/api/timesheet/'
})

myApp.config('$stateProvider', '$urlRouterProvider', function($stateProvider,
		$urlRouterProvider) {
	var homeState = {
		name : 'home',
		url : '/',
		templateUrl : '/js/home/home.template.jsp'
	}
	var personalState = {
		name : 'personal',
		url : '/personal',
		templateUrl : '/js/personal/personal.template.jsp',
		controller : 'PersonalController',
		controllerAs : "ctrl",
		resolve : {
			personals: function($q, PersonnalService) {
				var deferred = $q.defer();
				PersonnalService.loadAllPersonals().then(deferred.resolve, deferred.resolve);
				return deferred.promise;
			}
		}
	}

	var projectState = {
		name : 'project',
		url : '/project',
		templateUrl : '/js/project/project.template.jsp'
	}

	var timesheetState = {
		name : 'timesheet',
		url : '/timesheet',
		templateUrl : '/js/timesheet/timesheet.template.jsp'
	}

	$stateProvider.state(personalState);
	$stateProvider.state(projectState);
	$stateProvider.state(timesheetState);
	$stateProvider.state(homeState);
});
