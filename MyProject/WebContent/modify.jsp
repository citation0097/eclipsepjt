<%@page import="com.hk03.MemberDTO"%>
<%@page import="com.hk03.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = (String)session.getAttribute("id");
 	MemberDAO  dao = MemberDAO.getInstance();
 	MemberDTO  dto = dao.getMember(id);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script>
	function goLogin(){
		window.location="login.jsp";
	}
</script>
<script language="javascript" src="member.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="modifyok.do" method="post" name="reg_frm">
		ID: <p> <% %> </p> <br/>
		Password: <input type="password" name="pw"  > <br/>
		Confirm Password <input type="password" name="pw_check"> <br/>
		Name: <% %>
		eMail: <input type="text"  name="eMail" value="<% %>"> <br/>
		address: <input type="text" name="address" value="<% %>"> <br/>
		<input type="button" value="Edit" onclick="updateinfoConfirm()"> &nbsp;&nbsp;
		<input type = "reset" value="cancel" onclick="goLogin()">
	
	</form>

</body>
</html>