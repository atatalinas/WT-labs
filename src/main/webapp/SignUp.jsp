
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<c:set var="error" value='${requestScope["error"]}' />
<p style = "color:red;">${error}</p>
<form method="post" action = "controller?command=registration">
    <label>Name:
        <input type="text" name="name"><br />
    </label>
    <label>Login:
        <input type="text" name="login"><br />
    </label>
    <label>Password:
        <input type="password" name="password"><br />
    </label>
    <label>Phone number:
        <input type="text" name="phone_number"><br />
    </label>
    <label>Email:
        <input type="email" name="email"><br />
    </label>
    <select name="user_type">
        <option>client</option>
        <option>manager</option>
    </select>
    <button type="submit">Submit</button>
</form>
<a href="controller?command=go_to_auth">login</a>
</body>
</html>
