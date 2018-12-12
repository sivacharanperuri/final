<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Customer Details</title>
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
		  
<script type="text/javascript">
  setInterval("myFunction()",10000);
   function myFunction()
   {
	   window.location=location.href;
	   }
</script>
</head>
<body style="background-colour:lightyellow;">
	<div id="container" >
		<div id="content">
		<input type="button" value="Add Customer"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			<table>
				<tr>
					<th>Customer Code </th>
					<th>Customer Name </th>
					<th>Customer Address</th>
					<th>Customer Pin Code</th>
					<th>Customer Email</th>
					<th>Contact Number</th>
					<th>Registration Date</th>
					<th>Created By</th>
					<th>Modified Date</th>
					   <th>Action</th>
				</tr>
				<c:forEach var="tempCustomer" items="${customers}">
				
				<c:url var ="updatelink" value="/customer/editForm">
				<c:param name="customerCode" value ="${tempCustomer.customerCode}"></c:param>
				</c:url>
				<c:url var="deletelink" value="/customer/delete">
				<c:param name="customerCode" value ="${tempCustomer.customerCode}"></c:param>
				</c:url>
		
			
				<tr>
						<td> ${tempCustomer.customerCode} </td>
						<td> ${tempCustomer.customerName} </td>
						<td> ${tempCustomer.customerAddress} </td>
						<td> ${tempCustomer.customerPinCode} </td>
					    <td> ${tempCustomer.customerEmail} </td>
					    <td> ${tempCustomer.contactNumber} </td>
					    <td> ${tempCustomer.registrationDate} </td>
					    <td> ${tempCustomer.createdBy} </td>
					    <td> ${tempCustomer.modifiedDate} </td>	
					    <td><a href="${updatelink}">Edit</a>|<a href="${deletelink}" onClick="if(!(confirm('Are you sure you want to delete this')))return false">delete</a></td>									
					</tr>
					
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>
</html>