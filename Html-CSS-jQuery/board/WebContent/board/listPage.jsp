<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%

List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
int totalp = (Integer) request.getAttribute("totalpage");
int startp = (Integer) request.getAttribute("startpage");
int endp = (Integer) request.getAttribute("endpage");

%>
{
	"totalpage" : "<%= totalp %>",
	"startpage" : "<%= startp %>",
	"endpage"	: "<%= endp %>",
	"data"		: [
<%
	for(int i = 0; i < list.size(); i++){
		BoardVO vo = list.get(i);
		if(i > 0) out.print(",");
%>
{
	"seq" 		: "<%= vo.getSeq() %>",
	"subject" 	: "<%= vo.getSubject() %>",
	"wirter" 	: "<%= vo.getWriter() %>",
	"mail"		: "<%= vo.getMail() %>",
	"wip"		: "<%= vo.getWip() %>",
	"hit"		: "<%= vo.getHit() %>",
	"pass"		: "<%= vo.getPassword() %>",
	"content"	: "<%= vo.getContent() %>",
	"date"		: "<%= vo.getWdate() %>"
}
<%
	}

%>
	
	
	]
}