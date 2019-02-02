
function addNewRow_addMenu() {
    $('#myTable').append('<tr>\n\
                            <td><input type="number" min="1" style="width:40px;" class="mealId" required="required"/></td>\n\
                            <td><input type="text" style="width:50px;" class="mealName" required="required"/>  </td>\n\
                            <td><input type="number" min="1" style="width:50px;" class="mealPrice" required="required"/>  </td>\n\
                            <td><input type="text" class="mealImage" required="required"/>  </td>\n\
                            <td> <textarea required="required" rows="3" cols="28" class="mealDescription"> </textarea>  </td>\n\
                            <td> <input type="button" value="Delete" class="btn btn-danger delete"/></td>\n\
                         </tr>');
}

$('#myTable').on('click', '.delete', function () {
    $(this).closest('tr').remove();
});

// apply values when pressed enter
$(document).ready(function () {
    $('input[type="text"]').keypress(function (e) {
        if (e.keyCode === 13)
            $('.apply').click();
    });
});



function saveDetails_addMenu() {

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

        document.getElementById("hiddenMenu").value = fullData;
    }
}


function formSubmit_addMenu() {
    var hiddenMenu = document.getElementById("hiddenMenu").value;

    if (hiddenMenu === "") {
        alert("Please Click Save First");
        return false;
    }
    return true;
}
