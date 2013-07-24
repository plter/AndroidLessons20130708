<%@page import="cn.eoe.usingrc.MyServer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

MyServer s = new MyServer();
s.handle(request, response);
%>