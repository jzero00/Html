<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
h1{
	color : red;
}
span {
	font-size: 1.5em;
	color: green;
}
</style>
</head>
<body>
<h1>JSP : Java Server Page</h1>
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String id = request.getParameter("id");

%>

<%= name %> 님 환영합니다<br>
<%= id %>님의 정보를 소중히 저장하겠습니다.<br>
<span>
즐거운 하루 되십시오
</span>
</body>
</html>