<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
			<h2>Cartella Cardiologica Personale</h2>
		</div>
	</div>
	
	<!--  insert table here -->
			<table>
			<c:forEach var="record" items="${records}">
				<tr>
					<th>Motivo Visita</th>
					<td> ${record.motive} </td>
				</tr>
				<tr>
					<th>Anamnesi</th>
					<td> ${record.anamnesis} </td>
				</tr>
				<tr>
					<th>Pressione</th>
					<td> ${record.pressure} mmHg</td>
				</tr>
				<tr>
					<th>Frequenza Cardiaca</th>
					<td> ${record.heartRate} bpm</td>
				</tr>
				<tr>
					<th>Vita</th>
					<td> ${record.waist} cm</td>
				</tr>
				<tr>
					<th>Nota (Medico)</th>
					<td> ${record.medicNote}</td>
				</tr>
				<tr>
					<th>Nota (Paziente)</th>
					<td> ${record.patientNote}</td>
				</tr>
			</c:forEach>
			</table>
			
	<p>
		<security:authorize access="hasAuthority('MEDICO')">
		
			<c:forEach var="record" items="${records}">
			
				<c:url var="updateLink" value="/medic/showFormUpdate">
						<c:param name="patientId" value="${record.patient.id}"/>
				</c:url>
			
				<a href="${updateLink}">Modifica Dati</a>
			
			</c:forEach>
			
			<hr>
			
		</security:authorize>
	</p>
	
	<p>
		<security:authorize access="hasAuthority('PAZIENTE')">
			
			Aggiungi Nota
			
			<hr>
			
		</security:authorize>
	</p>
	
	<p>
			<a href="${pageContext.request.contextPath}">Torna alla Home Page</a>
	</p>
	
</body>

</html>