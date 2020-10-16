let x_value = document.getElementsByName("x_value");
let y_value = document.getElementById("_y");
let r_value = document.getElementsByName("r_value");

let error_message = '';


function validation() {
    let x_is_valid = validate_x_value(x_value);
    let y_is_valid = validate_y_value(y_value.value);
    let r_is_valid = validate_r_value(r_value);
    if (!(x_is_valid && y_is_valid && r_is_valid)) {
        alert(error_message);
        error_message = '';
    }
    return x_is_valid && y_is_valid && r_is_valid;
}


//Валидация x_value чекбоксов
function validate_x_value(x_value) {
    //переменная которая в итоге будет выбрана из всех checkbox'ов
    let success_x_value = null;

    //Проверка на выбор нескольких checkBox'ов
    let i = 0;
    x_value.forEach(function (value_x) {
        if (value_x.checked) {
            i++;
            success_x_value = value_x.value;
        }
    })

    //проверка на все остальное
    if (success_x_value !== 'no' && success_x_value !== null) {
        if (-2 <= success_x_value && success_x_value <= 2 && i === 1) {
            return true;
        } else {
            if (i > 1) {
                error_message += 'Выбрано несколько CheckBox\'ов, выберите один!\n';
                i = 0;
            } else {
                error_message += 'Неверный формат значения координаты X!\n';
            }
        }
    } else {
        error_message += 'Необходимо выбрать координату X!\n';
    }
    return false;
}

//Валидация y_value
function validate_y_value(y_value) {
    console.log(y_value);
    if (y_value !== 'no' && y_value !== null) {
        if (/^(-?\d+)([,.]\d+)?$/.test(y_value) && y_value.replace(',', '.') >= -5 && y_value.replace(',', '.') <= 5) {
            return true;
        } else {
            error_message += 'Неверный формат значения координаты Y!\n';
        }
    } else {
        error_message += 'Необходимо выбрать координату Y!\n';
    }
    return false;
}


//Валидация r_value чекбоксов
function validate_r_value(r_value) {
    //переменная которая в итоге будет выбрана из всех checkbox'ов
    let success_r_value = null;

    //Проверка на выбор нескольких checkBox'ов
    let i = 0;
    r_value.forEach(function (value_r) {
        if (value_r.checked) {
            i++;
            success_r_value = value_r.value;
        }
    })

    //проверка на все остальное
    if (success_r_value !== 'no' && success_r_value !== null) {
        if (1 <= success_r_value && success_r_value <= 5 && i === 1) {
            return true;
        } else {
            if (i > 1) {
                error_message += 'Выбрано несколько CheckBox\'ов, выберите один!\n';
                i = 0;
            } else {
                error_message += 'Неверный формат значения координаты R!\n'
            }
        }
    } else {
        error_message += 'Необходимо выбрать координату R!\n';
    }
    return false;
}
