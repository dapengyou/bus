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

  <form action="regsiter.do" method="post" enctype="multipart/form-data">
<table width="319" height="204" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#66CCFF">
  <tr>
    <td>用户名</td>
    <td><input name="username" type="text"/></td>
  </tr>
  <tr>
    <td>密码</td>
    <td><input name="password" type="password"/></td>
  </tr>
 <tr>
    <td>权限</td>
    <td><input name="power" type="radio" value="common"/>common<input name="power" type="radio" value="system"/>system</td>
  </tr>
  <tr>
    <td>年龄</td>
    <td><input name="age" type="text"/></td>
  </tr>
  <tr>
    <td>性别</td>
    <td><input name="sex" type="radio" value="girl"/>girl<input name="sex" type="radio" value="boy"/>boy</td>
  </tr>
  
  
  <tr>

    <td width="100"  align="center"><input type="submit" value="确定" /></td>
   
    <td width="100"  align="center"><input type="submit" value="取消" /></td>
  </tr>
</table>
 </form>
</body>
</html>