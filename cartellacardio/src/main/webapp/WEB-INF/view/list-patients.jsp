<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Registered Users</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>

	<img src="${pageContext.request.contextPath}/resources/images/logo.png" />
	
	<div id="wrapper">
		<div id="header">
			<h2>Pazienti</h2>
		</div>
	</div>
	
	<!--  insert table here -->
			<table>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Sesso</th>
					<th>Fumatore</th>
					<th>Diabetico</th>
					<th>Visualizza Cartella</th>
				<tr>
				
				<!--  looping display of each user -->
				<c:forEach var="tmpPatient" items="${patients}">
					
					<c:url var="viewLink" value="/medic/showPatientRecords">
						<c:param name="patientId" value="${tmpPatient.id}"/>
					</c:url>
				
					<tr>
						<td> ${tmpPatient.user.name} </td>
						<td> ${tmpPatient.user.surname} </td>
						<td> ${tmpPatient.gender} </td>
						<td> ${tmpPatient.smoker} </td>
						<td> ${tmpPatient.diabetic} </td>
						<td> <a href="${viewLink}"><img src="${pageContext.request.contextPath}/resources/images/record-icon.png" /></a> </td>
					</tr>
				</c:forEach>
			</table>
	
	<p>
			<a href="${pageContext.request.contextPath}">Torna alla Home Page</a>
	</p>
	
</body>

</html>