<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Registered Users</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Cartella Cardiologica Personale</h2>
		</div>
	</div>
	
	<!--  insert table here -->
			<table>
				<tr>
					<th>Motivo Visita</th>
					<th>Anamnesi</th>
					<th>Pressione</th>
					<th>Frequenza Cardiaca</th>
				<tr>
				
				<!--  looping display of each user -->
				<c:forEach var="record" items="${records}">
					<tr>
						<td> ${record.motive} </td>
						<td> ${record.anamnesis} </td>
						<td> ${record.pressure} </td>
						<td> ${record.heartRate} </td>
					</tr>
				</c:forEach>
			</table>
	
	<p>
			<a href="${pageContext.request.contextPath}">Torna alla Home Page</a>
	</p>
	
</body>

</html>