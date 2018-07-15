<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<scrtipt src = "jquery.js"></scrtipt>
<script src = "jquery-3.3.1.min.js"></script>  
<script srr = "members.js"></script>
<script type="text/javascript">
	$(function(){
		$(".btn").on({"mouseover":function(){console.log("mouseover")}},{"focus":function(){console.log("welcome")}});
	});
    function gologin(){
    	javascript:window.location='login.jsp';
    }
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="joinok.do" method="post" name="reg_frm">
		ID: <input type="text" name="id"> <div id="divid"></div><br />
		Password:<input type="password" name="pw"><div id="divpw"></div> <br />
		Confirm Password:<input teyp="password" name="pw_check"> <br />
		Name: <input type="text" name="name"> <br />
		eMail: <input type="text" name="eMail"> <br />
		Address:<input type="text" name="address"> <br />
		Phone:<select name="phone1">
				  <option value="010">010</option>
				  <option value="070">070</option>
				  <option value="011">011</option>
			 </select> <br />
		     <input type="text" name="phone2"> <br />
		     <input type="text" name="phone3"> <br />
		     
	    Gender: <input class ="gender" type="radio" value="man">Man 
	            <input class ="gender" type="radio" value="woman">Woman <br />
	    <input type="button" class="btn" value="Member regist" onclick="infoConfirm()"> &nbsp;&nbsp;
	    <input type="reset"  class ="btn" value="Cancel" onclick="gologin()">
	
	</form>

</body>
</html>