<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>

<html>

<head>
	<title>Patient Record</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
	
	<a href="${pageContext.request.contextPath}">
		<img src="${pageContext.request.contextPath}/resources/images/logo.png" />
	</a>

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
				
				<c:set var="rischio" value="${risk}" />
				
				<tr>
					<th>Rischio Cardiovascolare:</th>
					<td><c:choose>
							<c:when test="${5 > risk}">
								<a><span class="greenText"><fmt:formatNumber value="${risk}" pattern="0.00"/>% </span></a>
							</c:when>
							<c:when test="${5 < risk}">
						 		<a><span class="redText"><fmt:formatNumber value="${risk}" pattern="0.00"/>% </span></a>
						 	</c:when>
						 </c:choose>
					</td>
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
			
			<h2>Upload File:</h2>
			<form method="POST" action="${pageContext.request.contextPath}/upload?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
    			<input type="file" name="file" /><br/>
    			<input type="submit" value="Submit" />
			</form>
			
			<br>
			<hr>
			
		</security:authorize>
	</p>
	
	<p>
		<security:authorize access="hasAuthority('PAZIENTE')">
		
			<c:forEach var="record" items="${records}">
			
				<c:url var="updateLinkPatient" value="/patient/addNote">
					<c:param name="userId" value="${record.patient.user.id}"/>
				</c:url>
			
				<a href="${updateLinkPatient}">Aggiungi/Modifica Nota</a>
			
			</c:forEach>
			
			<hr>
			
		</security:authorize>
	</p>
	
	<p>
			<a href="${pageContext.request.contextPath}">Torna alla Home Page</a>
	</p>
	
</body>

</html>