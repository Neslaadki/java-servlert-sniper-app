<%--/Страница JSP, формирующая HTML-страницу с веб-формой. Должна обрабатывать все запросы, не содержащие сведений о координатах точки и радиусе области.--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>lab1</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/form_style.css">

</head>

<body>
<div>
    <header>
        <h1>
            Проверка попадания точки в заданную область
        </h1>
        <p>
            <a href="https://isu.ifmo.ru/pls/apex/f?p=2437:7:109996409750410:::::" target="_blank">Дзюбак Антон Михайлович P3214</a>
            <br> Вариант - 2502
        </p>
    </header>
</div>
<div class="content">
    <div class="block">
        <div class="block__column">
            <div class="block__item">
                <canvas id="canvas" width="450px" height="450px" style="background-color: burlywood;"></canvas>
            </div>
        </div>
        <div class="block__column">
            <div class="block__item">
                <div style="background-color: rgb(9, 166, 172); border-bottom: 4px solid rgb(92, 90, 90);">

                    <form class="form" method="POST" id="_form">
                        <div class="item_x" style="text-align: center;" id="_x">
                            <label> Координата X:
                                <select class="x" name="select_x" id="select_x" form="_form">
                                    <option selected value="no"> Не выбрано </option>
                                    <option value="-3"> -3 </option>
                                    <option value="-2"> -2 </option>
                                    <option value="-1"> -1 </option>
                                    <option value="0"> 0 </option>
                                    <option value="1"> 1 </option>
                                    <option value="2"> 2 </option>
                                    <option value="3"> 3 </option>
                                    <option value="4"> 4 </option>
                                    <option value="5"> 5 </option>
                                </select>
                            </label>
                        </div>
                        <div class="item_y" style="text-align: center;">
                            <label> Координата Y:
                                <input class="y" size="12px" id="_y" name="input_y" form="_form" type="text" maxlength="8" placeholder="от -5 до 5" data-rule="number">
                            </label>
                        </div>
                        <div class="item_radius" style="text-align: center;">
                            <label> Радиус R:
                                <select class="r" name="select_r" id="_r" form="_form">
                                    <option selected value="no"> Не выбрано </option>
                                    <option value="1 "> 1 </option>
                                    <option value="2 "> 2 </option>
                                    <option value="3 "> 3 </option>
                                    <option value="4 "> 4 </option>
                                    <option value="5 "> 5 </option>
                                </select>
                            </label>
                        </div>
                        <div>

                            <button class="send" type="submit" form="_form"> Отправить </button>
                            <button class="reset" type="reset" form="_form"> Сбросить </button>
                            <button class="resetTable"> Очистить таблицу </button>
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
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>