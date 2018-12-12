<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Edit Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body style="background-color: powderblue;">

	<div id="container" >
		<h3>Edit Customer</h3>
				<form:form action="editCustomer" modelAttribute="customer" method="POST">
	<table>
				<tbody>
					<tr>
						<td><label>Customer Code</label></td>
						<td><form:input path="customerCode" maxlength="10" required=""/></td>
					</tr>
					<tr>
						<td><label>Customer Name</label></td>
						<td><form:input path="customerName" pattern="[A-Za-z ]*$"  maxlength="30" id="Customer_Name" required=""/></td>
					</tr>
					<tr>
						<td><label>Customer Address</label></td>
						<td><form:input path="customerAddress" maxlength="100" required="" /></td>
					</tr>
					<tr>
						<td><label>Customer Pin Code</label></td>
						<td><form:input path="customerPinCode" min="100000" max="999999" id="Customer_PinCode" required=""/></td>
					</tr>
					<tr>
						<td><label>Customer Email</label></td>
						<td><form:input path="customerEmail" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,6}" title="Invalid Email" id="Email_Address" maxlength="100" required=""/></td>
					</tr>
					<tr>
						<td><label>Contact Number</label></td>
						<td><form:input path="contactNumber" maxlength="20" required=""/></td>
					</tr>
					<tr>
						<td><label>Registration Date</label></td>
						<td><form:input path="registrationDate" /></td>
					</tr>
					<tr>
						<td><label>Created By</label></td>
						<td><form:input path="createdBy" /></td>
					</tr>
					<%-- <tr>
						<td><label>Modified Date</label></td>
						<td><form:input path="modifiedDate" /></td>
					</tr> --%>			

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>
