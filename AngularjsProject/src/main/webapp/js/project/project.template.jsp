<div class="container">

	<div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Specific Project </span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="projectForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.project.id" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.project.name" id="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>
 
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable">Start date</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.project.startDate" class="form-control input-sm"  required/>
                            </div>
                        </div>
                    </div>
                    
                    
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable">Start end</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.project.endDate" class="form-control input-sm"  required/>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.project.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="projectForm.$invalid || projectForm.$pristine">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="personalForm.$pristine">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>    
    </div>
<hr/>
	<h2>List of Project</h2>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Start Date</th>
				<th>End Date</th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="p in ctrl.getAllProjects()">
				<td>{{p.id}}</td>
				<td>{{p.name}}</td>
				<td>{{p.startDate | date: "dd/MM/yyyy"}}</td>
				<td>{{p.endDate | date: "dd/MM/yyyy"}}</td>
				<td><button type="button" ng-click="ctrl.projectToSubmit(p.id)"
						class="btn btn-success custom-width">Edit</button></td>
				<td><button type="button" ng-click="ctrl.confirm(p.id)"
						class="btn btn-danger custom-width">Remove</button></td>

			</tr>
		</tbody>
	</table>
</div>