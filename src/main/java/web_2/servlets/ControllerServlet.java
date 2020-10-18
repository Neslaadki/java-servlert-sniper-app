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
            double x = Double.parseDouble(req.getParameter("x_value"));
            double y = Double.parseDouble(req.getParameter("y_value"));
            double r = Double.parseDouble(req.getParameter("r_value"));
            if (validate(x, y, r)) {
                getServletContext().getRequestDispatcher("/areaCheckServlet").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
            }
        } catch (NullPointerException | NumberFormatException exception) {
            getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    private boolean validate(double x, double y, double r) {
        boolean is_valid = true;
        if (x < -2 || x > 2) {
            is_valid = false;
        } else if (y < -5 || y > 5) {
            is_valid = false;
        } else if (r < 1 || r > 5) {
            is_valid = false;
        }
        return is_valid;
    }
}
