<%@ page import="com.hk03.MemberDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hk03.MemberDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// MemberDAO memDAO = new MemberDAO();
    MemberDAO memDAO = MemberDAO.getInstance();
    ArrayList<MemberDTO> dtos = memDAO.membersAll();
    
    for(int i=0; i<dtos.size() ; i++){
    	MemberDTO dto = dtos.get(i);
    	String name = dto.getName();
    	String id   = dto.getId();
    	String pw  = dto.getPw();
    	String phone = dto.getPhone();
    	String gender = dto.getGender();
    	
    	out.println("name:" + name + "/ ID:" + id + "/ PassWord " + pw + "/ PhoneNumber" + phone + "/ Gender" + gender + "<br />");
    }
    
    
%>
</body>
</html>