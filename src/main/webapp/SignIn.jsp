
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<c:set var="error" value='${requestScope["error"]}' />
<p style = "color:red;">${error}</p>
<c:set var="login" value='${requestScope["login"]}' />
<form method="post" action = "controller?command=authorization">
    <label>Login:
        <input type="text" name="login" value="${login}"><br />
    </label>
    <label>Password:
        <input type="password" name="password"><br />
    </label>
    <button type="submit">Submit</button>
</form>
<a href="controller?command=go_to_registration">register</a>
</body>
</html>
