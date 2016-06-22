<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

<form method="post" action="login.do">
<table width="319" height="204" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#66FF99">
  <tr>
    <td width="91">用户名</td>
    <td width="168"><input name="username" type="text"/></td>
  </tr>
  <tr>
    <td>密码</td>
    <td><input name="password" type="password"/></td>
  </tr>
  <tr>
  
    <td width="91" align="center"><a href = "regsiter.jsp">注册</a></td>
 
    <td width="168" align="center"><input type="submit" value="确定" /></td>
    <td width="50" align="center"><a href = "login.jsp">取消</a></td>
  
  </tr>
</table>
</form>
</body>
</html>