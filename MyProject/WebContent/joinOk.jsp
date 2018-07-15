<%@page import="com.hk03.MemberDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page  %>
<jsp:useBean id="dto" class="com.hk03.MemberDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	dto.setrDate(new Timestamp(System.currentTimeMillis()));
    MemberDAO dao = MemberDAO.getInstance();
    if(dao.confirmId(dto.getId()) == MemberDAO.MEMBER_EXISTENT) {

%>
    <script language="javascript">
    	alert("Id already exigst");
    	history.back();
    </script>

<%
    } else{
    	int rtn = dao.insertMember(dto);
    	if(rtn == MemberDAO.MEMBER_JOIN_SUCCESS){
    		session.setAttribute("id", dto.getId());
 %>
    <script language="javascript">
		alert("your are sucessed to register member");
		document.location.href="login.jsp"
    </script>
 <%    		
    	}else{
  %>   		
  
     <script language="javascript">
		alert("your are failed to register member");
		document.location.href="login.jsp"
    </script>
 <%    
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