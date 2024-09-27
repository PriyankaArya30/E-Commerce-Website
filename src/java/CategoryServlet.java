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
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
@WebServlet(urlPatterns = {"/CategoryServlet"})
public class CategoryServlet extends HttpServlet {

         public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("admin.jsp");
    }
         
          public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              
               String Id = request.getParameter("catId");
               String title = request.getParameter("catTitle");
               String description = request.getParameter("catDescription");
                HttpSession session = request.getSession();
               
                Connection con = null;
                PreparedStatement pst = null;
               
                  try {
                    con = DBConnector.getConnection();
                   pst = con.prepareStatement("INSERT INTO category VALUES(?,?,?)");
                   
                    pst.setString(1, Id);
                    pst.setString(2, title);
                    pst.setString(3, description);
                    
                      int i = pst.executeUpdate();

            if (i > 0) {
                System.out.println(i + " RECORD INSERTED");
                
                // Create a session and store user details
//                HttpSession session = request.getSession();
                session.setAttribute("catId", Id);
                session.setAttribute("catTitle", title);
                session.setAttribute("catDescription", description);
                  response.sendRedirect("admin.jsp");
               
            } else {
                System.out.println("RECORD NOT INSERTED");
               
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
             
          }

}
