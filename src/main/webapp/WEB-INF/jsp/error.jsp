<%@include file="layout/master.jsp" %>
<div class="container">
<div class="alert alert-danger mb-3">
There was an unexpected error (type=${error}, status=${status}): <b>${message}</b>
</div>
<a href="/" class="btn btn-danger">Return to home page</a>
</div>
<%@include file="layout/footer.jsp" %>