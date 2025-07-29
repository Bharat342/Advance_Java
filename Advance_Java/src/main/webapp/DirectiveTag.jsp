
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--  <%@ page import = "java.util.Date"%>  <!-- Directive tag in 2 lines we can do it in 1 line by using comma(,) seperated -->
 <%@ page import = "java.util.ArrayList" %> --%>
 
 <%@ page import = "java.util.Date, java.util.ArrayList, java.util.LinkedList" %>
 
 <%@ include file= "hello.txt" %>
    
	<!--  Directive tag  -->
	 <!-- -> a. Page directive tag --> <!-- it is responsible for performing import -->
	 <!-- -> b. include directive tag -->  <!-- imports content of one file into another  // but the file which we want to include/ import should in the same 
	 webApp/ same package only-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directive Tag</title>
</head>
<body>

	<%=
	new Date() // --> expression tag
	%> 
	
	<% out.print("<br/>"); %>
	
	<% 
		ArrayList arr = new ArrayList();
		LinkedList lk = new LinkedList();
	%>
</body>
</html>