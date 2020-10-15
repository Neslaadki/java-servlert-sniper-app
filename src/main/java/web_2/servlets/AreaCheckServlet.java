package web_2.servlets;

import web_2.data.RequestDataList;
import web_2.data.RequestObj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
Servlet, осуществляющий проверку попадания точки в область на координатной плоскости
 и формирующий HTML-страницу с результатами проверки.

  Должен обрабатывать все запросы, содержащие сведения о координатах точки и радиусе области.
 */

@WebServlet
public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double x = Double.parseDouble(req.getParameter("X"));
        Double y = Double.parseDouble(req.getParameter("Y"));
        Double r = Double.parseDouble(req.getParameter("R"));

        HttpSession session = req.getSession();
        RequestDataList requestData = (RequestDataList) session.getAttribute("requestData");

        if (requestData == null) requestData = new RequestDataList();
        RequestObj requestObj = new RequestObj();
        requestObj.setX(x);
        requestObj.setY(y);
        requestObj.setR(r);
        requestObj.check_hit();

        requestData.addEntry(requestObj);
        session.setAttribute("requestData", requestData);
    }

    void responseResult(RequestObj requestObj, HttpServletResponse resp) throws IOException {
        String result =
                "<html>\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\" /> " +
                "    <meta name=\"viewport\" content=\"width=device-width initial-scale=1\">\n" +
                "    <title>Лабораторная работа №2</title>\n" +
                "  </head>" +
                "<body>" +
                "  <div >" +
                        "тут будет наша страница" +
                "  </div>" + "</body></html>";
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write(result);
        resp.getWriter().close();
    }
}
