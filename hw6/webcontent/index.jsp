<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix=""%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Index</title>

    <style type="text/css">
        *{
            margin: 10px;
        }
    </style>
</head>
<body>
<form action="RegistrationServlet" method="post">

    <label for="firstName">First Name:</label><input name="firstName">
    <br>
    <label for="lastName">Last Name:</label><input name="lastName">
    <br>
    <label for="email">Email :</label><input name="email">
    <br>
    <label for="password">Password :</label><input name="password">
    <br>
    <input type="submit" value="submit">
</form>
</body>
</html>