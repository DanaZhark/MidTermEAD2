<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>User Page</title>
</head>
<% //In case, if com.User session is not set, redirect to Login page.
    if((request.getSession(false).getAttribute("com.User")== null) )
    {
%>
<jsp:forward page="/jsp/login.jsp"></jsp:forward>
<%} %>
<body style="align-content: center">
<center><h2>User's Home</h2></center>
Welcome <%=request.getAttribute("userName") %>
<button onclick="window.location='${pageContext.request.contextPath}/jsp/game.jsp'">Join to game</button>


<div style="text-align: right"><a href="<%=request.getContextPath()%>/com/LogoutServlet">Logout</a></div>

</body>
</html>
