<div class="container">
  <h2>Hover Rows</h2>
  <p>The .table-hover class enables a hover state on table rows:</p>            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <tr ng-repeat="p in ctrl.getAllPersonals()">
        <td>{{p.id}}}</td>
        <td>{{p.dob}}}</td>
        <td>{{p.fullname}}}</td>
        <td>{{p.gender}}}</td>
        <td>{{p.phone}}}</td>
      </tr>
    </tbody>
  </table>
</div>