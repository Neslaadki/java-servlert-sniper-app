package web_2.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
Сервлет, определяющий тип запроса, и, в зависимости от того,
содержит ли запрос информацию о координатах точки и радиусе,
делегирующий его обработку одному из перечисленных ниже компонентов.

Все запросы внутри приложения должны передаваться этому сервлету
(по методу GET или POST в зависимости от варианта задания),
остальные сервлеты с веб-страниц напрямую вызываться не должны.
 */

@WebServlet("/webServlet")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Double.parseDouble(req.getParameter("x_value"));
            Double.parseDouble(req.getParameter("y_value"));
            Double.parseDouble(req.getParameter("r_value"));
            getServletContext().getRequestDispatcher("/areaCheckServlet").forward(req, resp);
        }catch (NullPointerException | NumberFormatException exception){
            getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/main.jsp").forward(req,resp);
    }
}
