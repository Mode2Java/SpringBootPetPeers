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
 <style type="text/css">
.dark_overlay {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity = 80);
}

.bright_content {
	display: none;
	position: absolute;
	top: 25%;
	left: 25%;
	width: 50%;
	height: 50%;
	padding: 16px;
	border: 5px solid #C5D1E2;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}
</style>      
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
<b></b><a href="/login">Logout	</a></b></br></br>
<center> <a href="javascript:void(0)" onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">AdvanceSearch</a></center> 
<tr><th>Sr No<th>PET ID</th><th>PET NAME</th><th>PET AGE</th><th>PET PLACE</th><th>ACTION</th></tr>

<c:forEach items="${pagedListHolder.pageList}" var="temp" varStatus="status">
					
                    <tr>
                    	<td>${status.index + 1}</td>  
                    	<td>${temp.petId}</td>
                        <td>${temp.petName}</td>
                        <td>${temp.petAge}</td>
                        <td>${temp.petPlace}</td>
                       <%-- <td>${temp.ownerId}</td> --%>
                        <td><input type="button" id="buy" value="BUY" onclick="disableFunction()"> 
                       <!--  <script>
function disableFunction(){
	document.getElementById("buy").value='SOLD';
	
}	 -->
</script>  
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
<table>
 		<tr>
    <form id="form1" action="/pet/advanceSearch" method="post" modelAttribute="pet">
        <p>
        
        </p>
 			<div id="light" class="bright_content">
            <asp:Label ID="lbltext" runat="server" Text="Hey there!"></asp:Label>
            <a href="javascript:void(0)" onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">Close</a>       
 		
 		<center><h2>Advance Search</h2></center>
 		
 		
 		<div>
 			<label for="petname">Pet Name:
				<input type="text" id="petname" name="petname" minlength="4" maxlength="8" size="10"></label>
 			 <label for="petAge">Age:
				<input type="text" id="petAge" name="petAge" minlength="4" maxlength="8" size="10"></label>  
 			<label for="petplace">Place:
				<input type="text" id="petplace" name="petplace"  minlength="4" maxlength="8" size="10"></label><br><br>
			
			<label for="search">Search
				<input type="submit" id="search" name="search"></label><br><br>
 		</div>
 		</tr>
         </table>  
        </div>
        <div id="fade" class="dark_overlay">
        </div>
    </form>
</body>

</html>