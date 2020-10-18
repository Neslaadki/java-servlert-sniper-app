let radiusValue = 0;

let radius_is_installed = document.querySelector('#r_value').onclick = function (){

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
        return 1;
    }else return 0;
}


document.querySelector('#svg_wrapper').onclick = function (event){
    if (radius_is_installed() === 1){
        let clickX = String(event.offsetX);
        let clickY = String(event.offsetY);
        let a = "?x_value=" + clickX + "&y_value=" + clickY + "&r_value=" + String(radiusValue);
        document.location.href = '/web_2-1.0-SNAPSHOT/webServlet' + a;
    }else{
        alert('R ВЫБЕРИ!');
    }
}







