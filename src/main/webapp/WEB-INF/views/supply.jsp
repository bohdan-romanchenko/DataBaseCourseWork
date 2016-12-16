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

<form class="form-login" method="POST" action='/supply/${operation}'>

    <div class="form-log-in-with-email">

        <div class="form-white-background">
            <div class="form-title-row">
                <h1>Supply</h1>
            </div>
            <div class="form-row">
                <label>
                    <span>ID</span>
                    <input type="text" name="id"
                           value="<c:out value="${supply.id}"/>"
                           readonly="readonly"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>BILL DATE</span>
                    <input type="text" name="billDate" value="<c:out value="${supply.billDate}" />"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>BEET SUPPLIED</span>
                    <input type="text" name="beetEstimated"
                           value="<c:out value="${supply.beetEstimated}" />"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>SUGAR ESTIMATED</span>
                    <input type="text" name="sugarEstimated"
                           value="<c:out value="${supply.sugarEstimated}" />"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>BAGASSE ESTIMATED</span>
                    <input type="text" name="bagasseEstimated"
                           value="<c:out value="${supply.bagasseEstimated}" />"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>AGENT</span>
                    <input type="text" name="agent"
                           value="<c:out value="${supply.agent}" />"/>
                </label>
            </div>

            <button type="submit">SUBMIT</button>
        </div>
    </div>
</form>
</body>
</html>