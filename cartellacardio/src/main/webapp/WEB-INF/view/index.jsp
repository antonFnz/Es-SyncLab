<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
	<title>Home Page</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/tab_icon.png" />
	<link rel="icon" href="${pageContext.request.contextPath}/resources/images/tab_icon.png" />
</head>

<body>

	<a href="${pageContext.request.contextPath}">
		<img src="${pageContext.request.contextPath}/resources/images/logo.png" />
	</a>
	
	<hr>
	
	<p>
	Welcome to the Hospital Home Page.
	</p>
	
	<security:authentication property="principal.username" var="username" />
	
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role: <security:authentication property="principal.authorities" />
	</p>
	
	<!-- Admin view -->
	<security:authorize access="hasAuthority('ADMIN')">
	
	<hr>
		
		<p>
			<a href="${pageContext.request.contextPath}/user/list">Lista Utenti</a>
		</p>
	
	<hr>
	
	</security:authorize>

	<!--  Doctor view -->
	<security:authorize access="hasAuthority('MEDICO')">
	
	<hr>
		
		<p>
			<a href="${pageContext.request.contextPath}/medic/list">Lista Pazienti</a>
		</p>
	
	<hr>
	
	</security:authorize>
	
	<!-- Patient view -->
	<security:authorize access="hasAuthority('PAZIENTE')">
	
	<hr>
	
	<c:url var="cartellaPersonale" value="/patient/personal">
			<c:param name="userName" value="${username}" />
	</c:url>
		
		<p>
			<a href="${cartellaPersonale}">Cartella Personale</a>
		</p>
	
	<hr>
	
	</security:authorize>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>

</html>