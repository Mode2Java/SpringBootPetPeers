<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib
uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
<center><h1>Welcome to PetStop</h1>
        <h3>Sign in</h3></center>
<form:form name="submitForm" modelAttribute="user" method="POST" >
<div align="center">
<table>
<tr>
<td>User Name</td>
<td><input type="text" name="userName"/></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td></td>
<td colspan = "2"><input type="submit" value="Submit" /></td>
<td><input type="reset" value="Reset"/></td>
</tr>
</table>
<div style="color: red">${error}</div>

</div>
</form:form>
</body>
</html>