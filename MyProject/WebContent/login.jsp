<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% if(session.getAttribute("ValidMem") !=null) {
    %>
    	<<jsp:forward page="main.jsp"></jsp:forward>
    <%     	
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<scrtipt src = "jquery.js"></scrtipt>
<script src = "jquery-3.3.1.min.js"></script>    

<scrtipt src = https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.js></scrtipt>
<script >
	$(document).ready(function(){
        $(".ltext").css("border","2px solid");
        $(".mark").css("color","blue");
	});
	
	function gojoin(){
		javascript:window.location='join.jsp';
	}
</script>
<title>HK Book online</title>
</head>
<body>
    <h1 class ="mark">HK member</h1>
	<form action="loginok.do" method="post">
		<div class="mark"> id:</div>&nbsp;<input class="ltext" name="id"  type = "text" value="">
		 <br/>
		<div class="mark">password:</div> &nbsp; <input class = "ltext" type = "password" value=""><br/>
		<input type="submit" value="Log in"> &nbsp;&nbsp;
		<input type="button" value="Member join" onclick="gojoin()">
		
	</form>
</body>
</html>