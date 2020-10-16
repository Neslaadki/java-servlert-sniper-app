var error_message = '';



var is_valid = $(document).ready(function() {
    $('button.send').click(function() {

        var x_value = $('select.x').val();
        var y_value = $('input.y').val().trim();
        var r_value = $('select.r').val();

        var values_is_valid = validation(x_value, y_value, r_value);

        if (values_is_valid) {
            $.ajax({
                method: "POST",
                url: "php/some.php",
                data: { x: x_value, y: y_value, r: r_value }
            }).done(function(table) {
                document.getElementById("resultTable").innerHTML = table;
            });

        } else {
            alert(error_message);
            error_message = '';
        }
        return false;
    })

});

var is_clear = $(document).ready(function() {
    $('button.resetTable').click(function() {
        $.ajax({
            method: "POST",
            url: "php/clearTable.php",
        }).done(function(noll_table) {
            document.getElementById("resultTable").innerHTML = noll_table;
        });
        return false;
    })
});




function validation(x_value, y_value, r_value) {
    var is_valid = false;

    var x_is_valid = false;
    var y_is_valid = false;
    var r_is_valid = false;

    if (x_value != 'no') {
        if (-3 <= x_value && x_value <= 5) {
            x_is_valid = true;
        } else {
            error_message += 'Неверный формат значения координаты X!\n';
        }
    } else {
        error_message += 'Необходимо выбрать координату X!\n';
    }

    if (y_value != 'no') {
        if (/^(-?\d+)([,.]\d+)?$/.test(y_value) && y_value.replace(',', '.') >= -5 && y_value.replace(',', '.') <= 3) {
            y_is_valid = true;
        } else {
            error_message += 'Неверный формат значения координаты Y!\n';
        }
    } else {
        error_message += 'Необходимо выбрать координату Y!\n';
    }

    if (r_value != 'no') {
        if (1 <= r_value && x_value <= 5) {
            r_is_valid = true;
        } else {
            error_message += 'Неверный формат значения координаты R!\n'
        }
    } else {
        error_message += 'Необходимо выбрать координату R!\n';
    }

    if (x_is_valid == true && y_is_valid == true && r_is_valid == true) {
        is_valid = true;
    }

    return is_valid;

}