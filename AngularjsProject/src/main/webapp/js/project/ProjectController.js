'use strict';
angular
		.module('myApp')
		.controller(
				'ProjectController',
				[
						'ProjectService',
						'$window',
						'$scope',
						function(ProjectService,$window, $scope) {
							var self = this;
							self.project = {};
							self.projects = [];

							self.submit = submit;
							self.getAllProjects = getAllProjects;
							self.createProject = createProject;
							self.updateProject = updateProject;
							self.removeProject = removeProject;
							self.confirm = confirm;
							self.projectToSubmit = projectToSubmit;
							self.reset = reset;

							self.successMessage = '';
							self.errorMessage = '';
							self.done = false;

							function submit() {
								if (self.project.id === undefined
										|| self.project.id === null) {
									createProject(self.project);
								} else {
									updateProject(self.project.id, self.project);
								}
							}

							function getAllProjects() {
								return ProjectService.getAllProjects();
							}

							function createProject(project) {
								ProjectService
										.createProject(project)
										.then(
												function(response) {
													self.successMessage = 'Project created successfully';
													self.errorMessage = '';
													self.done = true;
													self.project = {};
													$scope.projectForm
															.$setPristine();
												},
												function(errResponse) {
													self.errorMessage = 'Error while createing Project: '
															+ errResponse;
													self.successMessage = '';
												});

							}

							function updateProject(id, project) {
								ProjectService
										.updateProject(id, project)
										.then(
												function(response) {
													self.successMessage = 'Project updated successfully';
													self.errorMessage = '';
													self.done = true;
													$scope.projectForm
															.$setPristine();
												},
												function(errResponse) {
													self.errorMessage = 'Error while updateing Project: '
															+ errResponse;
													self.successMessage = '';
												});
							}
							function removeProject(id) {

								ProjectService
										.removeProject(id)
										.then(
												function(response) {
													self.successMessage = 'Project deleted successfully';
													self.errorMessage = '';
													self.done = true;
												});

							}

							function projectToSubmit(id) {
								self.successMessage = '';
								self.errorMessage = '';
								ProjectService.getProject(id).then(
										function(project) {
											self.project = project;
											self.project.endDate = new Date(
													self.project.endDate);
											self.project.startDate = new Date(
													self.project.startDate);
										});
							}

							function confirm(id) {
								if ($window.confirm("Are you want to delete it?")) {
									removeProject(id);
				                }
							}
							function reset() {
								self.successMessage = '';
								self.errorMessage = '';
								self.project = {};
								$scope.projectForm.$setPristine();
							}
						} ])
