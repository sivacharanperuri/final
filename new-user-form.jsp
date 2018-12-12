<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<style>
.dropbtn1 {
	background-color: #14EDF4;
	color: white;
	padding: 15px;
	font-size: 15px;
	border: none;
	cursor: pointer;
	}
	</style>
<head>
<title>Register User</title>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Register New User</h2>
		</div>
	</div>

	<div id="container">
		<input type="button" value="Go to Login Page" class=dropbtn1
			onclick="window.location.href='login'; return false;"
			class="add-button" /><br><br>

		<form:form action="saveUser" modelAttribute="user" method="POST">

			<table>
				<tbody>
					<tr>
						<td><label>Role</label></td>
						<td><form:input path="role" value="user" /></td>
					</tr>
					<tr>
						<td><label>User name:</label></td>
						<td><form:input path="userName" /></td>
					</tr>

					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="password" type="password" /></td>
					</tr>


					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>


	</div>

</body>

</html>










