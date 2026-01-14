package com.mycompany;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/ResetPasswordServlet")
public class ResetServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");
        String newPassword = request.getParameter("newPassword");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/signupdb", "root", "root"
            );

            PreparedStatement psCheck = con.prepareStatement(
                "SELECT * FROM users WHERE email=?"
            );
            psCheck.setString(1, email);
            ResultSet rs = psCheck.executeQuery();

            if(rs.next()){
                PreparedStatement ps = con.prepareStatement(
                    "UPDATE users SET password=? WHERE email=?"
                );
                ps.setString(1, newPassword);
                ps.setString(2, email);
                ps.executeUpdate();

                response.sendRedirect("Login.jsp");
            } else {
                response.getWriter().println("Email not found! Please signup first.");
            }

            con.close();

        } catch (Exception e) {
            response.getWriter().println(e);
        }
    }
}
