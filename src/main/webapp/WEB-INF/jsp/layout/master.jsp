<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		
		<c:if test="${not empty flashMessage}">
			<div class="alert alert-${flashType} alert-dismissable fade show" role="alert">
				${flashMessage}
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    			<span aria-hidden="true">&times;</span>
	  			</button>
			</div>
		</c:if>
	</div>