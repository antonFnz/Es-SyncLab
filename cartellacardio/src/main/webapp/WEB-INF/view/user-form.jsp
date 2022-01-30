<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save New User</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Registered Users List</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Nuovo User</h3>
		<form:form action="addUser" modelAttribute="user" method="POST">
			
			<!-- important to let the system know which customer to update and not create a new one when updating -->
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>Username:</label></td>
						<td><form:input path="username"/></td>
					</tr>
					
					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="password"/></td>
					</tr>
					
					<tr>
						<td><label>Ruolo:</label></td>
						<td><form:input path="role"/></td>
					</tr>
					
					<tr>
						<td><label>Nome:</label></td>
						<td><form:input path="name"/></td>
					</tr>
					
					<tr>
						<td><label>Cognome:</label></td>
						<td><form:input path="surname"/></td>
					</tr>
					
					<tr>
						<td><label>Data di nascita: (yyyy-mm-dd)</label></td>
						<td><form:input path="birthDate"/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Aggiungi" class="save"></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/user/list">Torna alla lista</a>
		</p>
		
	</div>
</body>

</html>