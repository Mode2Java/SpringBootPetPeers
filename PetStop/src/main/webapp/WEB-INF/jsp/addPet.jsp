<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form:form method="POST" action="/pet/savePet" modelAttribute="addPet">
<table>
	<tr>
		<th>NAME : </th>
		<td><form:input path="petName" /></td>
		<!--  <td><input type="Text" id="t1" name="Id" /></td> -->
	</tr>
	<tr>	
		<th>AGE : </th>
		<td><form:input path="petAge" /></td>
		<!-- <td><input type="Text" id="t1" name="Id" /></td> -->
	</tr>
	<tr>	
		<th>PLACE : </th>
		<td><form:input path="petPlace" /></td>
		<!-- <td><input type="Text" id="t1" name="Id" /></td> -->
	</tr>	
	<tr>	
		<td colspan="2" >
		<input type="submit" value="Save" />
		<input type="reset" value="Cancel"  />
		</td>
	</tr>
</table>
</form:form>
</center>
</body>
</html>