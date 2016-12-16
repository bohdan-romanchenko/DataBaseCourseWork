<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/static/tab.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Budgetary institutions</title>
</head>
<body>
<c:if test="${exception != null}">
    <p>${exception}</p>
</c:if>

<table border=1>
    <thead>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>ADDRESS</th>
        <th>BANK DETAILS</th>
        <th>REST SUGAR</th>
        <th>REST BAGASSE</th>
        <th colspan=2>ACTION</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${agent}" var="agent">
        <tr>
            <td><c:out value="${agent.id}"/></td>
            <td><c:out value="${agent.name}"/></td>
            <td><c:out value="${agent.address}"/></td>
            <td><c:out value="${agent.bankDetails}"/></td>
            <td><c:out value="${agent.restSugar}"/></td>
            <td><c:out value="${agent.restBagasse}"/></td>

            <td><a href="/agent/preUpdate?id=<c:out value="${agent.id}"/>">Update</a></td>
            <td><a href="/agent/delete?id=<c:out value="${agent.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p><a href="/agent/preInsert">Add AGENT</a></p>
</body>
</html>