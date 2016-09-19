
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Game Code</th>
        <th>Log Date</th>
        <th>Server ID</th>
        <th>Account</th>
        <th>Charge AMT</th>
        <th>Register Date</th>
    </tr>
    <c:forEach var="data" items="${data}" varStatus="status">
        <tr>
            <td><c:out value="${data.gameCode}"/></td>
            <td><c:out value="${data.logDate}"/></td>
            <td><c:out value="${data.serverId}"/></td>
            <td><c:out value="${data.account}"/></td>
            <td><c:out value="${data.chargeAmt}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
