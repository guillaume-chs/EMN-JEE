package td.servlet.tp1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Hello extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        process(request, response);
    }

    protected void process(HttpServletRequest request,

                           HttpServletResponse response)

            throws ServletException, IOException

    {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<h1>Hello world ! </h1>");

        out.println("<h1>getServletName() : " +

                getServletName() + "</h1>");

        out.println("<h1>URI : " +

                request.getRequestURI() + "</h1>");

    }
}