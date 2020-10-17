package web_2.servlets;

import web_2.data.RequestDataList;
import web_2.data.RequestObj;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
Servlet, осуществляющий проверку попадания точки в область на координатной плоскости
 и формирующий HTML-страницу с результатами проверки.

  Должен обрабатывать все запросы, содержащие сведения о координатах точки и радиусе области.
 */

@WebServlet("/areaCheckServlet")
public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Double x = Double.parseDouble(req.getParameter("x_value"));
        Double y = Double.parseDouble(req.getParameter("y_value"));
        Double r = Double.parseDouble(req.getParameter("r_value"));

        ServletContext contextServlet = req.getServletContext();
        RequestDataList requestData = (RequestDataList) contextServlet.getAttribute("requestData");

        if (requestData == null) requestData = new RequestDataList();
        RequestObj requestObj = new RequestObj();
        requestObj.setX(x);
        requestObj.setY(y);
        requestObj.setR(r);
        requestObj.check_hit();
        requestObj.setDate();
        //время выполнение взять и текущую дату

        requestData.addEntry(requestObj);
        contextServlet.setAttribute("requestData", requestData);
        responseResult(requestObj, resp);
    }

    void responseResult(RequestObj requestObj, HttpServletResponse resp) throws IOException {
        String result =
                "<html>\n" +
                        "  <head>\n" +
                        "    <meta charset=\"utf-8\" /> " +
                        "    <meta name=\"viewport\" content=\"width=device-width initial-scale=1\">\n" +
                        "    <link rel=\"stylesheet\" href=\"css/form_style.css\">" +
                        "    <link rel=\"stylesheet\" href=\"css/servlet_table.css\">" +
                        "    <title>Лабораторная работа №2</title>\n" +
                        "  </head>" +
                        "<body>" +
                        " <div class='block_'>" +
                        "  <div class='block__1'>" +
                        "  <h1 align=center style='color:white;'>Результат операции</h3>" +
                        "   <table class=\"res_table\" id=\"resultTable\">\n" +
                        "       <thead>\n" +
                        "           <tr>\n" +
                        "               <th>X</th>\n" +
                        "               <th>Y</th>\n" +
                        "               <th>R</th>\n" +
                        "               <th>Попал?</th>\n" +
                        "               <th>Время</th>\n" +
                        "               <th>Время выполнения</th>\n" +
                        "           </tr>\n" +
                        "        </thead>\n" +
                        "       <tbody>\n" +
                        "           <td>" + requestObj.getX() + "</td>\n" +
                        "           <td>" + requestObj.getY() + "</td>\n" +
                        "           <td>" + requestObj.getR() + "</td>\n" +
                        "           <td>" + requestObj.isIs_hit() + "</td>\n" +
                        "           <td>" + requestObj.getDate() + "</td>\n" +
                        "           <td>" + requestObj.getMicroseconds() + " ms </td>\n" +
                        "       </tbody>\n" +
                        "   </table>" +
                        "   <br>" +
                        "   <br>" +
                        "   <form action=\"/web_2-1.0-SNAPSHOT/webServlet\">" +
                        "       <button type=\"submit\">Вырнуться обратно</button>" +
                        "   </from>" +
                        "  </div>" +
                        " </div>" +
                        "</body>" +
                        "</html>";
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write(result);
        resp.getWriter().close();
    }
}
