<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="db.DBConnector"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="components/common_css&js.jsp" %>
    <title>MYCart</title>
    <style>
        .discount-label{
            font-size: 10px!important;
            font-style: italic!important;
            text-decoration: line-through!important;
        }
        
        .product-card:hover{
           background: #e2e2e2;
            cursor: pointer;
            
        }
    #toast {
        display: none;
        position: fixed;
        bottom: 10px;
        left: 50%;
        transform: translateX(-50%);
        background-color: #000;
        color: #fff;
        padding: 15px;
        border-radius: 5px;
        z-index: 1000;
    }

    #toast.display {
        display: block;
    }

        
    </style>
</head>
<body>
    <%@include file="nav_bar.jsp" %>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.List" %>

    <%
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
    %>

    <div class="container-fluid">
        <div class="row mt-3 mx-2">
            <%-- Show categories --%>
            <div class="col-md-2">
                <div class="list-group mt-4">
                    <a href="home.jsp?categoryTitle=all" class="list-group-item list-group-item-action<%= (request.getParameter("categoryTitle") == null || request.getParameter("categoryTitle").equals("all")) ? " active" : "" %>">
                       All Products
                    </a>
                    <%-- Loop through categories and generate links --%>
                    <%
                    for (int i = 0; i < categoryIds.size(); i++) {
                     %>
                         <a href="home.jsp?categoryTitle=<%=categoryTitles.get(i)%>" class="list-group-item list-group-item-action<%= categoryTitles.get(i).equals(request.getParameter("categoryTitle")) ? " active" : "" %>">
                             <%=categoryTitles.get(i)%>
                         </a>
                     <%
                     }
                    %>
                </div>
            </div>

            <%-- Show products with images --%>
            <div class="col-md-10">
                <div class="row mt-4">
                    <div class="col-md-12">
                        <div class="card-columns">
                            <%
                                for (Map<String, Object> product : products) {
                            %>
                            <div class="card product-card">
                                <div class="container text-center">
                                    <img src="data:image/jpeg;base64, <%= product.get("productImage") %>" style="max-height: 200px;max-width: 100%;width: auto;" class="card-img-top m-2" alt="<%= product.get("productName") %>">
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title"><%= product.get("productName") %></h5>
                                    <p class="card-text"><%= product.get("productDescription") %></p>
                                </div>
                                
                                                       <%
    // Assuming productDiscount and productPrice are stored as Strings in the product map
    String productDiscountStr = (String) product.get("productDiscount");
    String productPriceStr = (String) product.get("productPrice");

    // Parse Strings to integers
    int productDiscount = Integer.parseInt(productDiscountStr);
    int productPrice = Integer.parseInt(productPriceStr);

    // Calculate discounted price
    int discountAmount = (int) ((productDiscount / 100.0) * productPrice);
    int discountedPrice = productPrice - discountAmount;


%>
                                
                                <div class="card-footer text-center">
                                    <button class="btn btn-primary text-white" onclick="add_to_cart(<%=product.get("productId")%>,'<%=product.get("productName")%>',<%= discountedPrice%>)">Add to Cart</button>
                                    
       


                                    
                                    <button class="btn btn-outline-success text-dark">Price = &#8377; <%= discountedPrice%>/- <span class="text-secondary discount-label"> &#8377; <%= product.get("productPrice")%>,<%=product.get("productDiscount")%>% off</span></button>
                                </div>
                            </div>
                            <%
                                }
                                    if(products.size()==0)
                                    {
                                        out.println("<h3>No item in this category!</h3>");
                                    }
                            %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="script.js"></script>
    <%@include file="components/common_modals.jsp" %>
</body>
</html>
