<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Sách</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
        }
        form {
            margin-bottom: 20px;
        }
        input[type="text"], input[type="number"], input[type="file"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #008CBA;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #005f6b;
        }
		.btn {
            padding: 8px 16px;
            background-color: #008CBA;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container">
    	<div class="btn-container">
            <a href="../admin" class="btn">Trở lại</a>
        </div>
        <h1>Thêm Sách</h1>
        <form action="../AddControl" method="post">
        	<label for="book_name">Tên Sách:</label>
            <input type="text" id="book_name" name="book_name" required>

            <label for="book_price">Giá:</label>
            <input type="number" id="book_price" name="book_price" required>

            <label for="book_image">Link ảnh:</label>
            <input type="text" id="book_image" name="book_image" required>

            <input type="submit" value="Thêm Sách">
        </form>
    </div>
</body>
</html>
