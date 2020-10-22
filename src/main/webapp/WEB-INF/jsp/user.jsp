<%@include file="layout/master.jsp" %>
<div class="container">
<div class="card mx-5">
      <div class="card-header font-weight-bold text-uppercase">Profile</div>
       <div class="card-body">
       </br>Name: <c:out value="${user.name}"/>
       </br>Email: <c:out value="${user.email}"/>
       </br>Role: <c:out value="${user.roles}"/>
       </div>
       <div class="card-footer">
       <c:if test="${user.editable}">
       <a class="btn btn-link" href="/users/${user.id}/edit">Edit</a>
       <a class="btn btn-link" href="/users/${user.id}/change-password">Change Password</a>
       <a class="btn btn-link" href="/users/${user.id}/change-email">Change Email</a>
       </c:if>
       </div>
    </div>
</div>
<%@include file="layout/footer.jsp" %>