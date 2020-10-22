<%@include file="layout/master.jsp" %>

<div class="container">
<div class="card mx-5">
      <div class="card-header font-weight-bold text-uppercase">Login</div>
       <div class="card-body">
       
       <c:if test="${param.error != null}">
       	<div class="alert alert-danger">
       		Invalid username or password
       	</div>
       </c:if>
       
       <c:if test="${param.logout != null}">
       	<div class="alert alert-danger">
       		You have been logged out
       	</div>
       </c:if>
       
		<form:form role="form" method="POST">
		
		<div class="form-group">
		     <label for="username">Email address:</label>
		     <input type="email" id="username" class="form-control" name="username">
		   </div>
		   
		   <div class="form-group">
		     <label for="password">Password:</label>
		     <input type="password" id="password" class="form-control" name="password">
		   	<form:errors cssClass="text-danger" path="password" />
		</div>
		
		<div class="form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="_spring_security_remember_me">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
		
		
		<a href="/forgot-password" class="btn btn-sm btn-default my-3">Forgot Password</a>
		
		</form:form>
       </div>
    </div>
</div>
<%@include file="layout/footer.jsp" %>