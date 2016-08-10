package ua.pp.lazin.lesson4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Laz on 08.08.2016.
 */
public class Hello extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("<h1>Hello World</h1>");
    }
}
