import db.DBConnector;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Retrieve the new profile details from the form
        String newUsername = request.getParameter("newUsername");
        String newEmail = request.getParameter("newEmail");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String newMobile = request.getParameter("newMobile");
        String newAddress = request.getParameter("newAddress");

        // Retrieve the session to get the username
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
      
        

Connection con = DBConnector.getConnection();

        try {
             PreparedStatement pst = con.prepareStatement("UPDATE user SET username=?, email=?, password=?, confirm_password=?, mobile_number=?, address=? WHERE username=?");
             
System.out.println(pst);
            // Set parameters for the prepared statement
            pst.setString(1, newUsername);
            pst.setString(2, newEmail);
            pst.setString(3, password);
            pst.setString(4, newPassword);
            pst.setString(5, newMobile);
            pst.setString(6, newAddress);
            pst.setString(7, username); // Set the username for the WHERE clause
System.out.println(pst);
            // Execute the update query
            int rowsAffected = pst.executeUpdate();
System.out.println(rowsAffected);
            if (rowsAffected > 0) {
                // Update successful, redirect to the profile page
                 session = request.getSession();

// Update session attributes with new values
session.setAttribute("username", newUsername);
session.setAttribute("email", newEmail);
session.setAttribute("mobile", newMobile);
session.setAttribute("address", newAddress);
                response.sendRedirect("profile.jsp");
            } else {
                // Update failed, redirect back to the edit profile page with an error message
                out.println("<h3>Failed to update profile. Please try again.</h3>");
            }
        } catch (SQLException e) {
            // Handle database connection or query errors
            e.printStackTrace();
            out.println("<h3>Database error. Please try again later.</h3>");
        }
    }
}
