<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Registered Users</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Registered Users List</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<!-- Add User button -->
			<input type="button" value="Aggiungi Utente"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button"/>
					
			<!-- Search User box -->
			<form:form action="search" method="GET">
					<img src="${pageContext.request.contextPath}/resources/images/search-icon.png" />
							<input type="text" name="searchName" />
							<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<!--  insert table here -->
			<table>
				<tr>
					<th>Username</th>
					<th>Role</th>
					<th>Name</th>
					<th>Surname</th>
					<th>Date of Birth</th>
					<th></th>
				<tr>
				
				<!--  looping display of each user -->
				<c:forEach var="tmpUser" items="${users}">
				
					<!-- update link -->
					<c:url var="updateLink" value="/user/showFormForUpdate">
						<c:param name="userId" value="${tmpUser.id}"/>
					</c:url>
					
					<!-- delete link -->
					<c:url var="deleteLink" value="/user/delete">
						<c:param name="userId" value="${tmpUser.id}"/>
					</c:url>
					
					<tr>
						<td> ${tmpUser.username} </td>
						<td> ${tmpUser.role} </td>
						<td> ${tmpUser.name} </td>
						<td> ${tmpUser.surname} </td>
						<td> ${tmpUser.birthDate} </td>
						<!-- update link -->
						<td><a href="${updateLink}">
							<img src="${pageContext.request.contextPath}/resources/images/edit-icon.png" /></a>
						|
						<a href="${deleteLink}"
							onclick="if (!(confirm('Questa opzione cancellerà l'utente selezionato, proseguire?')))">
							<img src="${pageContext.request.contextPath}/resources/images/delete-icon.png" /></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>