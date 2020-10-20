<%@ page import="web_2.data.RequestObj" %>
<%@ page import="web_2.data.RequestDataList" %><%--/Страница JSP, формирующая HTML-страницу с веб-формой. Должна обрабатывать все запросы, не содержащие сведений о координатах точки и радиусе области.--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Работа №2</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/form_style.css">
    <link rel="stylesheet" href="css/buttons_style.css">

</head>

<body>
<div>
    <header>
        <h1>
            Разработать веб-приложение на базе сервлетов и JSP, определяющее попадание точки на координатной плоскости в заданную область.
        </h1>
        <p>
            <a href="https://vk.com/neslaaadki" target="_blank">Дзюбак Антон Михайлович P3214</a> <br>
            <a href="https://vk.com/ali_alibekovich" target="_blank">Чупанов Али Алибекович P3214</a>
            <br> Вариант - 92184
        </p>
    </header>
</div>
<div class="content">
    <div class="block">
        <div class="block__column">
            <div class="block__item" id="itemBlockWithSVG">
                <div class="block__svg" id="svg_wrapper">
                    <svg class='svg_axis' xmlns="http://www.w3.org/2000/svg" width="300" height="300">
                        <%
                            RequestDataList pointObj = (RequestDataList)pageContext.getServletContext().getAttribute("requestData");
                            if(pointObj!=null) {
                                int i = 5;
                                for (RequestObj s : pointObj.getDataList()) {
                                    out.println("<circle name=\"points\" xyr=\""+s.getX()+" "+s.getY()+" "+s.getR()+"\" cx=\""+ ( 150 + (s.getX()*120/s.getR()))+"\" cy=\""+ (150 + ((-1) * s.getY()*120/s.getR())) +"\" r=\"5\" stroke=\"black\" stroke-width=\"3\" fill=\"yellow\" />");
                                    i--;
                                    if(i==0){
                                        break;
                                    }
                                }
                            }
                        %>
                        <!-- draw axis - -->
                        <line x1="0" y1="150" x2="300" y2="150" stroke="#003"></line>
                        <line x1="150" y1="0" x2="150" y2="300" stroke="#003"></line>
                        <polygon points="300,150 295,145 295,155" fill="#003" stroke="#000"></polygon>
                        <polygon points="150,0 145,5 155,5" fill="#003" stroke="#000"></polygon>
                        <line x1="270" y1="155" x2="270" y2="145" stroke="#000"></line>
                        <text x="265" y="140" class="axis-text" id="radius-text-right">R</text>
                        <line x1="210" y1="155" x2="210" y2="145" stroke="#000"></line>
                        <text x="200" y="140" class="axis-text" id="radius-text-right-half">R/2</text>
                        <line x1="90" y1="155" x2="90" y2="145" stroke="#000"></line>
                        <text x="75" y="140" class="axis-text" id="radius-text-left-half">-R/2</text>
                        <line x1="30" y1="155" x2="30" y2="145" stroke="#000"></line>
                        <text x="23" y="140" class="axis-text" id="radius-text-left">-R</text>
                        <line x1="145" y1="30" x2="155" y2="30" stroke="#000"></line>
                        <text x="157" y="35" class="axis-text" id="radius-text-top">R</text>
                        <line x1="145" y1="90" x2="155" y2="90" stroke="#000"></line>
                        <text x="157" y="95" class="axis-text" id="radius-text-top-half">R/2</text>
                        <line x1="145" y1="210" x2="155" y2="210" stroke="#000"></line>
                        <text x="157" y="215" class="axis-text" id="radius-text-bottom-half">-R/2</text>
                        <line x1="145" y1="270" x2="155" y2="270" stroke="#000"></line>
                        <text x="157" y="275" class="axis-text" id="radius-text-bottom">-R</text>

                        <!-- draw figures - -->
                        <polygon points="90,150 150,30 150,150" fill="#00f" stroke="#003" fill-opacity="0.5"></polygon>
                        <rect height="120" width="60" x="150" y="150" fill-opacity="0.5" fill="#a0f" stroke="#003"></rect>
                        <path stroke="#003" d="M 270,150 L 150,150 L 150,90 A 60,60 0 0 1 210,150" fill-opacity="0.5"></path>

                    </svg>
                </div>
            </div>
        </div>
        <div class="block__column">
            <div class="block__item">
                <div class='style_block'>
                    <form class="form" id="_form" onsubmit="return validation()">

                        <!--X Coordinate-->
                        <div class="item_x">
                            <label> Координата X
                                <br>
                                <label class="checkbox-label"><input type="checkbox" name="x_value" value="-2" form="_form">-2</label>
                                <label class="checkbox-label"><input type="checkbox" name="x_value" value="-1.5" form="_form">-1.5</label>
                                <label class="checkbox-label"><input type="checkbox" name="x_value" value="-1" form="_form">-1</label>
                                <label class="checkbox-label"><input type="checkbox" name="x_value" value="-0.5" form="_form">-0.5</label>
                                <label class="checkbox-label"><input type="checkbox" name="x_value" value="0" form="_form">0</label>
                                <label class="checkbox-label"><input type="checkbox" name="x_value" value="0.5" form="_form">0.5</label>
                                <label class="checkbox-label"><input type="checkbox" name="x_value" value="1.0" form="_form">1.0</label>
                                <label class="checkbox-label"><input type="checkbox" name="x_value" value="1.5" form="_form">1.5</label>
                                <label class="checkbox-label"><input type="checkbox" name="x_value" value="2" form="_form">2</label>
                            </label>
                        </div>

                        <!--Y Coordinate-->
                        <div class="item_y">
                            <label > Координата Y -
                                <input class="y" size="12px" id="y_value" name="y_value" form="_form" type="text" maxlength="8" placeholder="от -5 до 5" data-rule="number">
                            </label>
                        </div>

                        <!--R Radius-->
                        <div class="item_radius">
                            <label id="r_value"> Радиус R
                                <br>
                                <label class="checkbox-label"><input type="checkbox" name="r_value" value="1" form="_form">1</label>
                                <label class="checkbox-label"><input type="checkbox" name="r_value" value="2" form="_form">2</label>
                                <label class="checkbox-label"><input type="checkbox" name="r_value" value="3" form="_form">3</label>
                                <label class="checkbox-label"><input type="checkbox" name="r_value" value="4" form="_form">4</label>
                                <label class="checkbox-label"><input type="checkbox" name="r_value" value="5" form="_form">5</label>
                            </label>
                        </div>

                        <!--Buttons-->
                        <div>
                            <button class="send" type="submit" form="_form" id="send" onclick="return validation()"> Отправить </button>
                            <button class="reset" type="reset" form="_form"> Сбросить </button>
                        </div>
                    </form>
                </div>
                <div>
                    <div class="mobile-table">
                        <table class="iksweb" id="resultTable">
                            <thead>
                            <tr>
                                <th>X</th>
                                <th>Y</th>
                                <th>R</th>
                                <th>Попал?</th>
                                <th>Время</th>
                                <th>Время выполнения</th>
                            </tr>
                            </thead>
                                <%
                                    RequestDataList names = (RequestDataList)pageContext.getServletContext().getAttribute("requestData");
                                    if(names!=null) {
                                        for (RequestObj s : names.getDataList()) {
                                            <%="<tbody>"%>
                                            <%="<td>" + s.getX() + "</td>"%>
                                            <%="<td>" + s.getY() + "</td>"%>
                                            <%="<td>" + s.getR() + "</td>"%>
                                            <%="<td>" + s.isIs_hit() + "</td>"%>
                                            <%="<td>" + s.getDate() + "</td>"%>
                                            <%="<td>" + s.getMicroseconds() + "</td>"%>
                                            <%="</tbody>"%>
                                        }
                                    }
                                %>
                        </table>
                    </div>
                    <form action="Cleaner">
                        <button class="resetTable" type="submit" id="clean_button"> Очистить таблицу </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="js/response.js"></script>
<script src="js/mouse-coordinate-definer.js"></script>
</html>