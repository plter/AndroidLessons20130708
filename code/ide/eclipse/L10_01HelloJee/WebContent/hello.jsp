<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
out.clear();

String name = request.getParameter("name");
if(name!=null){
	out.print("Hello "+name);
}else{
	out.print("Arg error");
}

%>