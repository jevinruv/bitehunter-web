<%-- 
    Document   : login
    Created on : 14-Oct-2017, 07:58:04
    Author     : Ludowica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BiteHunter Webpage</title>
        <link href="<c:url value="/resources/css/style_1.css" />" rel="stylesheet">
    </head>
    <body background="<c:url value="/resources/images/background.png" />" >
    <center>
        <div class="login-container">

            <h1>Welcome to BiteHunter</h1>
            <button onclick="document.getElementById('id01').style.display = 'block'" style="width:auto;">Login</button>

        </div>
    </center>
    <div id="id01" class="modal">

        <form:form class="modal-content animate" action="login" method="POST" modelAttribute="user">
            <div class="imgcontainer">
                <span onclick="loginClicked()" class="close" title="Close Modal">&times;</span>
                <img src="<c:url value="/resources/images/avatar.png" />" alt="Avatar" class="avatar">
            </div>
            <center>
                <div class="container">
                    <form:input path="username" type="text" placeholder="Username" required="required" /><br>
                    <form:input path="password" type="password" placeholder="Password" required="required" /> <br>
                    <button type="submit">Login</button>
                </div>
            </center>

            <div class="container" style="background-color:#f1f1f1">
                <button type="button" onclick="cancelClicked()" class="cancelbtn">Cancel</button>
                <span class="psw"> <a href="#">Forgot Password?</a></span>
            </div>
        </form:form>
    </div>

    <script src="<c:url value="/resources/js/loginHelper.js" />" type="text/javascript"></script>

</body>
</html>
