<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/static/tab.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Show All supply</title>
</head>
<body>
<c:if test="${exception != null}">
    <p>${exception}</p>
</c:if>

<table border=1>
    <thead>
    <tr>
        <th>ID</th>
        <th>BILL DATE</th>
        <th>BEET SUPPLIED</th>
        <th>SUGAR ESTIMATED</th>
        <th>BAGASSE ESTIMATED</th>
        <th>AGENT</th>
        <th colspan=2>ACTION</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${supplys}" var="supply">
        <tr>
            <td><c:out value="${supply.id}"/></td>
            <td><c:out value="${supply.billDate}"/></td>
            <td><c:out value="${supply.beetEstimated}"/></td>
            <td><c:out value="${supply.sugarEstimated}"/></td>
            <td><c:out value="${supply.bagasseEstimated}"/></td>
            <td><c:out value="${supply.agent}"/></td>

            <td><a href="/supply/preUpdate?id=<c:out value="${supply.id}"/>">Update</a></td>
            <td><a href="/supply/delete?id=<c:out value="${supply.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p><a href="/supply/preInsert">Add supply</a></p>
</body>
</html>