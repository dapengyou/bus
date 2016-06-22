<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="com.city.bus.value.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="addstation.do">
<table width="319" height="204" border="0" align="center" cellpadding="1" cellspacing="1"  bgcolor="#66FF99">
    <tr>
    <td width="91">路线id:</td>
    <td width="168"><input name="stationId" type="text" /></td>
  </tr>
  <tr>
    <td width="91">路线:</td>
    <td width="168"><input name="station" type="text"/></td>
  </tr>
  
   <tr>
    <td width="91">起始时间:</td>
    <td width="168"><input name="startTime" type="text" /></td>
  </tr>
   <tr>
    <td width="91"> 末班时间:</td>
    <td width="168"><input name="endTime" type="text" /></td>
  </tr>
  <tr>
  <td width="168" align="center"><input type="submit" value="添加" /></td>
  </tr>
</table>	
	</form>
</body>
</html>