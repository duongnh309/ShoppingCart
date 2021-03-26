<%-- 
    Document   : login
    Created on : Oct 31, 2020, 3:40:39 PM
    Author     : PC
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <c:set var="errorObj" value="${requestScope.ErrorObj}" />
        <h1>Welcome to our page</h1>
        <form action="MainController" method="POST">
            <input type="text" name="idUser" value="" placeholder="User ID"/>
            <c:if test="${not empty errorObj.idError}" >
                <font color ="red" >${errorObj.idError} </font>
            </c:if>
            <br/>
            <input type="password" name="pass" value="" placeholder="Password"/>
            <c:if test="${not empty errorObj.passError}" >
                <font color ="red" >${errorObj.passError} </font>
            </c:if>
            <br/>
             <c:if test="${not empty errorObj.error}" >
                <font color ="red" >${errorObj.error} </font>
            </c:if>
            <br/>
            <button type="submit" class="btn btn-info" value="LOGIN" name="action" >Login</button>
            <button type="submit" class="btn btn-danger" value="REGISTER" name="action">Register</button>
        </form>
    </body>
</html>
