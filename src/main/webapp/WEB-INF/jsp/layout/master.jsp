<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@include file="styles.jsp" %>
</head>
<body>

	<div class="container">
	
		<%@include file="navigation.jsp" %>
		
      <sec:authorize access="hasRole('ROLE_UNVERIFIED')">
			<div class="alert alert-warning alert-dismissable fade show" role="alert">
				Your email id is unverified. 
				<a href="/users/resend-verification-mail">Click here to send the verification mail again</a>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    			<span aria-hidden="true">&times;</span>
	  			</button>
			</div>
      </sec:authorize>
		
		<c:if test="${not empty flashMessage}">
			<div class="alert alert-${flashType} alert-dismissable fade show" role="alert">
				${flashMessage}
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    			<span aria-hidden="true">&times;</span>
	  			</button>
			</div>
		</c:if>
	</div>