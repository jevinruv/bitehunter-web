<%-- 
    Document   : add_menu
    Created on : 18-Dec-2017, 10:46:45
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
    <body>
        <div class="container-fluid">
            <div class="row content">

                <%@ include file="sidebar.jsp" %>
                <br>
                <%@ include file="navbar_admin.jsp" %>

                <div class="row">                   
                    <div class="col-sm-8">
                        <h2>Menu</h2>
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
                                <tr>
                                    <td> <input type="number" min="1" class="mealId" style="width:40px;"  required="required"/>  </td>
                                    <td> <input type="text" class="mealName" style="width:50px;" required="required" /> </td>
                                    <td> <input type="number" min="1" class="mealPrice" style="width:50px;" required="required" /></td>
                                    <td><input type='text' class="mealImage" required="required" /></td>
                                    <td><textarea required="required" rows="3" cols="28" class="mealDescription"> </textarea></td>
                                    <td> <input type="button" value="Delete" class="btn btn-danger delete"/> </td>
                                </tr>
                            </table>

                            <p> <input type="button" onclick="addNewRow_addMenu()" class="btn btn-primary" value="New Meal">  </p>
                        </div>



                        <form method="POST" action="new_restaurant_menu_save">
                            <input type="hidden" name="hiddenMenu" id="hiddenMenu"/>
                            Image Path : <input type="text" id="mealImagePath" name="mealImagePath" placeholder="Pictures/..." required="required" />
                            <br><br><p><input type="button" onclick="saveDetails_addMenu()" class="btn btn-warning" value="Save">  </p>
                            <p> <input type="submit" class="btn btn-success" onclick="return formSubmit_addMenu()" value="Submit"/> </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="<c:url value="/resources/js/addMeal.js" />" type="text/javascript"></script>
    </body>
</html>
