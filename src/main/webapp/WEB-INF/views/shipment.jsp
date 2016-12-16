<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/static/insert.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add new user</title>
</head>
<body>
<%String operation = (String) request.getAttribute("operation");%>

<form class="form-login" method="POST" action='/shipment/${operation}'>
    <div class="form-log-in-with-email">

        <div class="form-white-background">
            <div class="form-title-row">
                <h1>shipment</h1>
            </div>
            <div class="form-row">
                <label>
                    <span>ID</span>
                    <input type="text" name="id"
                           value="<c:out value="${shipment.id}" />" <%--readonly="readonly"--%>/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>BILL DATE</span>
                    <input type="text" name="billDate" value="<c:out value="${shipment.billDate}" />"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>SUGAR SHIPPED</span>
                    <input type="text" name="sugarShipped"
                           value="<c:out value="${shipment.sugarShipped}" />"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>BAGASSE SHIPPED</span>
                    <input type="text" name="bagasseShipped"
                           value="<c:out value="${shipment.bagasseShipped}" />"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>SUPPLY</span>
                    <input type="text" name="supply" value="<c:out value="${shipment.supply}" />"/> <br/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>AGENT</span>
                    <input type="text" name="agent" value="<c:out value="${shipment.agent}" />"/> <br/>
                </label>
            </div>
            <div class="form-row">
            <label>
                <button type="submit">SUBMIT</button>
            </label>
        </div>
        </div>
    </div>
</form>
</body>
</html>