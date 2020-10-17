package web_2.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Cleaner")
public class CleaningServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext contextServlet = req.getServletContext();
        contextServlet.setAttribute("requestData",null);
        resp.sendRedirect("/web_2-1.0-SNAPSHOT/webServlet");
    }
}