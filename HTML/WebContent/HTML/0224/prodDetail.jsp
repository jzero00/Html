<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ProdVO vo = (ProdVO) request.getAttribute("prodVO");
%>
{
	"buyer" : "<%= vo.getProd_buyer()%>",
	"color" : "<%= vo.getProd_color()%>",
	"cost" : "<%= vo.getProd_cost()%>",
	"delivery" : "<%= vo.getProd_delivery()%>",
	"detail" : "<%= vo.getProd_detail()%>",
	"id" : "<%= vo.getProd_id()%>",
	"img" : "<%= vo.getProd_img()%>",
	"insdate" : "<%= vo.getProd_insdate()%>",
	"lgu" : "<%= vo.getProd_lgu()%>",
	"name" : "<%= vo.getProd_name()%>",
	"outline" : "<%= vo.getProd_outline()%>",
	"price" : "<%= vo.getProd_price()%>",
	"properstock" : "<%= vo.getProd_properstock()%>",
	"qtyin" : "<%= vo.getProd_qtyin()%>",
	"qtysale" : "<%= vo.getProd_qtysale()%>",
	"sale" : "<%= vo.getProd_sale()%>",
	"size" : "<%= vo.getProd_size()%>",
	"totalstock" : "<%= vo.getProd_totalstock()%>",
	"unit" : "<%= vo.getProd_unit()%>"
}
