let radiusValue = 0;

document.querySelector('#r_value').onclick = function (){
    if (validate_checkbox(r_value,"R",1,5)){
        r_value.forEach(function (concrete_value) {
            if (concrete_value.checked) {
                radiusValue = concrete_value.value;
            }
        })

        let half_value = String(Number(radiusValue)/2);
        document.querySelector('#radius-text-right').innerHTML = radiusValue;
        document.querySelector('#radius-text-left').innerHTML = radiusValue;
        document.querySelector('#radius-text-top').innerHTML = radiusValue;
        document.querySelector('#radius-text-bottom').innerHTML = radiusValue;
        document.querySelector('#radius-text-right-half').innerHTML = half_value;
        document.querySelector('#radius-text-left-half').innerHTML = half_value;
        document.querySelector('#radius-text-top-half').innerHTML = half_value;
        document.querySelector('#radius-text-bottom-half').innerHTML = half_value;

    }
}

