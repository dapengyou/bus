
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"  import = "java.util.*"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/twoColFixLtHdr.css" rel="stylesheet" type="text/css">
<style type="text/css">
body,td,th {
	font-weight: bold;
	text-align: center;
}
body {
	background-color: #CCC;
}

</style>
<script src="../jquery/jquery.js"></script>
<script type="text/JavaScript">
	$(document).ready(function(){
		//页面载入时隐蔽除第一个元素外所有元素
		$("#accordion > li > a + *:not(:first)").hide();
		//对所有元素的标题绑定点击动作
		$("#accordion > li > a").click(function(){
			$(this).parent().parent().each(function(){
				$("> li > a + *",this).slideUp();  //隐蔽所有元素
			});
			$("+ *",this).slideDown();  //展开当前点击的元素
		});
	});
</script>
</head>
<body>

	
	<dir class="all">
		<div class="header">
			<%@include file="../bus/top.jsp"%>
		</div>
		<div class="footer">
			<%@include file="../bus/footer.jsp"%>
		</div>
		<div class="center">
			<div class="left">
				<%@include file="../bus/left.jsp"%>
	</div>
	<div class="bar" >
      <p style="font-family:'华文新魏'; font-size: x-large;"> 修改公交路线 </p>
         <form method="post" action="modfybus.do">
  				<table border="1px" align="center">
					<tr>
						<td width="100px">路线id</td>
						<td width="100px">路线1</td>
						<td width="100px">路线2</td>
						<td width="100px">起始时间</td>
						<td width="100px">末班时间</td>
						<td width="100px">处理</td>
					</tr>
			<c:forEach var="pi" items="${buslist}">
					
					<tr>
					<td>${pi.stationId}</td>
					<td>${pi.stationA}</td>
					<td>${pi.stationB}</td>
					<td>${pi.startTime}</td>
					<td>${pi.endTime}</td>
					<td><a style="background:rgb(56,212,53);
					color:#fff" href="remodfybus.do?stationId=${pi.stationId}
					&stationA=${pi.stationA}&stationB=${pi.stationB}
					&startTime=${pi.startTime}&endTime=${pi.endTime}">修改</a>
					</td>
					</tr>
					</c:forEach>		

</table>

</form>
   
		
  </div>
    
  </div>	
  </div>
		
	</dir>
</body>
</html>