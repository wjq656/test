<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="XX" uri="/WEB-INF/tld/wjq.tld"%>
<%
	String path = request.getContextPath();
	int port = request.getServerPort();
	String basePath = null;
	if(port==80){
		basePath = request.getScheme()+"://"+request.getServerName()+path;
	}else{
		basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	}
	//http://localhost:8080/admin 
	pageContext.setAttribute("basePath", basePath); 

%>
