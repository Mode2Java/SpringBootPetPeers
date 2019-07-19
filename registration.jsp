<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Pet Stop</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>
 
    <div class="container" align="center">

        <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading"><h1>User Registration</h1></h2>
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
               <tr><td> <form:label path="username">Username</form:label></td>
                  <td>  <form:input type="text" path="username" class="form-control" placeholder="Username"
                                autofocus="true"></form:input></td>
                   <td><form:errors path="username" style="color: red"></form:errors></td></tr>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <tr><td>  <form:label path="password">Password</form:label></td>
                    <td><form:input type="password" path="password" class="form-control" placeholder="Password"></form:input></td>
                   <td><form:errors path="password" style="color: red"></form:errors></font></td></tr>
                </div>
            </spring:bind>

            <spring:bind path="confirmPassword">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <tr><td>  <form:label path="confirmPassword">Confirm Password</form:label></td>
                    <td><form:input type="password" path="confirmPassword" class="form-control"
                                placeholder="Confirm your password"></form:input></td>
                   <td> <form:errors path="confirmPassword" style="color: red"></form:errors></td></tr>
                </div>
            </spring:bind>
			<tr><td> </td></tr>
<tr><td> </td></tr>
          <tr><td>    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button></td>
          <td></td><td>    <button class="btn btn-lg btn-primary btn-block" type="reset" value="reset">Reset</button></td></tr>
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </table>
  </body>
</html>
