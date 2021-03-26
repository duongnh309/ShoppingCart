<%-- 
    Document   : errorLogin
    Created on : Nov 7, 2020, 9:58:31 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            body h1{
                color: red;
            }

        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Invalid User ID or Password</h1>
        <form action="MainController" method="post">
            <button type="button" class="btn btn-link" value="tryLogin" name="action">Try Again</button>
            <input type="submit" value="tryLogin" name="action" />
        </form>
    </body>
</html>
