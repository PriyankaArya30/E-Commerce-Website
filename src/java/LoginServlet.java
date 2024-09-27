/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import db.DBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String tablePassword = null;
        String mobile_number = null;
        String address = null;
        String email = null;

        HttpSession session = request.getSession();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = db.DBConnector.getStatement();

            String query = "SELECT password, mobile_number, address, email FROM user WHERE username='" + username + "'";
            System.out.println("query = " + query);

            rs = st.executeQuery(query);

            if (rs.next()) {
                tablePassword = rs.getString("password");
                mobile_number = rs.getString("mobile_number");
                address = rs.getString("address");
                email = rs.getString("email");
            }
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }

         if (username != null && password != null && !username.trim().equals("") && password.equals(tablePassword)) {
        session.setAttribute("username", username);
        session.setAttribute("mobile", mobile_number);
        session.setAttribute("address", address);
        session.setAttribute("email", email);

        // Check if the user is an admin
        if ("admin".equals(username)) {
            response.sendRedirect("admin.jsp");
        } else {
            response.sendRedirect("home.jsp");
        }
    } else {
        response.sendRedirect("login.html");
    }
    }
}
    