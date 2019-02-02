<%-- 
    Document   : update_menu
    Created on : Dec 16, 2017, 7:04:43 PM
    Author     : Ludowica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bitehunter</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>" rel="stylesheet" >
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/table_styles.css" />" rel="stylesheet">

        <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"/>"></script>
        <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>"></script>

    </head>
    <body onload="initUpdateMenu('${restaurantId}')">


        <div class="container-fluid">
            <div class="row content">

                <%@ include file="sidebar.jsp" %>
                <br>
                <%@ include file="navbar_admin.jsp" %>

                <div class="row">
                    <div class="col-sm-8">
                        <div class="well">

                            <table  id="myTable" class="table table-bordered table-striped table-hover">
                                <thead >
                                    <tr>
                                        <th>Meal ID</th>
                                        <th>Meal Name</th>
                                        <th>Meal Price</th>
                                        <th>Meal Image</th>
                                        <th>Meal Description</th>
                                        <th>Manage</th>
                                    </tr>
                                </thead>
                                <tr> </tr>
                            </table>
                        </div>
                        <p> <input type="button" onclick="addNewRow_updateMenu()" class="btn btn-warning" value="New Meal"> 
                            <input type="button" onclick="saveDetails_updateMenu()" class="btn btn-primary pull-right" value="Save">  
                        </p>

                        <form method="POST" action="update_menu_save">
                            <input type="hidden" name="menu" id="menu"/>
                            <input type="hidden" name="restaurantId" id="restaurantId" value='${restaurantId}' />
                            <input type="submit" value="Submit"/>
                        </form>

                    </div>

                </div>

            </div>
        </div>             
        <script src="<c:url value="/resources/js/updateMenu.js" />" type="text/javascript"></script>

    </body>
</html>
