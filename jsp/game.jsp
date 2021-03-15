<%--
  Created by IntelliJ IDEA.
  com.User: MI
  Date: 15.03.2021
  Time: 5:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.User" %>
<%@page import="com.dao.Dao" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>Game</title>
</head>
<body>

<table>
    <tr>
        <th>Username</th>
        <th>Balance</th>
    </tr>
    <%
        // Iterating through subjectList
        ArrayList<User> liveUsers = Dao.liveUsers;
        if (request.getAttribute("liveUsers") != null)  // Null check for the object
        {
            for (User user : liveUsers) {
    %>
    <tr>
        <td><%=user.getUserName()%>
        </td>
        <td><%=user.getBalance()%>
        </td>
    </tr>
    <%
            }


        }
    %>
</table>
</body>
</html>
