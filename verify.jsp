<%-- 
    Document   : verify.jsp
    Created on : Oct 10, 2023, 11:42:15 AM
    Author     : SONY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Page</title>
    </head>
    <body>
        <h1>We already sent a verification code to your email.</h1>
        <form action="VerifyCode" method="post">
            <input type="text" name="authcode">
            <input type="submit" value="verify">
        </form>
    </body>
</html>
