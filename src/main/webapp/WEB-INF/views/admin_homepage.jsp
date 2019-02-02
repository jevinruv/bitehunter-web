<%-- 
    Document   : admin_homepage
    Created on : Jan 16, 2018, 8:53:06 PM
    Author     : Jevin
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bitehunter Home</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>

        <%@ include file="navbar_admin.jsp" %>

        <div class="container">    
            <div class="row">
                <div class="col-sm-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">ADD NEW RESTAURANT</div>
                        <div class="panel-body">
                            <a href="new_restaurant" title="">
                                <img src="<c:url value="/resources/images/restaurant.jpeg" />" alt="restaurant" style="width:100%;" class="img-responsive">
                            </a>
                        </div>
                        <div class="panel-footer">Total Restaurants : 5 </div>
                    </div>
                </div>

                <div class="col-sm-4">
                    <h4> Restaurants </h4>
                    <table  id="myTable" class="table table-bordered table-striped table-hover">
                        <thead >
                            <tr>
                                <th>Restaurant ID</th>
                                <th>Name</th>
                                <th>Open</th>
                                <th>Close</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>The Commons</td>
                                <td>9am</td>
                                <td>11pm</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Tea Avenue</td>
                                <td>7am</td>
                                <td>12pm</td>
                            </tr>
                        </tbody>
                    </table>
                </div>           
            </div>
        </div>


        <div class="container">    
            <div class="row">
                <div class="col-sm-3">
                    <div class="panel panel-primary">
                        <div class="panel-heading">VIEW RESERVATIONS</div>
                        <div class="panel-body"><img src="<c:url value="/resources/images/reservations.jpeg" />" alt="reservations" style="width:100%;" class="img-responsive"></div>
                        <div class="panel-footer">
                            <form method="POST" action="view_reservations">
                                <input type="number" name="restaurantId" placeholder="Restaurant Id" required="required">
                                <input type="submit" >
                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-sm-3">
                    <div class="panel panel-primary">
                        <div class="panel-heading">UPDATE FLOOR PLAN</div>
                        <div class="panel-body"><img src="<c:url value="/resources/images/table.jpg" />" alt="table" style="width:100%;" class="img-responsive"></div>
                        <div class="panel-footer">
                            <form method="POST" action="update_floorplan">
                                <input type="number" name="restaurantId"  placeholder="Restaurant Id" required="required">
                                <input type="submit" >
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3"> 
                    <div class="panel panel-primary">
                        <div class="panel-heading">UPDATE MENU</div>
                        <div class="panel-body"><img src="<c:url value="/resources/images/meal.jpg" />" alt="meal" style="width:100%;" class="img-responsive"></div>
                        <div class="panel-footer">
                            <form method="POST" action="update_menu">
                                <input type="number" name="restaurantId"  placeholder="Restaurant Id" required="required">
                                <input type="submit" >
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div><br>


    </body>
</html>