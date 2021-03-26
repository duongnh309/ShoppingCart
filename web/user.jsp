<%-- 
    Document   : admin
    Created on : Nov 3, 2020, 4:26:09 PM
    Author     : PC
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <h1>BUY YOUR PRODUCTS</h1>

        <form action="MainController">
            <button type="submit" class="btn btn-primary" value="LOGOUT" name="action" style="float: right" >LOGOUT</button>
            <button type="submit" class="btn btn-outline-warning" value="ViewCart" name="action" >VIEW YOUR CART</button><br/>
        </form>
        <c:if test="${not empty requestScope.QuantityError}" >
            <font color ="red" >${requestScope.QuantityError} </font>
        </c:if>

        <table width="600px" border="1px solid" >
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Description</th>
                <th>Price</th>
                <th>Image</th>
                <th></th>
            </tr>
            <tbody>
                <c:forEach var="line" items="${data}" >
                <form action="MainController" method="POST">

                    <tr>
                        <td>${line.idProduct} </td>
                        <td>${line.nameProduct}</td>
                        <td>${line.quantity}</td>
                        <td>${line.description}</td>
                        <td>${line.price}</td>
                        <td><img src="Image/${line.image}" alt="" border="3" height="100" width="100" /></td>
                        <td>
                            <button type="submit" class="btn btn-success" value="BUY" name="action" >BUY</button>
                            <input type="hidden" name="txtProId" value="${line.idProduct}" />
                        </td>
                    </tr>
                </form>

            </c:forEach>

        </tbody>
    </table>
</body>
</html>
