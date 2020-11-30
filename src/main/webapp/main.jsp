
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<c:set var="user" value='${requestScope["user"]}' />
<p>${user.getName()}</p>
</body>
</html>
