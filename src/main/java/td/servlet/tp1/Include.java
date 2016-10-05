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
public class Include extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/include.html");
        if (rd != null) {
            PrintWriter out = resp.getWriter();
            out.println("<h1>Hello world ! </h1>");
            rd.include(req,resp);
        }
    }
}