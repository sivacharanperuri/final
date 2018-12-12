<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Login Page</title>
	</head>
	
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Login</h2>
		</div>
	</div>

	<div id="container">	\
	<div class="container">
		<div class="row">
		<form:form action="validateUser" modelAttribute="user" method="POST">
		
			<table>
				<tbody>
				    <tr>
						<td><label>Role:</label></td>
						<td><form:input path="role" /></td>
					</tr>
				
				
					<tr>
						<td><label>User name:</label></td>
						<td><form:input path="userName" /></td>
					</tr>
				
					<tr>
						<td><label>Password:</label></td>
						<td><form:input type="password" path="password" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Login" class="btn btn-success" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
		</div>
	</div>
		
	
	
	</div>

</body>

</html>










