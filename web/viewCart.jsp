<%-- 
    Document   : viewCart
    Created on : Nov 7, 2020, 1:32:24 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CART Page</title>
    </head>
    <body>
        <h1>YOUR CART</h1>
        <form action="MainController" method="POST">
            <c:set var="cart" value="${sessionScope.CART}"/>
            <table border="1">
                <thead>
                    <tr>
                        <th>N0</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${requestScope.LISTCART}" varStatus="counter" >
                    <form action="MainController" >
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.nameProduct}</td>
                            <td>${dto.price}</td>
                            <td>${cart[dto.idProduct]}</td>
                            <td><button type="submit" class="btn btn-primary" value="SUBJECT" name="action">-</button>
                                <input type="hidden" name="txtProID" value="${dto.idProduct}" />
                            </td>
                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
            PaymentMethod : <select name="selection">
                <option>CASH</option>
                <option>MOMO</option>
                <option>VISA/MASTERCARD</option>
            </select><br/>
            TOTAL: ${sessionScope.TOTAL}
            <br/>

            <button type="submit" class="btn btn-secondary" value="confirm" name="action" >Proceed to checkout</button>
            <button type="submit" class="btn btn-outline-primary" value="Back" name="action">Continue Shopping</button>
        </form>
    </body>
</html>
