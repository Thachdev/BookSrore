<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang đăng nhập</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }
        .container {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        input[type="text"],
        input[type="password"],
        input[type="submit"],
        input[type="button"],
        a {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            text-decoration: none;
            text-align: center;
            display: block;
        }
        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            cursor: pointer;
        }
        input[type="button"],
        a {
            background-color: #008CBA;
            color: white;
            cursor: pointer;
        }
    </style>
</head>
<body>
<a href="../">Trang chủ</a>

    <div class="container">
        <% if (request.getAttribute("errorMessage") != null) { %>
	        <div class="error">
	            <%= request.getAttribute("errorMessage") %>
	        </div>
    	<% } %>
        <h2>Đăng nhập</h2>
        <% String s = "../LoginControl";
		    if (request.getAttribute("errorMessage") == null) {
		         s = "../LoginControl";
		    } else {
		    	 s = "./LoginControl";
	    } %>
        <form action="<%=s%>" method="post">
            <div>
                <label for="username">Tên đăng nhập:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div>
                <label for="password">Mật khẩu:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div>
                <input type="submit" value="Đăng nhập">
            </div>
        </form>
        <div>
        	<% if (request.getAttribute("errorMessage") == null) { %>
	        	<a href="register.jsp">Đăng ký</a>
    		<% } else {%>
    			<a href="user/register.jsp">Đăng ký</a>
    		<%} %>
            
        </div>
    </div>
</body>
</html>
