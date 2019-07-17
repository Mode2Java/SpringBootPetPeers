<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PET STOP</title>
 <meta name="viewport" id="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>

    <link rel="stylesheet" href="css/index.css">
       
</head>
<body >
<center><h2>PET STOP </h2></center>
<div class="container" style="margin-top: 20px;">
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/pet/viewallpets" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		

<table class="table table-bordered">

<b></b><a href="/pet/viewmypets">ViewMyPets</a></b>
<b></b><a href="/pet/addPet">AddPet	</a></b>
<b></b><a href="/pet/well">Welcome	</a></b></br></br>
<tr><th>PET ID</th><th>PET NAME</th><th>PET AGE</th><th>PET PLACE</th><th>ACTION</th></tr>

<c:forEach items="${pagedListHolder.pageList}" var="temp" >
					
                    <tr>
                    	
                    	<td>${temp.petId}</td>
                        <td>${temp.petName}</td>
                        <td>${temp.petAge}</td>
                        <td>${temp.petPlace}</td>
                        <td><input type="button" id="buy" value="BUY" onclick="disableFunction()"> 
                    </tr>
                </c:forEach>
  
      
</table>
<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />
	</div>
<script>
function disableFunction(){
	document.getElementById("buy").value='SOLD';
	
}
</script> 

</body>

</html>