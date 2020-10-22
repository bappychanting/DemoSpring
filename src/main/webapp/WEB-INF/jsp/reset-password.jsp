<%@include file="layout/master.jsp" %>

<div class="container">
<div class="card mx-5">
      <div class="card-header font-weight-bold text-uppercase">Reset Password</div>
       <div class="card-body">
	<form:form modelAttribute="resetPasswordForm" role="form" method="POST">
	
	<form:errors />
	
	<div class="form-group">
		<form:label path="password">Password</form:label>
		<form:input path="password" type="password" class="form-control" placeholder="Insert Password"/>
		<form:errors cssClass="text-danger" path="password" />
		<p class="small text-secondary">Enter password</p>
	</div>
	
	<div class="form-group">
		<form:label path="retypePassword">Password</form:label>
		<form:input path="retypePassword" type="password" class="form-control" placeholder="Insert Password"/>
		<form:errors cssClass="text-danger" path="retypePassword" />
		<p class="small text-secondary">Retype password</p>
	</div>
	
	<form:button path="submit" type="submit" class="btn btn-primary">Submit</form:button>
		
	
</form:form>
       </div>
    </div>
</div>
<%@include file="layout/footer.jsp" %>