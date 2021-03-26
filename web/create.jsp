<%-- 
    Document   : edit
    Created on : Nov 6, 2020, 1:28:03 PM
    Author     : PC
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit page</title>
    </head>
    <body>
        <c:set var="errorObj" value="${requestScope.error}" />
        <h1>EDIT PRODUCT</h1>
        <form action="MainController">
            Product ID: <input type="text" name="id" value=""/>
            <c:if test="${not empty errorObj.id}" >
                <font color ="red" >${errorObj.id} </font>
            </c:if>
            <br/>
            Product Name: <input type="text" name="name" value="" />
            <c:if test="${not empty errorObj.name}" >
                <font color ="red" >${errorObj.name} </font>
            </c:if>
            <br/>
            Quantity: <input type="text" name="quantity" value="" />
            <c:if test="${not empty errorObj.name}" >
                <font color ="red" >${errorObj.name} </font>
            </c:if>
            <br/>
            Description: <textarea name="des" rows="4" cols="50" ></textarea>
            <c:if test="${not empty errorObj.des}" >
                <font color ="red" >${errorObj.des} </font>
            </c:if>
            <br/>
            Price: <input type="text" name="price" value="" />
            <c:if test="${not empty errorObj.price}" >
                <font color ="red" >${errorObj.price} </font>
            </c:if>
            <br/>
            Image: <select name="img">
                <option value="53102_chuot_corsair_iron_claw.jpg">Chuột Corsair</option>
                <option value="ban_phim_choi_game_asus_tuf_k5.jpg">Bàn Phím Asus TUF K5</option>
                <option value="bo_ban_phim_logitech_chuot_mk120_0002_1.jpg">Bộ Bàn Phím Logitech</option>
                <option value="filco_majestouch_2.jpg">Bàn Phím Filco Majestouch</option>
                <option value="ghe_gamer_arena_racer_craftsman.jpg">Ghế Gaming Arena Racer Craftsman</option>
                <option value="keyboard.png">Bàn Phín Steelseries</option>
                <option value="rog_gladius_ii_origin_pnk_ltd_3d_5.png">Chuột ROG</option>
                <option value="tai_nghe_asus_headset_rog_strix_go_2_4_0001_1.jpg">Tai Nghe Asus ROG</option>
                <option value="tai_nghe_zidli1.jpg">Tai Nghe Zidli</option>
                <option value="Tay_Cam_Sony.jpg">Tay Cầm PS Sony</option>
            </select>
            
            <c:if test="${not empty errorObj.img}" >
                <font color ="red" >${errorObj.img} </font>
            </c:if><br/>
            <button type="submit" class="btn btn-primary" value="CREATEPRO" name="action">CREATE</button>
        </form>
    </body>
</html>
