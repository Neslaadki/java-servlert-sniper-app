var canvas = document.getElementById('canvas');




var _radius = "R";
var _half_radius = "R/2";





function draw_axes(context, x0, y0, x1, y1) {

    context.globalAlpha = 0.6;
    context.beginPath();
    context.lineWidth = 2;
    // draw X - coordinate
    context.moveTo(225, 10);
    context.lineTo(225, 440);
    // draw Y - coordinate
    context.moveTo(440, 225);
    context.lineTo(10, 225);
    context.stroke();
    // draw Rect
    context.fillStyle = "blue";
    context.fillRect(225, 225, 172, 172);
    // draw Arc
    context.moveTo(225, 225);
    context.arc(225, 225, 86, 3 * Math.PI / 2, false);
    context.stroke();
    // 
    context.moveTo(225, (225 - (0.4 * 440 / 2)));
    context.lineTo(225 - (0.8 * (430) / 2), 225);
    context.lineTo(225, 225);
    context.lineTo(225, (225 - (0.4 * 440 / 2)));
    context.fill();

    context.fillStyle = "black";
    context.font = "15px Arial serif";
    context.fillText("X", 440, 225 + 5);
    context.fillText("Y", 225, 15);
    context.font = "20px Arial serif";
    context.fillText(_radius, 440 - (0.2 * 225), 225 + 20);
    context.fillText(_half_radius, 440 - (0.2 * 215) - (0.8 * 215 / 2), 225 + 20);
    context.fillText(_radius, 10 + 0.2 * 215, 225 + 20);
    context.fillText(_half_radius, 225 - 30, 225 - (215 * 0.8 / 2));
    context.fillText(_radius, 225 - 20, 440 - (0.2 * 215));



    context.stroke();

}

draw_axes(canvas.getContext('2d'), 225, 10, 225, 440);