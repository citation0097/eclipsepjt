<%@page import="com.hk03.MemberDTO"%>
<%@page import="com.hk03.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDAO dao = MemberDAO.getInstance();
	int checkNum = dao.userCheck(id, pw);
	
	if(checkNum == -1){
%>
	<script language="javascript">
			alert("No id");
			history.go(-1);
	</script>
<% 		
	} else if(checkNum == 0){
%>		
	<script language="javascript">
			alert("No Password");
			history.go(-1);
	</script>
<% 		
	} else if(checkNum == 1){
		MemberDTO dto = dao.getMember(id);
		
		if(dto == null){		
%>
	<script language="javascript">
			alert("No User like");
			history.go(-1);
	</script>
<% 		
		} else{
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");
			response.sendRedirect("main.jsp");
			
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>