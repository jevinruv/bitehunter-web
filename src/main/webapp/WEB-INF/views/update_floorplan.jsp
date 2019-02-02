<%-- 
    Document   : update_floorplan
    Created on : Jan 25, 2018, 10:00:31 AM
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
    <body onload="initUpdateFloorplan('${restaurantId}')">


        <div class="container-fluid">
            <div class="row content">

                <%@ include file="sidebar.jsp" %>
                <br>
                <%@ include file="navbar_admin.jsp" %>

                <div class="row">
                    <div class="col-sm-5">
                        <div class="well pre-scrollable">

                            <table  id="myTable" class="table table-bordered table-striped table-hover">
                                <thead >
                                    <tr>
                                        <th>Table ID</th>
                                        <th>Top Margin</th>
                                        <th>Left Margin</th>
                                        <th>Manage</th>
                                    </tr>
                                </thead>
                                <tr> </tr>
                            </table>
                        </div>
                        <p> <input type="button" onclick="addNewRow_updateFloorplan()" class="btn btn-warning" value="New Table"> 
                            <input type="button" onclick="saveDetails_updateFloorplan()" class="btn btn-primary pull-right" value="Save">  
                        </p>

                        <form method="POST" action="update_floorplan_save">
                            <input type="hidden" name="floorplan" id="floorplan"/>
                            <input type="hidden" name="restaurantId" id="restaurantId" value='${restaurantId}' />
                            <input type="submit" value="Submit" onclick="return formSubmit_updateFloorplan()" />
                        </form>


                    </div>

                    <div class="floor_plan">
                        <div class="table_vacant" id="t1">T1</div>
                        <div class="table_vacant" id="t2">T2</div>
                        <div class="table_vacant" id="t3">T3</div>
                        <div class="table_vacant" id="t4">T4</div>
                        <div class="table_vacant" id="t5">T5</div>
                        <div class="table_vacant" id="t6">T6</div>
                        <div class="table_vacant" id="t7">T7</div>
                        <div class="table_vacant" id="t8">T8</div>
                        <div class="table_vacant" id="t9">T9</div>
                        <div class="table_vacant" id="t10">T10</div>
                        <div class="table_vacant" id="t11">T11</div>
                        <div class="table_vacant" id="t12">T12</div>
                        <div class="table_vacant" id="t13">T13</div>
                        <div class="table_vacant" id="t14">T14</div>
                        <div class="table_vacant" id="t15">T15</div>
                    </div>

                </div>

            </div>
        </div>             
        <script src="<c:url value="/resources/js/updateFloorplan.js" />" type="text/javascript"></script>

    </body>
</html>
