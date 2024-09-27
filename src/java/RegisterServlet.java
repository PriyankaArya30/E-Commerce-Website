import db.DBConnector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("Username");
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");
        String confirm_password = request.getParameter("Confirm_Password");
        String mobile = request.getParameter("Mobile_Number");
        String address = request.getParameter("Address");
       HttpSession session = request.getSession();
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = DBConnector.getConnection();
            pst = con.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?)");

            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, confirm_password);
            pst.setString(5, mobile);
            pst.setString(6, address);

            int i = pst.executeUpdate();

            if (i > 0) {
                System.out.println(i + " RECORD INSERTED");
                
                // Create a session and store user details
//                HttpSession session = request.getSession();
                session.setAttribute("username", name);
                session.setAttribute("email", email);
                session.setAttribute("mobile", mobile);
                session.setAttribute("address", address);
                
                response.sendRedirect("home.jsp");
               
            } else {
                System.out.println("RECORD NOT INSERTED");
                response.sendRedirect("register.html");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
