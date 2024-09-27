package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import db.DBConnector;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/components/common_modals.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("    <!-- Bootstrap CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css\">\n");
      out.write("    \n");
      out.write("    <title>Admin Panel</title>\n");
      out.write("    \n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: 'Arial', sans-serif;\n");
      out.write("            background-color: #f2f2f2;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h1 {\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn-logout {\n");
      out.write("            background-color: dodgerblue;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            font-size: 16px;\n");
      out.write("            position: absolute;\n");
      out.write("            top: 10px;\n");
      out.write("            right: 30px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn-logout:hover {\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .profile-container {\n");
      out.write("            position: absolute;\n");
      out.write("            top: 10px;\n");
      out.write("            right: 150px;\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .profile-icon {\n");
      out.write("             background-color:dodgerblue;\n");
      out.write("            \n");
      out.write("            color: whitesmoke;\n");
      out.write("            font-size: 40px; /* Adjust the size as needed */\n");
      out.write("            margin-right: 8px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .username {\n");
      out.write("            color: white;\n");
      out.write("            font-size: 30px; /* Adjust the size as needed */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .admin .card {\n");
      out.write("            border: 1px solid #673ab7;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .admin .card:hover {\n");
      out.write("            background: #e2e2e2;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    \n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("      \n");
      out.write("                \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    List<String> categories = new ArrayList<>();
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    try {
        con = DBConnector.getConnection();
        st = con.createStatement();
        String query = "SELECT c_title FROM category";
        rs = st.executeQuery(query);

        while (rs.next()) {
            String category = rs.getString("c_title");
            categories.add(category);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    int userCount = 0;
     int productCount = 0;
    
  try {
      
        String query1 = "SELECT COUNT(*) AS userCount FROM user";  // Assuming 'users' is your user table
        rs = st.executeQuery(query1);

        if (rs.next()) {
            userCount = rs.getInt("userCount");
            
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
  
 try {
        
        String query = "SELECT COUNT(*) AS productCount FROM product";  // Assuming 'product' is your product table
        rs = st.executeQuery(query);

        if (rs.next()) {
            productCount = rs.getInt("productCount");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

      out.write("\n");
      out.write("      \n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\">MYCart</a>\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("          <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("      \n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("          <ul class=\"navbar-nav mr-auto\">\n");
      out.write("            <li class=\"nav-item active\">\n");
      out.write("                <a class=\"nav-link\" href=\"home.jsp\">Home <span class=\"sr-only\">(current)</span></a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item active\">\n");
      out.write("                <a class=\"nav-link\" href=\"about.html\">About us <span class=\"sr-only\">(current)</span></a>\n");
      out.write("              </li>\n");
      out.write("           \n");
      out.write("              <li>\n");
      out.write("                  <li class=\"nav-item active\">\n");
      out.write("                <a class=\"nav-link\" href=\"#\">Contact us <span class=\"sr-only\">(current)</span></a>\n");
      out.write("              </li>\n");
      out.write("              \n");
      out.write("              <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"#!\" data-toggle=\"modal\" data-target=\"#cart\"><i class=\"fas fa-shopping-cart\"></i><span class=\"ml-0 cart-items\">(0)</span></a>\n");
      out.write("                    </li>\n");
      out.write("              \n");
      out.write("          </ul>\n");
      out.write("         \n");
      out.write("          <ul class=\"navbar-nav ml-auto\">\n");
      out.write("             <form action=\"LogoutServlet\" method=\"post\">\n");
      out.write("            <div class=\"profile-container\">\n");
      out.write("                <i class=\"fas fa-user-circle profile-icon\"></i>\n");
      out.write("                <span class=\"username\">");
      out.print( session.getAttribute("username") );
      out.write("</span>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            <button type=\"submit\" class=\"btn-logout\">Logout</button>\n");
      out.write("        </form>\n");
      out.write("          </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("      </nav>\n");
      out.write("  \n");
      out.write("      <div class=\"container admin\">\n");
      out.write("          <div class=\"row mt-3\">\n");
      out.write("              <div class=\"col-md-4\">\n");
      out.write("                  \n");
      out.write("                  <div class=\"card\">\n");
      out.write("                      <div class=\"card body text-center\">\n");
      out.write("                          \n");
      out.write("                            <div class=\"container\">\n");
      out.write("                              <img style=\"max-width: 125px;\" class=\"img-fluid\" src=\"img/group.png\" alt=\"user_icon\">\n");
      out.write("                              </div>\n");
      out.write("                          \n");
      out.write("                          <h4>");
      out.print( userCount);
      out.write("</h4>\n");
      out.write("                          <h3 class=\"text-muted\">USERS</h3>\n");
      out.write("                          </div>\n");
      out.write("                      </div>\n");
      out.write("                  \n");
      out.write("                  </div>\n");
      out.write("               <div class=\"col-md-4\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"card\">\n");
      out.write("                      <div class=\"card body text-center\">\n");
      out.write("                          \n");
      out.write("                             <div class=\"container\">\n");
      out.write("                              <img style=\"max-width: 125px;\" class=\"img-fluid\" src=\"img/delivery-box.png\" alt=\"user_icon\">\n");
      out.write("                              </div>\n");
      out.write("                          \n");
      out.write("                          \n");
      out.write("                          <h4>");
      out.print( productCount);
      out.write("</h4>\n");
      out.write("                          <h3 class=\"text-muted\">PRODUCTS</h3>\n");
      out.write("                          </div>\n");
      out.write("                      </div>\n");
      out.write("                  \n");
      out.write("                  </div>\n");
      out.write("               <div class=\"col-md-4\">\n");
      out.write("                  \n");
      out.write("                    <div class=\"card\">\n");
      out.write("                      <div class=\"card body text-center\">\n");
      out.write("                          \n");
      out.write("                           <div class=\"container\">\n");
      out.write("                              <img style=\"max-width: 125px;\" class=\"img-fluid\" src=\"img/options.png\" alt=\"user_icon\">\n");
      out.write("                              </div>\n");
      out.write("                          \n");
      out.write("                        \n");
      out.write("                          \n");
      out.write("                           <h4>");
      out.print( categories.size());
      out.write("</h4>\n");
      out.write("                          <h3 class=\"text-muted\">CATEGORIES</h3>\n");
      out.write("                          </div>\n");
      out.write("                      </div>\n");
      out.write("                  \n");
      out.write("                  </div>\n");
      out.write("              </div>\n");
      out.write("          \n");
      out.write("                 <div class=\"row mt-3\">\n");
      out.write("                     \n");
      out.write("                     <div class=\"col-md-6\">\n");
      out.write("                         \n");
      out.write("                          \n");
      out.write("                  <div class=\"card\" data-toggle=\"modal\" data-target=\"#add-product-modal\">\n");
      out.write("                      <div class=\"card body text-center\">\n");
      out.write("                          \n");
      out.write("                            <div class=\"container\">\n");
      out.write("                              <img style=\"max-width: 125px;\" class=\"img-fluid\" src=\"img/add-product.png\" alt=\"user_icon\">\n");
      out.write("                              </div>\n");
      out.write("                          \n");
      out.write("                          <p class=\"mt-2\">click here<p>\n");
      out.write("                          <h3 class=\"text-muted\">ADD PRODUCT</h3>\n");
      out.write("                          </div>\n");
      out.write("                      </div>\n");
      out.write("                  \n");
      out.write("                         \n");
      out.write("                         </div>\n");
      out.write("                     \n");
      out.write("                      <div class=\"col-md-6\">\n");
      out.write("                          \n");
      out.write("                           \n");
      out.write("                  <div class=\"card\" data-toggle=\"modal\" data-target=\"#add-category-modal\">\n");
      out.write("                      <div class=\"card body text-center\">\n");
      out.write("                          \n");
      out.write("                            <div class=\"container\">\n");
      out.write("                              <img style=\"max-width: 125px;\" class=\"img-fluid\" src=\"img/checklist.png\" alt=\"user_icon\">\n");
      out.write("                              </div>\n");
      out.write("                          \n");
      out.write("                          <p class=\"mt-2\">click here<p>\n");
      out.write("                          <h3 class=\"text-muted\">ADD CATEGORY</h3>\n");
      out.write("                          </div>\n");
      out.write("                      </div>\n");
      out.write("                  \n");
      out.write("                          \n");
      out.write("                         \n");
      out.write("                         </div>\n");
      out.write("                     \n");
      out.write("                     </div>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          \n");
      out.write("          <!-- Button trigger modal -->\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Modal -->\n");
      out.write("<div class=\"modal fade\" id=\"add-category-modal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("  <div class=\"modal-dialog modal-lg\" role=\"document\">\n");
      out.write("    <div class=\"modal-content\">\n");
      out.write("      <div class=\"modal-header custom-bg text-dark\">\n");
      out.write("        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Enter Category detail</h5>\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\n");
      out.write("        </button>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-body\">\n");
      out.write("            \n");
      out.write("          <form action=\"CategoryServlet\" method=\"post\">\n");
      out.write("              \n");
      out.write("              <div class=\"form-group\">\n");
      out.write("                  <input type=\"number\" class=\"form-control\" name=\"catId\" placeholder=\"Enter category ID\" required/>\n");
      out.write("              </div>\n");
      out.write("              \n");
      out.write("              <div class=\"form-group\">\n");
      out.write("                  <input type=\"text\" class=\"form-control\" name=\"catTitle\" placeholder=\"Enter category title\" required/>\n");
      out.write("              </div>\n");
      out.write("                   \n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                    <textarea style=\"height: 200px\" class=\"form-control\" placeholder=\"Enter category description\" name=\"catDescription\" required></textarea> \n");
      out.write("                </div>\n");
      out.write("              \n");
      out.write("              <div class=\"container text-center\">\n");
      out.write("                  <button class=\"btn btn-outline-success\">Add Category</button>\n");
      out.write("                  <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                  </div>\n");
      out.write("              \n");
      out.write("              </form>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-footer\">\n");
      out.write("        \n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("     <!-- Button trigger modal -->\n");
      out.write("\n");
      out.write("\n");
      out.write("      <!-- Button trigger modal -->\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Modal -->\n");
      out.write("<div class=\"modal fade\" id=\"add-product-modal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("  <div class=\"modal-dialog modal-lg\">\n");
      out.write("    <div class=\"modal-content \">\n");
      out.write("      <div class=\"modal-header custom-bg text-dark\">\n");
      out.write("        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Enter Product detail</h5>\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\n");
      out.write("        </button>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-body\">\n");
      out.write("       \n");
      out.write("<form action=\"ProductServlet\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                  <input type=\"number\" class=\"form-control\" name=\"pId\" placeholder=\"Enter Product ID\" required/>\n");
      out.write("              </div>\n");
      out.write("          \n");
      out.write("              <div class=\"form-group\">\n");
      out.write("                  <input type=\"text\" class=\"form-control\" name=\"pname\" placeholder=\"Enter title\" required/>\n");
      out.write("              </div>\n");
      out.write("          \n");
      out.write("              <div class=\"form-group\">\n");
      out.write("                  <textarea style=\"height:100px;\" class=\"form-control\" name=\"pabout\" placeholder=\"Enter about product\" required></textarea>\n");
      out.write("              </div>\n");
      out.write("          \n");
      out.write("              <div class=\"form-group\">\n");
      out.write("                  <input type=\"number\" class=\"form-control\" name=\"price\" placeholder=\"Enter original price\" required/>\n");
      out.write("              </div>\n");
      out.write("          \n");
      out.write("              <div class=\"form-group\">\n");
      out.write("                  <input type=\"number\" class=\"form-control\" name=\"discount\" placeholder=\"Enter discount perecentage\" required/>\n");
      out.write("              </div>\n");
      out.write("            \n");
      out.write("              <div class=\"form-group\">\n");
      out.write("                  <input type=\"number\" class=\"form-control\" name=\"quantity\" placeholder=\"Enter product quantity\" required/>\n");
      out.write("              </div>\n");
      out.write("            \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                <select name=\"catTitle\" class=\"form-control\" id=\"categoryDropdown\">\n");
      out.write("                    ");

                        if (!categories.isEmpty()) {
                            for (String category : categories) {
                    
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( category );
      out.write('"');
      out.write('>');
      out.print( category );
      out.write("</option>\n");
      out.write("                    ");

                            }
                        } else {
                    
      out.write("\n");
      out.write("                            <option value=\"\" disabled>No categories available</option>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("             \n");
      out.write("           \n");
      out.write("              <div class=\"form-group\">\n");
      out.write("                  <label for=\"pic\">Select Product picture</label>\n");
      out.write("                  <br>\n");
      out.write("                  <input type=\"file\" class=\"form-control\" id=\"pic\" name=\"pic\" placeholder=\"Select Product picture\"  required/>\n");
      out.write("              </div>\n");
      out.write("          \n");
      out.write("\n");
      out.write("          \n");
      out.write("                <div class=\"container text-center\">\n");
      out.write("\n");
      out.write("                 <button class=\"btn btn-outline-success\">ADD PRODUCT</button>\n");
      out.write("                 <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                 \n");
      out.write("                 </div>\n");
      out.write("          </form>\n");
      out.write("      </div>\n");
      out.write("             \n");
      out.write("               \n");
      out.write("      <div class=\"modal-footer\">\n");
      out.write("        \n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    <!-- Optional JavaScript; choose one of the two! -->\n");
      out.write("\n");
      out.write("    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("    <!-- Option 2: Separate Popper and Bootstrap JS -->\n");
      out.write("   \n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js\" integrity=\"sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+\" crossorigin=\"anonymous\"></script>\n");
      out.write("    \n");
      out.write("    ");
      out.write("<!-- Button trigger modal -->\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("  .modal-dialog {\n");
      out.write("    width: 80%; /* Set the width of the modal */\n");
      out.write("    max-width: 1000px; /* Set the maximum width of the modal */\n");
      out.write("    height: 80vh; /* Set the height of the modal */\n");
      out.write("    max-height: 600px; /* Set the maximum height of the modal */\n");
      out.write("  }\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Modal -->\n");
      out.write("<div class=\"modal fade\" id=\"cart\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("  <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("    <div class=\"modal-content\">\n");
      out.write("      <div class=\"modal-header\">\n");
      out.write("        <h3 class=\"modal-title\" id=\"exampleModalLabel\">Your Cart</h3>\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\n");
      out.write("        </button>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-body\">\n");
      out.write("      \n");
      out.write("          <div class=\"cart-body\"></div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-footer\">\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("        <button type=\"button\" class=\"btn btn-primary checkout-btn\" onclick=\"gotoCheckout()\"></a>Checkout</button>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"toast\"></div>");
      out.write("\n");
      out.write("    \n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
