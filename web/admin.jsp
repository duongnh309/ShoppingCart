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
        <title>Admin</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <h1>ADMIN PAGE</h1>
        <form action="MainController" method="post">
               <button type="submit" class="btn btn-primary" value="LOGOUT" name="action" style=" float: right" >LOGOUT</button>
               
               <button type="submit" class="btn btn-outline-warning" value="CREATE" name="action" >CREATE A PRODUCT</button>
            <table width="600px" border="1px solid" >
                <tr>
                    <th>Product ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th>Quantity</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach var="line" items="${data}" >
                    <tbody>
                        <tr>
                            <td>${line.idProduct} </td>
                            <td>${line.nameProduct}</td>
                            <td>${line.description}</td>
                            <td>${line.price}</td>
                            <td><img src="Image/${line.image}" alt="" border="3" height="100" width="100" /></td>
                            <td>${line.quantity}</td>
                            <td>
                                <button type="submit" class="btn btn-secondary" value="EDIT" name="action">EDIT</button>
                                <input type="hidden" name="txtProId" value="${line.idProduct}" />
                            </td>
                            <td>
                                <a href="MainController?action=DELETE&id=${line.idProduct}">DELETE</a>
                            </td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
