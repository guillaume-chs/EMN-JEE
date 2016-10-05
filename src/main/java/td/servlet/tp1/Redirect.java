package td.servlet.tp1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author clementgarbay
 */
public class Redirect extends HttpServlet {

    private String defaultPage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        defaultPage = config.getInitParameter("page");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String contextPath = req.getContextPath();
        String page = req.getParameter("page");
        page = (page == null) ? defaultPage : page;

        switch (page) {
            case "1":
                resp.sendRedirect(contextPath + "/index1.html");
                break;
            case "2":
                resp.sendRedirect(contextPath + "/index2.html");
                break;
            case "g":
                resp.sendRedirect("https://google.com");
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}