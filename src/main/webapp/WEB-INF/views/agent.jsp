<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/static/insert.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add new Budgetary Institution</title>
</head>
<body>
<%String operation = (String) request.getAttribute("operation");%>

<form class="form-login" method="POST" action='/agent/${operation}'>

    <div class="form-log-in-with-email">

        <div class="form-white-background">
            <div class="form-title-row">
                <h1>Budgetary Institution</h1>
            </div>

            <div class="form-row">
                <label>
                    <span>ID</span>
                    <input type="text" name="id" value="<c:out value="${agent.id}" />">
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>NAME</span>
                    <input type="text" name="name" value="<c:out value="${agent.name}" />"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>ADDRESS</span>
                    <input type="text" name="address" value="<c:out value="${agent.address}" />"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>BANK DETAILS</span>
                    <input type="text" name="bankDetails" value="<c:out value="${agent.bankDetails}" />"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>REST SUGAR</span>
                    <input type="text" name="restSugar" value="<c:out value="${agent.restSugar}" />"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>REST BAGASSE</span>
                    <input type="text" name="restBagasse" value="<c:out value="${agent.restBagasse}" />"/>
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