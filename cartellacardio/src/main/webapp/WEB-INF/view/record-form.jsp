<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save New User</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-style.css">
</head>

<body>

	<img src="${pageContext.request.contextPath}/resources/images/logo.png" />

	<div id="wrapper">
		<div id="header">
			<h2>Cartella</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Modifica Cartella</h3>
		<form:form action="addRecord" modelAttribute="records" method="POST">
		<!-- important to let the system know which record to update and not create a new one when updating -->
		<form:hidden path="idcartella"/>
		<form:hidden path="patientNote"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>Motivo Visita:</label></td>
						<td><form:input path="motive"/></td>
					</tr>
					
					<tr>
						<td><label>Anamnesi:</label></td>
						<td><form:input path="anamnesis"/></td>
					</tr>
					
					<tr>
						<td><label>Pressione:</label></td>
						<td><form:input path="pressure"/></td>
					</tr>
					
					<tr>
						<td><label>Frequenza Cardiaca:</label></td>
						<td><form:input path="heartRate"/></td>
					</tr>
					
					<tr>
						<td><label>Vita:</label></td>
						<td><form:input path="waist"/></td>
					</tr>
					
					<tr>
						<td><label>Nota:</label></td>
						<td><form:textarea path="medicNote" rows="6" cols="33"/></td>
					</tr>
					
					<tr>
						<td><label>Paziente:</label></td>
						<td><form:input path="patient.id"/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Salva" class="save"></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<c:url var="backLink" value="/medic/showPatientRecords">
						<c:param name="patientId" value="${records.patient.id}"/>
			</c:url>
		
			<a href="${backLink}">Torna alla cartella</a>
		</p>
		
	</div>
</body>

</html>