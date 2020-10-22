<%@include file="layout/master.jsp" %>

<div class="container">
<div class="card mx-5">
      <div class="card-header font-weight-bold text-uppercase">Forgot Password</div>
       <div class="card-body">
       
		<form:form modelAttribute="forgotPasswordForm" role="form" method="POST">
		
		<form:errors></form:errors>
	
	<div class="form-group">
		<form:label path="email">Email Address</form:label>
		<form:input path="email" type="email" class="form-control" placeholder="Insert Email"/>
		<form:errors cssClass="text-danger" path="email" />
		<p class="small text-secondary">Please enter your email address</p>
	</div>
		
		<button type="submit" class="btn btn-primary">Reset Password</button>
		
		
		</form:form>
       </div>
    </div>
</div>
<%@include file="layout/footer.jsp" %>