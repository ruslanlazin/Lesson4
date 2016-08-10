package ua.pp.lazin.lesson4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


/**
 * Created by Laz on 05.08.2016.
 */
public class Calc extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameters = req.getParameterMap();

        String advice = "\r\n Please use this structure /calc?operand1=5&operand2=8&operation=ADD";
        resp.setContentType("text/html; charset=utf-8");

        if (!isAllParametersPresent(parameters)) {
            resp.sendError(400, "All parameters are required " + advice);
            return;
        }
        String operation = parameters.get("operation")[0];

        if (!isOperationCorrect(operation)) {
            resp.sendError(400, "Use only ADD, SUB, MUL, DIV  keywords as operation parameter " + advice);
            return;
        }

        int operand1, operand2;

        try {
            operand1 = Integer.parseInt(parameters.get("operand1")[0]);
            operand2 = Integer.parseInt(parameters.get("operand2")[0]);
        } catch (NumberFormatException e) {
            resp.sendError(400, "Use only whole numbers as operand1 and operand2 " + advice);
            return;
        }
        int answer = doOperation(operand1, operand2, operation);
        resp.setStatus(200);
        resp.getWriter().println("<h1>Answer is " + answer + "</h1>");

    }


    private int doOperation(int operand1, int operand2, String operation) throws IllegalArgumentException {
        if ("add".equalsIgnoreCase(operation)) {
            return (operand1 + operand2);
        }
        if ("sub".equalsIgnoreCase(operation)) {
            return (operand1 - operand2);
        }
        if ("mul".equalsIgnoreCase(operation)) {
            return (operand1 * operand2);
        }
        if ("div".equalsIgnoreCase(operation)) {
            return (operand1 / operand2);
        }
        throw new IllegalArgumentException();
    }


    private boolean isOperationCorrect(String operation) {
        if ("add".equalsIgnoreCase(operation) || "sub".equalsIgnoreCase(operation) ||
                "mul".equalsIgnoreCase(operation) || "div".equalsIgnoreCase(operation)) {
            return true;
        }
        return false;
    }


    private boolean isAllParametersPresent(Map<String, String[]> parameters) {
        if (parameters.containsKey("operand1") && parameters.containsKey("operand2") && parameters.containsKey("operation")) {
            return true;
        } else return false;
    }
}


