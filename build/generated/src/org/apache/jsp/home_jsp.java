package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.sql.SQLException;
import db.DBConnector;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Base64;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/components/common_css&js.jsp");
    _jspx_dependants.add("/nav_bar.jsp");
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    ");
      out.write("<meta charset=\"utf-8\"> \n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">\n");
      out.write("   <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.4.2/css/fontawesome.min.css\" integrity=\"sha384-BY+fdrpOd3gfeRvTSMT+VUZmA728cfF9Z2G42xpaRkUGu2i3DyzpTURDo5A6CaLK\" crossorigin=\"anonymous\">\n");
      out.write("    \n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.7.1.min.js\" integrity=\"sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct\" crossorigin=\"anonymous\"></script>\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <title>MYCart</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        .discount-label{\r\n");
      out.write("            font-size: 10px!important;\r\n");
      out.write("            font-style: italic!important;\r\n");
      out.write("            text-decoration: line-through!important;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        .product-card:hover{\r\n");
      out.write("           background: #e2e2e2;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            \r\n");
      out.write("        }\r\n");
      out.write("    #toast {\r\n");
      out.write("        display: none;\r\n");
      out.write("        position: fixed;\r\n");
      out.write("        bottom: 10px;\r\n");
      out.write("        left: 50%;\r\n");
      out.write("        transform: translateX(-50%);\r\n");
      out.write("        background-color: #000;\r\n");
      out.write("        color: #fff;\r\n");
      out.write("        padding: 15px;\r\n");
      out.write("        border-radius: 5px;\r\n");
      out.write("        z-index: 1000;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #toast.display {\r\n");
      out.write("        display: block;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.4.2/css/fontawesome.min.css\" integrity=\"sha384-BY+fdrpOd3gfeRvTSMT+VUZmA728cfF9Z2G42xpaRkUGu2i3DyzpTURDo5A6CaLK\" crossorigin=\"anonymous\">\n");
      out.write("    <!-- Font Awesome CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css\">\n");
      out.write("    <title>MYCart</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\"> MYCart</a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"home.jsp\">Home <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"about.html\">About us <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    \n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">Contact us <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    \n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"#!\" data-toggle=\"modal\" data-target=\"#cart\"><i class=\"fas fa-shopping-cart\"></i><span class=\"ml-0 cart-items\">(0)</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    \n");
      out.write("                </ul>\n");
      out.write("                <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                    ");
 String loggedIn = (String) session.getAttribute("username"); 
      out.write("\n");
      out.write("                    ");
 boolean isLoggedIn = loggedIn != null && !loggedIn.isEmpty(); 
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 if (isLoggedIn) {
                       if(loggedIn=="admin"){
                           
      out.write("\n");
      out.write("                           <li class=\"nav-item active\">\n");
      out.write("                               <a class=\"nav-link\" href=\"admin.jsp\"><i class=\"fas fa-user\"></i>");
      out.print( loggedIn);
      out.write("</a>\n");
      out.write("                        </li>\n");
      out.write("                        ");
                      
   } else if(loggedIn!=null && loggedIn!="admin"&& !loggedIn.isEmpty()){
      out.write("\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <a class=\"nav-link\" href=\"profile.jsp\"><i class=\"fas fa-user\"></i> Your Profile</a>\n");
      out.write("                        </li>\n");
      out.write("                    ");
 } else { 
      out.write("\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <a class=\"nav-link\" href=\"login.html\">Login</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <a class=\"nav-link\" href=\"register.html\">Register</a>\n");
      out.write("                        </li>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct\" crossorigin=\"anonymous\"></script>\n");
      out.write("    \n");
      out.write("    <script src=\"script.js\">\n");
      out.write("       \n");
      out.write("    </script>\n");
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
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    ");

        List<String> categoryIds = new ArrayList<>();
        List<String> categoryTitles = new ArrayList<>();
        List<Map<String, Object>> products = new ArrayList<>();

        Connection con = null;
        Statement st = null;
        ResultSet rs1 = null;
        ResultSet rs = null;

        try {
            con = DBConnector.getConnection();
            st = con.createStatement();

            String query = "SELECT * FROM category";
            rs1 = st.executeQuery(query);

            while (rs1.next()) {
                String categoryId = rs1.getString("c_id");
                String categoryTitle = rs1.getString("c_title");
                categoryIds.add(categoryId);
                categoryTitles.add(categoryTitle);
            }

            // Retrieve product details based on the selected category
            String selectedCategory = request.getParameter("categoryTitle");
            String productQuery;

            if (selectedCategory == null || selectedCategory.equals("all")) {
                productQuery = "SELECT * FROM product";
            } else {
                productQuery = "SELECT * FROM product WHERE c_title='" + selectedCategory + "'";
            }

            ResultSet productResultSet = st.executeQuery(productQuery);
            while (productResultSet.next()) {
                Map<String, Object> product = new HashMap<>();
                product.put("productId", productResultSet.getString("p_id"));
                product.put("productName", productResultSet.getString("p_title"));
                product.put("productDescription", productResultSet.getString("p_desc"));
                product.put("productPrice", productResultSet.getString("p_price"));
                product.put("productDiscount", productResultSet.getString("p_discount"));
                

                byte[] imageBytes = productResultSet.getBytes("p_photo"); // Assuming 'p_photo' is the column name for the image
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                product.put("productImage", base64Image);

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"row mt-3 mx-2\">\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            <div class=\"col-md-2\">\r\n");
      out.write("                <div class=\"list-group mt-4\">\r\n");
      out.write("                    <a href=\"home.jsp?categoryTitle=all\" class=\"list-group-item list-group-item-action");
      out.print( (request.getParameter("categoryTitle") == null || request.getParameter("categoryTitle").equals("all")) ? " active" : "" );
      out.write("\">\r\n");
      out.write("                       All Products\r\n");
      out.write("                    </a>\r\n");
      out.write("                    ");
      out.write("\r\n");
      out.write("                    ");

                    for (int i = 0; i < categoryIds.size(); i++) {
                     
      out.write("\r\n");
      out.write("                         <a href=\"home.jsp?categoryTitle=");
      out.print(categoryTitles.get(i));
      out.write("\" class=\"list-group-item list-group-item-action");
      out.print( categoryTitles.get(i).equals(request.getParameter("categoryTitle")) ? " active" : "" );
      out.write("\">\r\n");
      out.write("                             ");
      out.print(categoryTitles.get(i));
      out.write("\r\n");
      out.write("                         </a>\r\n");
      out.write("                     ");

                     }
                    
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            <div class=\"col-md-10\">\r\n");
      out.write("                <div class=\"row mt-4\">\r\n");
      out.write("                    <div class=\"col-md-12\">\r\n");
      out.write("                        <div class=\"card-columns\">\r\n");
      out.write("                            ");

                                for (Map<String, Object> product : products) {
                            
      out.write("\r\n");
      out.write("                            <div class=\"card product-card\">\r\n");
      out.write("                                <div class=\"container text-center\">\r\n");
      out.write("                                    <img src=\"data:image/jpeg;base64, ");
      out.print( product.get("productImage") );
      out.write("\" style=\"max-height: 200px;max-width: 100%;width: auto;\" class=\"card-img-top m-2\" alt=\"");
      out.print( product.get("productName") );
      out.write("\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"card-body\">\r\n");
      out.write("                                    <h5 class=\"card-title\">");
      out.print( product.get("productName") );
      out.write("</h5>\r\n");
      out.write("                                    <p class=\"card-text\">");
      out.print( product.get("productDescription") );
      out.write("</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                \r\n");
      out.write("                                                       ");

    // Assuming productDiscount and productPrice are stored as Strings in the product map
    String productDiscountStr = (String) product.get("productDiscount");
    String productPriceStr = (String) product.get("productPrice");

    // Parse Strings to integers
    int productDiscount = Integer.parseInt(productDiscountStr);
    int productPrice = Integer.parseInt(productPriceStr);

    // Calculate discounted price
    int discountAmount = (int) ((productDiscount / 100.0) * productPrice);
    int discountedPrice = productPrice - discountAmount;



      out.write("\r\n");
      out.write("                                \r\n");
      out.write("                                <div class=\"card-footer text-center\">\r\n");
      out.write("                                    <button class=\"btn btn-primary text-white\" onclick=\"add_to_cart(");
      out.print(product.get("productId"));
      out.write(',');
      out.write('\'');
      out.print(product.get("productName"));
      out.write('\'');
      out.write(',');
      out.print( discountedPrice);
      out.write(")\">Add to Cart</button>\r\n");
      out.write("                                    \r\n");
      out.write("       \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    \r\n");
      out.write("                                    <button class=\"btn btn-outline-success text-dark\">Price = &#8377; ");
      out.print( discountedPrice);
      out.write("/- <span class=\"text-secondary discount-label\"> &#8377; ");
      out.print( product.get("productPrice"));
      out.write(',');
      out.print(product.get("productDiscount"));
      out.write("% off</span></button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            ");

                                }
                                    if(products.size()==0)
                                    {
                                        out.println("<h3>No item in this category!</h3>");
                                    }
                            
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"script.js\"></script>\r\n");
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
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
 }} catch (Throwable t) {
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
