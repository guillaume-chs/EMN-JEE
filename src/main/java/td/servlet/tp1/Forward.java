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

            this.forward("PageForwarded", req, resp);

            return;
        }

        if ("template".equals(req.getParameter("page")))
        {
            req.setAttribute("value", 150);

            if (this.forward("/WEB-INF/page1.jsp", req, resp))
            {
                return;
            }
        }

        this.forward("/autre.html", req, resp);
    }

    private boolean forward(String path, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;
        rd = !path.contains(".") ? getServletContext().getNamedDispatcher(path) : getServletContext().getRequestDispatcher(path);

        if (rd != null)
        {
            rd.forward(req, resp);

            return true;
        }

        return false;
    }
}