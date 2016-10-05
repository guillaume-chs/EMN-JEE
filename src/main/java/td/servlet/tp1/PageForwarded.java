package td.servlet.tp1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author clementgarbay
 */
public class PageForwarded extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<h1>Hello world !  je suis le servlet page Forwarded et le parametre donne" + req.getParameter("page") + " et le parametre ajoute "+ req.getAttribute("plop") + "</h1>");
    }
}