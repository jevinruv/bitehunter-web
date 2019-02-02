var host = 'http://bitehunter.vimly.ml/database_operations/webapp/';

function initUpdateMenu(restaurantId) {

    $.ajax({
        url: host + 'get_restaurant_menu.php',
        type: 'POST',
        data: {restaurant_id: restaurantId},
        dataType: 'json',
        success: function (rows)
        {
            var mealsJson = rows['meal_data'];
            for (var i in mealsJson)
            {
                var row = mealsJson[i];
                var meal_id = row['meal_id'];
                var meal_name = row['meal_name'];
                var meal_price = row['meal_price'];
                var meal_image = row['meal_image'];
                var meal_description = row['meal_description'];

                addRow(meal_id, meal_name, meal_price, meal_image, meal_description);
            }
        },
        error: function (request, status, error) {
            //alert("Error: " + status);
        }
    });
}


$('#myTable').on('click', '.delete', function () {

    $(this).closest('tr').remove();
});



function saveDetails_updateMenu() {

    var menuData = new Array();
    var fullData = new Array();
    var emptyCount = 0;


    $('tr').each(function () {
        if (
                $(this).find('.mealId').val() === "" ||
                $(this).find('.mealName').val() === "" ||
                $(this).find('.mealPrice').val() === "" ||
                $(this).find('.mealImage').val() === "" ||
                $(this).find('.mealDescription').val() === "" 
                )
        {
            emptyCount++;
        }
    });


    if (emptyCount > 0) {
        alert("Menu Table is Empty");
    } else {
        $('#myTable tr').each(function (row, tr) {
            menuData[row] = {
                "mealId": $(tr).find('.mealId').val(),
                "mealName": $(tr).find('.mealName').val(),
                "mealPrice": $(tr).find('.mealPrice').val(),
                "mealImage": $(tr).find('.mealImage').val(),
                "mealDescription": $(tr).find('.mealDescription').val()
            };
        });
        menuData.shift();  // first row is the table header - so remove
        fullData = JSON.stringify(menuData);

        document.getElementById("menu").value = fullData;
    }
}



function addRow(meal_id, meal_name, meal_price, meal_image, meal_description) {
    $('#myTable').append("<tr>\n\
                            <td><input type='number' min='1' value='" + meal_id + "' style='width:40px;' class='mealId' /></td>\n\
                            <td><input type='text' value='" + meal_name + "'style='width:100px; ' class='mealName' />  </td>\n\
                            <td><input type='number' value='" + meal_price + "'style='width:50px; ' class='mealPrice' /> </td>\n\
                            <td><input type='text' value='" + meal_image + "'style='width:150px; ' class='mealImage' /> </td>\n\
                            <td><textarea required='required' class='mealDescription' rows='3' cols='28'> " + meal_description + "</textarea> </td>\n\
                            <td><input type='button' value='Delete' class='btn btn-danger delete'/></td>\n\
                         </tr>");
}


function addNewRow_updateMenu() {
    $('#myTable').append("<tr>\n\
                            <td><input type='number' min='1' style='width:40px;' class='mealId' /></td>\n\
                            <td><input type='text' style='width:100px; ' class='mealName' />  </td>\n\
                            <td><input type='number' style='width:50px; ' class='mealPrice' /> </td>\n\
                            <td><input type='text' style='width:150px; ' class='mealImage' /> </td>\n\
                            <td><textarea required='required' class='mealDescription' rows='3' cols='28'> </textarea> </td>\n\
                            <td><input type='button' value='Delete' class='btn btn-danger delete'/></td>\n\
                         </tr>");
}

function formSubmit_updateMenu() {
    var menu = document.getElementById("menu").value;

    if (menu === "") {
        alert("Please Click Save First");
        return false;
    }
    return true;
}


