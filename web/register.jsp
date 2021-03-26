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
        <title>Register page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <c:set var="errorObj" value="${requestScope.ErrorObj}" />
        <h1>REGISTER YOUR ACCOUNT</h1>
        <form action="RegisterController" method="POST">
            <input type="text" name="idUser" value="" placeholder=" User ID"/>
            <c:if test="${not empty errorObj.idError}" >
                <font color ="red" >${errorObj.idError} </font>
            </c:if>
            <br/>
            <input type="text" name="name" value="" placeholder=" Fullname"/>
            <c:if test="${not empty errorObj.fullname}" >
                <font color ="red" >${errorObj.fullname} </font>
            </c:if>
            <br/>
            <input type="password" name="pass" value="" placeholder=" Password"/>
            <c:if test="${not empty errorObj.passError}" >
                <font color ="red" >${errorObj.passError} </font>
            </c:if>
            <br/>
            <input type="password" name="pass2" value="" placeholder=" Retype Password"/>
            <c:if test="${not empty errorObj.pass2Error}" >
                <font color ="red" >${errorObj.pass2Error} </font>
            </c:if>
            <br/>
            <button type="submit" class="btn btn-danger" value="REGISACC" name="action">Register Account</button>
        </form>
    </body>
</html>
