package ua.pp.lazin.lesson4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Laz on 07.08.2016.
 */
public class Registration extends HttpServlet {
    private List<String> listOfUsers = new ArrayList<>();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameters = req.getParameterMap();

        resp.setContentType("text/html; charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);

        if (!parameters.containsKey("username")) {
            resp.getWriter().println(listOfUsers);
            return;
        }
        String userName = parameters.get("username")[0];

        if (parameters.containsKey("unique") &&
                "true".equalsIgnoreCase(parameters.get("unique")[0]) &&
                listOfUsers.contains(userName)) {
            resp.getWriter().println("User with name " + userName + " already exist");
            return;
        }

        listOfUsers.add(userName);
        resp.getWriter().println(userName + " was added");
    }
}
