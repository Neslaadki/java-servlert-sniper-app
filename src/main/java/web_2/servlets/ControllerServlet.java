package web_2.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
Сервлет, определяющий тип запроса, и, в зависимости от того,
содержит ли запрос информацию о координатах точки и радиусе,
делегирующий его обработку одному из перечисленных ниже компонентов.
(AreaCheckServlet or face.jsp)

Все запросы внутри приложения должны передаваться этому сервлету
(по методу GET или POST в зависимости от варианта задания),
остальные сервлеты с веб-страниц напрямую вызываться не должны.
 */

@WebServlet("webServlet")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Double.parseDouble(req.getParameter("x_value"));
            Double.parseDouble(req.getParameter("y_value"));
            Double.parseDouble(req.getParameter("r_value"));
            getServletContext().getRequestDispatcher("/AreaCheckServlet").forward(req, resp);
        } catch (NumberFormatException | NullPointerException invalid_value_exception) {
            getServletContext().getRequestDispatcher("/face.jsp").forward(req, resp);
        } catch (Exception exceptions) {
            PrintWriter writer = resp.getWriter();
            writer.write("Invalid values");
            writer.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/face.jsp").forward(req, resp);
    }
}
