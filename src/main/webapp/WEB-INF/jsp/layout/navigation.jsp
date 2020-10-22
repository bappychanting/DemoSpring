<nav class="navbar navbar-expand-lg navbar-light bg-light mb-5">
  <a class="navbar-brand" href="javascript:void(0);">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value='/' />">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="javascript:void(0);">Disabled</a>
      </li>
      </ul>
    <ul class="navbar-nav ml-auto">
      <sec:authorize access="isAuthenticated()">
      <li class="nav-item">
   		 <a class="nav-link" href="/users/<sec:authentication property='principal.user.id'/>">
   		 	<sec:authentication property="principal.user.name"/>
   		 </a>
      </li>
      <li class="nav-item">
   		 <c:url var="logoutUrl" value="/logout"></c:url>
   		 <form:form id="logoutForm" action="${logoutUrl}" method="post"></form:form>
   		 <a class="nav-link" href="javascript:void(0);" onclick="document.getElementById('logoutForm').submit()">Logout</a>
      </li>
      </sec:authorize>
      <sec:authorize access="isAnonymous()">
      <li class="nav-item">
      		 <a class="nav-link" href="<c:url value='/signup' />">Signup</a>
      </li>
      <li class="nav-item">
      		 <a class="nav-link" href="<c:url value='/login' />">Login</a>
      </li>
      </sec:authorize>
    </ul>
  </div>
</nav>