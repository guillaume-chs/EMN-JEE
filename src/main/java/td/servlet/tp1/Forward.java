package td.servlet.tp1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author clementgarbay
 */
public class Forward extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("hello".equals(req.getParameter("page")))
        {
            req.setAttribute("plop", "Coucou wesh");
            getServletContext().getNamedDispatcher("PageForwarded").forward(req, resp);

            return;
        }

        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/autre.html");

        if (rd != null) {
            rd.forward(req,resp);
        }
    }
}