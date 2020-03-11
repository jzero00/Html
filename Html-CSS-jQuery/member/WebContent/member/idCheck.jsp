<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = (String) request.getAttribute("resId");
	//입력한 값을 가져온다.
	String inId = (String) request.getAttribute("inId");
	if(id == null){
		//사용 가능		- korea를 입력한 경우
		//json 구간 시작
%>
	{
		"sw" : "<%= inId %> 사용 가능한 ID입니다."
	}
	
<%		
	} else {
		//사용 불가능	- a001을 입력한 경우
		//json 구간 시작
%>	
	{
		"sw" : "<%= inId %> 사용 불가능한 ID입니다."
	}		
<%	
	}
%>