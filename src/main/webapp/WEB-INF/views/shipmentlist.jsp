<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/static/tab.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Show All subjects</title>
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
        <th>SUGAR SHIPPED</th>
        <th>BAGASSE SHIPPED</th>
        <th>SUPPLY</th>
        <th>AGENT</th>
        <th colspan=2>ACTION</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${shipments}" var="shipment">
        <tr>
            <td><c:out value="${shipment.id}"/></td>
            <td><c:out value="${shipment.billDate}"/></td>
            <td><c:out value="${shipment.sugarShipped}"/></td>
            <td><c:out value="${shipment.bagasseShipped}"/></td>
            <td><c:out value="${shipment.supply}"/></td>
            <td><c:out value="${shipment.agent}"/></td>

            <td><a href="/shipment/preUpdate?id=<c:out value="${shipment.id}"/>">Update</a></td>
            <td><a href="/shipment/delete?id=<c:out value="${shipment.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p><a href="/shipment/preInsert">Add shipment</a></p>
</body>
</html>