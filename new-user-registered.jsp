<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
.dropbtn2 {
	background-color: FFFFFF;
	color: white;
	padding: 15px;
	font-size: 15px;
	border: none;
	cursor: pointer;
}</style>
<head>
	<title>Register User</title>
	</head>

<body>
	
	<h1>New User Registered!</h1>
	<input type="button" value="Add New User" class=dropbtn1
				   onclick="window.location.href='newuser'; return false;"
				   class="add-button"
			/><br><br>
	<input type="button" value="Go to Login Page" class=dropbtn2
				   onclick="window.location.href='login'; return false;"
				   class="add-button"
	/>
	
</body>

</html>










