<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>
    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding-top: 20px;
        }

        .container {
            max-width: 600px;
            margin: auto;
        }

        h1 {
            color: #333;
        }

        label {
            display: block;
            margin-top: 10px;
            color: #333;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        .btn-update {
            background-color: #4caf50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn-update:hover {
            background-color: #45a049;
        }

        .btn-logout {
            background-color: #d9534f;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn-logout:hover {
            background-color: #c9302c;
        }
    </style>
</head>
<body>
    <div class="container">
        <div>
            <h1><i class="fas fa-user"></i>  <%= session.getAttribute("username") %></h1>
            
            <p>Email: <%= session.getAttribute("email") %></p>
            <p>Mobile: <%= session.getAttribute("mobile") %></p>
            <p>Address: <%= session.getAttribute("address") %></p>
        </div>

        <!-- Edit Profile Form -->
        <form action="EditProfileServlet" method="post">
            <h3>Edit Profile</h3>
            
            <label for="newUsername">New Username:</label>
            <input type="text" id="newUsername" name="newUsername" value="<%= session.getAttribute("username") %>">
            
            <label for="newEmail">New Email:</label>
            <input type="text" id="newEmail" name="newEmail" value="<%= session.getAttribute("email") %>">
            
            <label for="password">Password</label>
            <input type="password" id="password" name="password">
            
            <label for="newPassword">New Password</label>
            <input type="Password" id="newPassword" name="newPassword" >
            
            <label for="newMobile">New Mobile:</label>
            <input type="text" id="newMobile" name="newMobile" value="<%= session.getAttribute("mobile") %>">
            
            <label for="newAddress">New Address:</label>
            <input type="text" id="newAddress" name="newAddress" value="<%= session.getAttribute("address") %>">
            <br>
            <br>
            <div>
                <button type="submit" class="btn-update">Update Profile</button>
            </div>
        </form>
            <br>
        <!-- Logout Form -->
        <form action="LogoutServlet" method="post">
            <div>
                <button type="submit" class="btn-logout">Logout</button>
            </div>
        </form>
    </div>

    <!-- Bootstrap JavaScript dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</body>
</
