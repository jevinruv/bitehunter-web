<%-- 
    Document   : add_floorplan
    Created on : Dec 16, 2017, 9:52:43 AM
    Author     : Jevin
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
    <body onload="initAddFloorplan()">


        <div class="container-fluid">
            <div class="row content">

                <%@ include file="sidebar.jsp" %>
                <br>
                <%@ include file="navbar_admin.jsp" %>

                <div class="row">
                    <div class="col-sm-5">
                        <h2>Floor Plan</h2>
                        <div class="well">


                            <table  id="myTable" class="table table-bordered table-striped table-hover">
                                <thead >
                                    <tr>
                                        <th>Table ID</th>
                                        <th>Top Margin</th>
                                        <th>Left Margin</th>
                                        <th>Manage</th>
                                    </tr>
                                </thead>
                                <tr>
                                    <td> <input type="number" min="1" class="tableID" style="width:40px;"  required="required"/>  </td>
                                    <td> <input type="text" class="topMargin" style="width:50px;" required="required" /> px </td>
                                    <td> <input type="text" class="leftMargin" style="width:50px;" required="required" /> px </td>
                                    <td> <input type="button" value="Apply" class="btn btn-success apply"/> 
                                        &nbsp;  <input type="button" value="Delete" class="btn btn-danger delete"/> </td>
                                </tr>
                            </table>

                            <p> <input type="button" onclick="addNewRow_addFloorplan()" class="btn btn-primary" value="New Table">  </p>
                        </div>

                        <p> <input type="button" onclick="saveDetails_addFloorplan()" class="btn btn-warning" value="Save">  </p>

                        <form method="POST" action="new_restaurant_floorplan_save">
                            <input type="hidden" name="hiddenArrayField" id="hiddenArrayField"/>
                            <input type="submit" value="Submit" class="btn btn-success" onclick="return formSubmit_addFloorplan()"/>
                        </form>

                    </div>

                    <div class="floor_plan">
                        <div class="table_vacant" id="t1">T1</div>
                        <div class="table_vacant" id="t2">T2</div>
                        <div class="table_vacant" id="t3">T3</div>
                        <div class="table_vacant" id="t4">T4</div>
                        <div class="table_vacant" id="t5">T5</div>
                        <div class="table_vacant" id="t6">T6</div>
                        <div class="table_vacant" id="t6">T7</div>
                        <div class="table_vacant" id="t6">T8</div>
                        <div class="table_vacant" id="t6">T9</div>
                        <div class="table_vacant" id="t6">T10</div>
                    </div>

                </div>

            </div>
        </div>             
        <script src="<c:url value="/resources/js/addFloorplan.js" />" type="text/javascript"></script>
    </body>
</html>
