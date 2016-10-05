package td.servlet.tp1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionShow extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session == null){
            response.setStatus(404);
        }else{
            String name = (String) session.getAttribute("name");
            if(name != null){
                System.out.println("SESSION NAME = " + name);
            }else{
                response.setStatus(404);
            }
        }
    }

}