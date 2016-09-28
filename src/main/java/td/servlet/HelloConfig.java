package td.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloConfig extends HttpServlet {

    private String lang;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // NB: Indispensable !!!
        lang = config.getInitParameter("lang");
    }

    @Override
    public void destroy()
    {
        lang = null;
    }

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
        out.println("<h1> Lang : " + lang + "</h1>");
        switch (lang) {
            case "en" :
                out.println("<h1>Hello</h1>");
                break;
            case "fr" :
                out.println("<h1>Bonjour</h1>");
                break;
            default:
                out.println("lang is not known");
        }
    }
}