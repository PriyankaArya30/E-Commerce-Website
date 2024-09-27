<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    
    <title>Admin Panel</title>
    
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #333;
        }

        .btn-logout {
            background-color: dodgerblue;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            position: absolute;
            top: 10px;
            right: 30px;
        }

        .btn-logout:hover {
            background-color: #4CAF50;
        }

        .profile-container {
            position: absolute;
            top: 10px;
            right: 150px;
            display: flex;
            align-items: center;
        }

        .profile-icon {
             background-color:dodgerblue;
            
            color: whitesmoke;
            font-size: 40px; /* Adjust the size as needed */
            margin-right: 8px;
        }

        .username {
            color: white;
            font-size: 30px; /* Adjust the size as needed */
        }

        .admin .card {
            border: 1px solid #673ab7;
        }

        .admin .card:hover {
            background: #e2e2e2;
            cursor: pointer;
        }
    </style>
    
  </head>
  <body>
      
                <%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="db.DBConnector" %>

<%
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
%>
      
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
        <a class="navbar-brand" href="#">MYCart</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="about.html">About us <span class="sr-only">(current)</span></a>
              </li>
           
              <li>
                  <li class="nav-item active">
                <a class="nav-link" href="#">Contact us <span class="sr-only">(current)</span></a>
              </li>
              
              <li class="nav-item active">
                        <a class="nav-link" href="#!" data-toggle="modal" data-target="#cart"><i class="fas fa-shopping-cart"></i><span class="ml-0 cart-items">(0)</span></a>
                    </li>
              
          </ul>
         
          <ul class="navbar-nav ml-auto">
             <form action="LogoutServlet" method="post">
            <div class="profile-container">
                <i class="fas fa-user-circle profile-icon"></i>
                <span class="username"><%= session.getAttribute("username") %></span>
                
                
                
            </div>
            <button type="submit" class="btn-logout">Logout</button>
        </form>
          </ul>
        </div>
    </div>
      </nav>
  
      <div class="container admin">
          <div class="row mt-3">
              <div class="col-md-4">
                  
                  <div class="card">
                      <div class="card body text-center">
                          
                            <div class="container">
                              <img style="max-width: 125px;" class="img-fluid" src="img/group.png" alt="user_icon">
                              </div>
                          
                          <h4><%= userCount%></h4>
                          <h3 class="text-muted">USERS</h3>
                          </div>
                      </div>
                  
                  </div>
               <div class="col-md-4">
                    
                    <div class="card">
                      <div class="card body text-center">
                          
                             <div class="container">
                              <img style="max-width: 125px;" class="img-fluid" src="img/delivery-box.png" alt="user_icon">
                              </div>
                          
                          
                          <h4><%= productCount%></h4>
                          <h3 class="text-muted">PRODUCTS</h3>
                          </div>
                      </div>
                  
                  </div>
               <div class="col-md-4">
                  
                    <div class="card">
                      <div class="card body text-center">
                          
                           <div class="container">
                              <img style="max-width: 125px;" class="img-fluid" src="img/options.png" alt="user_icon">
                              </div>
                          
                        
                          
                           <h4><%= categories.size()%></h4>
                          <h3 class="text-muted">CATEGORIES</h3>
                          </div>
                      </div>
                  
                  </div>
              </div>
          
                 <div class="row mt-3">
                     
                     <div class="col-md-6">
                         
                          
                  <div class="card" data-toggle="modal" data-target="#add-product-modal">
                      <div class="card body text-center">
                          
                            <div class="container">
                              <img style="max-width: 125px;" class="img-fluid" src="img/add-product.png" alt="user_icon">
                              </div>
                          
                          <p class="mt-2">click here<p>
                          <h3 class="text-muted">ADD PRODUCT</h3>
                          </div>
                      </div>
                  
                         
                         </div>
                     
                      <div class="col-md-6">
                          
                           
                  <div class="card" data-toggle="modal" data-target="#add-category-modal">
                      <div class="card body text-center">
                          
                            <div class="container">
                              <img style="max-width: 125px;" class="img-fluid" src="img/checklist.png" alt="user_icon">
                              </div>
                          
                          <p class="mt-2">click here<p>
                          <h3 class="text-muted">ADD CATEGORY</h3>
                          </div>
                      </div>
                  
                          
                         
                         </div>
                     
                     </div>
          </div>

          
          <!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="add-category-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header custom-bg text-dark">
        <h5 class="modal-title" id="exampleModalLabel">Enter Category detail</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
            
          <form action="CategoryServlet" method="post">
              
              <div class="form-group">
                  <input type="number" class="form-control" name="catId" placeholder="Enter category ID" required/>
              </div>
              
              <div class="form-group">
                  <input type="text" class="form-control" name="catTitle" placeholder="Enter category title" required/>
              </div>
                   
               <div class="form-group">
                    <textarea style="height: 200px" class="form-control" placeholder="Enter category description" name="catDescription" required></textarea> 
                </div>
              
              <div class="container text-center">
                  <button class="btn btn-outline-success">Add Category</button>
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                  </div>
              
              </form>
      </div>
      <div class="modal-footer">
        

      </div>
    </div>
  </div>
</div>

     <!-- Button trigger modal -->


      <!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="add-product-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content ">
      <div class="modal-header custom-bg text-dark">
        <h5 class="modal-title" id="exampleModalLabel">Enter Product detail</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
<form action="ProductServlet" method="post" enctype="multipart/form-data">
               <div class="form-group">
                  <input type="number" class="form-control" name="pId" placeholder="Enter Product ID" required/>
              </div>
          
              <div class="form-group">
                  <input type="text" class="form-control" name="pname" placeholder="Enter title" required/>
              </div>
          
              <div class="form-group">
                  <textarea style="height:100px;" class="form-control" name="pabout" placeholder="Enter about product" required></textarea>
              </div>
          
              <div class="form-group">
                  <input type="number" class="form-control" name="price" placeholder="Enter original price" required/>
              </div>
          
              <div class="form-group">
                  <input type="number" class="form-control" name="discount" placeholder="Enter discount perecentage" required/>
              </div>
            
              <div class="form-group">
                  <input type="number" class="form-control" name="quantity" placeholder="Enter product quantity" required/>
              </div>
            
                        <div class="form-group">
                <select name="catTitle" class="form-control" id="categoryDropdown">
                    <%
                        if (!categories.isEmpty()) {
                            for (String category : categories) {
                    %>
                                <option value="<%= category %>"><%= category %></option>
                    <%
                            }
                        } else {
                    %>
                            <option value="" disabled>No categories available</option>
                    <%
                        }
                    %>
                </select>
            </div>

             
           
              <div class="form-group">
                  <label for="pic">Select Product picture</label>
                  <br>
                  <input type="file" class="form-control" id="pic" name="pic" placeholder="Select Product picture"  required/>
              </div>
          

          
                <div class="container text-center">

                 <button class="btn btn-outline-success">ADD PRODUCT</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                 
                 </div>
          </form>
      </div>
             
               
      <div class="modal-footer">
        

      </div>
    </div>
  </div>
</div>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
   
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    
    <%@include file="components/common_modals.jsp" %>
    
  </body>
</html>