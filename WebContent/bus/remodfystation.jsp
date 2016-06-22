<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="modfystationagain.do">
 
   	路线id：<input name="stationId" type="text" value="${pi.stationId}"/><br/>
    路线：<input name="station" type="text" value="${pi.station}"/><br/>
    起始时间：<input name="startTime" type="text" value="${pi.startTime}"/><br/>
    末班时间：<input name="endTime" type="text" value="${pi.endTime}"/><br/>
	<input type="submit" value="修改"/>
	
	</form>
</body>
</html>