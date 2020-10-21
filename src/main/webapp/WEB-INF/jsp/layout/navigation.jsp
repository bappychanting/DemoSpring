<nav class="navbar navbar-expand-lg navbar-light bg-light mb-5">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
    <div class="my-2 my-lg-0">
      <li class="nav-item">
      		 <a class="nav-link" href="<c:url value='/signup' />">Signup</a>
      </li>
      <li class="nav-item">
      		 <a class="nav-link" href="<c:url value='/login' />">Login</a>
      </li>
      <li class="nav-item">
      		 <c:url var="logouturl" value="/logout"></c:url>
      		 <form:form id="logoutForm" action="${logoutUrl}" method="post">
      		 </form:form>
      		 <a class="nav-link" href="javascript:void(0)" onclick="document.getElementById('logoutForm').submit()">Logout</a>
      </li>
    </div>
  </div>
</nav>