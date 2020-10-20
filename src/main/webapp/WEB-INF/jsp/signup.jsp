<%@include file="layout/master.jsp" %>
<div class="container">
		<h1>Signup ${name} </h1>
		<form:form modelAttribute="signupForm" role="form" method="POST">
		
		<div class="form-group">
			<form:label path="email">Email Address</form:label>
			<form:input path="email" type="email" class="form-control" placeholder="Insert Email"/>
			<p class="help-block">Enter a unique email address</p>
		</div>
		
		<div class="form-group">
			<form:label path="name">Email Address</form:label>
			<form:input path="name" type="text" class="form-control" placeholder="Insert Name"/>
			<p class="help-block">Enter your display name</p>
		</div>
		
		<div class="form-group">
			<form:label path="password">Password</form:label>
			<form:input path="password" type="password" class="form-control" placeholder="Insert Password"/>
			<p class="help-block">Enter password</p>
		</div>
		
		<form:button path="submit" type="submit" class="btn btn-primary">Submit</form:button>
			
		
	</form:form>
</div>
<%@include file="layout/footer.jsp" %>