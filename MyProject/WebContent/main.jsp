<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>%
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	if(session.getAttribute("ValidMem") == null){
%>
	<<jsp:forward page ="login.jsp" />
<%
	}
	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
%>
<script type="text/javascript">
	function gomodify(){
		window.location ="modify.jsp";
	}
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> Hello <%= name %></h1> <br/>
	<form action="logout.do" method="post">
		<input type="submit" value="logout">&nbsp; &nbsp; <input type="button" value="Member Edit" onclick ="gomodify()">
	</form>
</body>
</html>