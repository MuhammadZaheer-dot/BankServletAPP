package com.mycompany;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/bank")
public class BankServiceServlet extends GenericServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {

        String accountNo = request.getParameter("account");
        String channel = request.getParameter("channel");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        if (channel == null || channel.isEmpty()) {
            out.println("<h3>Please provide channel using:</h3>");
            out.println("<p>?channel=WEB / ATM / INTERNAL</p>");
            out.println("</body></html>");
            return;
        }

        out.println("<h2>Account: " + accountNo + "</h2>");

        if ("ATM".equalsIgnoreCase(channel)) {
            out.println("<p>ATM Response: Balance is 50,000</p>");
        } else if ("WEB".equalsIgnoreCase(channel)) {
            out.println("<p>Web Response: Your balance is PKR 50,000</p>");
        } else if ("INTERNAL".equalsIgnoreCase(channel)) {
            out.println("<p>Internal System: Balance = 50,000</p>");
        } else {
            out.println("<p>Unknown channel!</p>");
        }

        out.println("</body></html>");
    }
}