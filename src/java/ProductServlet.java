import db.DBConnector;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = {"/ProductServlet"})
@MultipartConfig
public class ProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("admin.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pid = request.getParameter("pId");
        String pname = request.getParameter("pname");
        String pabout = request.getParameter("pabout");
        String price = request.getParameter("price");
        String discount = request.getParameter("discount");
        String quantity = request.getParameter("quantity");
        String c_name = request.getParameter("catTitle");
System.out.println("1");
        // Get the Part from the request
        Part part = request.getPart("pic");

        HttpSession session = request.getSession();
        Connection con = null;
        PreparedStatement pst = null;
System.out.println("2");
        try {
            con = DBConnector.getConnection();
            pst = con.prepareStatement("INSERT INTO product VALUES(?,?,?,?,?,?,?,?)");

            pst.setString(1, pid);
            pst.setString(2, pname);
            pst.setString(3, pabout);
             pst.setBinaryStream(4, part.getInputStream(), (int) part.getSize());
            pst.setString(5, price);
            pst.setString(6, discount);
            pst.setString(7, quantity);
            pst.setString(8, c_name);
System.out.println(c_name);
            // Set the image data as a BLOB
            
System.out.println("4");
            int i = pst.executeUpdate();
System.out.println("5");
            if (i > 0) {
                System.out.println(i + " RECORD INSERTED");

                // Create a session and store user details
                session.setAttribute("pid", pid);
                session.setAttribute("pname", pname);
                session.setAttribute("pabout", pabout);
                session.setAttribute("price", price);
                session.setAttribute("discount", discount);
                session.setAttribute("quantity", quantity);
                session.setAttribute("c_name",c_name );
                session.setAttribute("part", part);

                response.sendRedirect("admin.jsp");

            } else {
                System.out.println("RECORD NOT INSERTED");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } 
    }
}