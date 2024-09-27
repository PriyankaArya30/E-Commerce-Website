<%@page import="java.lang.String"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
    // Check if the user is logged in
    String login = (String) session.getAttribute("username");
    System.out.println(login);
    boolean isLogin = login != null && !login.isEmpty(); 
    System.out.println(isLogin);
    
    // If not logged in, redirect to the login page
    if (!isLogin) {
        response.sendRedirect("login.html");
    }
%>



<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

    <%@include file="nav_bar.jsp" %>

    <div class="container">
        <div class="row mt-5">
            <div class="col-md-6">
                <div class="card">  
                    <div class="card-body">
                        
                        <h3 class="text-center mb-5">Your Selected Items</h3>
                        <div class="cart-body">
                            
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h1 class="text-center mb-5">Your Details for Order</h1>
                        <form action="#">
                            <div class="form-group">
                                
                                <label for="name">Your Name</label>
                                <input type="text" class="form-control" id="name" aria-describedby="emailHelp" value="<%= session.getAttribute("username") %>">
                            </div>
                                
                            <div class="form-group">
                                <label for="exampleInputEmail1">Email Address</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="<%= session.getAttribute("email") %>">
                               </div>   
                            <div class="form-group">
                                 <label for="Mobile">Mobile Number:</label>
                                <input type="text" class="form-control" id="Mobile" aria-describedby="emailHelp" value="<%= session.getAttribute("mobile") %>">
                            </div>
                                
                            <div class="form-group">
                                <label for="exampleFormControlTextarea1">Your Shipping Address</label>
                                <textarea class="form-control" id="exampleFormControlTextarea1" placeholder="Enter your shipping address" rows="3"></textarea>
                            </div>
                            <div class="container text-center">
                                <button class="btn btn-outline-success">Order Now</button>
                                <button class="btn btn-outline-primary">Continue Shopping</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    
    <%@include file="components/common_css&js.jsp" %>
</body>
</html>
