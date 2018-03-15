<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Webservice application</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css" />

<script type="text/javascript" src="/js/angular.min.js"></script>
<script type="text/javascript" src="/js/angular-ui-router.js"></script>
<script type="text/javascript" src="/js/localforage.min.js"></script>
<script type="text/javascript" src="/js/ngStorage.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>

<script type="text/javascript" src="/js/personal/PersonalService.js"></script>
<script type="text/javascript" src="/js/personal/PersonalController.js"></script>

<script type="text/javascript" src="/js/project/ProjectService.js"></script>
<script type="text/javascript" src="/js/project/ProjectController.js"></script>

<script type="text/javascript" src="/js/timesheet/TimesheetService.js"></script>
<script type="text/javascript" src="/js/timesheet/TimesheetController.js"></script>

</head>
<body>
	<div class="navbar">
		<a ui-sref="home" ui-sref-active="active">Home</a> 
		<a ui-sref="personal" ui-sref-active="active">Personal</a>
		<a ui-sref="project" ui-sref-active="active">Project</a> 
		<a ui-sref="timesheet" ui-sref-active="active">Timesheets</a>
	</div>

	<div class="main" ui-view>
<!-- 		<ui-view></ui-view> -->
	</div>




</body>
</html>