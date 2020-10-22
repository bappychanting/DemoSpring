<%@include file="layout/master.jsp" %>

<div class="container">
<div class="card mx-5">
      <div class="card-header font-weight-bold text-uppercase">Signup</div>
       <div class="card-body">
	<form:form modelAttribute="signupForm" role="form" method="POST">
	
	<form:errors />
	
	<div class="form-group">
		<form:label path="email">Email Address</form:label>
		<form:input path="email" type="email" class="form-control" placeholder="Insert Email"/>
		<form:errors cssClass="text-danger" path="email" />
		<p class="small text-secondary">Enter a unique email address</p>
	</div>
	
	<div class="form-group">
		<form:label path="name">Display Name</form:label>
		<form:input path="name" type="text" class="form-control" placeholder="Insert Name"/>
		<form:errors cssClass="text-danger" path="name" />
		<p class="small text-secondary">Enter your display name</p>
	</div>
	
	<div class="form-group">
		<form:label path="password">Password</form:label>
		<form:input path="password" type="password" class="form-control" placeholder="Insert Password"/>
		<form:errors cssClass="text-danger" path="password" />
		<p class="small text-secondary">Enter password</p>
	</div>
	
	<form:button path="submit" type="submit" class="btn btn-primary">Submit</form:button>
		
	
</form:form>
       </div>
    </div>
</div>
<%@include file="layout/footer.jsp" %>