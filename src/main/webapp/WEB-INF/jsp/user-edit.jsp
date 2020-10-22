<%@include file="layout/master.jsp" %>

<div class="container">
<div class="card mx-5">
      <div class="card-header font-weight-bold text-uppercase">Edit <c:out value="${user.name}"/></div>
       <div class="card-body">
	<form:form modelAttribute="userEditForm" role="form">
	
	<form:errors />
	
	<div class="form-group">
		<form:label path="name">Display Name</form:label>
		<form:input path="name" type="text" class="form-control" placeholder="Insert Name"/>
		<form:errors cssClass="text-danger" path="name" />
		<p class="small text-secondary">Enter your display name</p>
	</div>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<div class="form-group">
		<form:label path="roles">Roles</form:label>
		<form:input path="roles" class="form-control" placeholder="Insert Roles"/>
		<form:errors cssClass="text-danger" path="roles" />
		<p class="small text-secondary">Enter the roles of the users, separated by comma</p>
	</div>
      </sec:authorize>
	
	<form:button path="submit" type="submit" class="btn btn-primary">Update</form:button>
		
	
</form:form>
       </div>
    </div>
</div>
<%@include file="layout/footer.jsp" %>