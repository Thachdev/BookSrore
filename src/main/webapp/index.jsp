<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
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
        .books-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }
        .book {
            width: calc(30% - 20px);
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            background-color: #fff;
            margin-bottom: 20px;
        }
        .book-info {
            margin-bottom: 10px;
        }
        .book-title {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .book-price {
            font-size: 16px;
            color: #333;
        }
        .book-image {
            width: 100%;
            height: auto;
            margin-bottom: 10px;
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
            <a href="user/login.jsp" class="btn">Đăng nhập</a>
            <a href="user/register.jsp" class="btn">Đăng ký</a>
        </div>
        <h1>Danh sách sách</h1>
        <div class="books-container">
        <c:forEach items="${listP}" var="o">
            <div class="book">
            	<img src="${o.image}" alt="Hình minh họa" width="200" height="300" style="border: 1px solid black;">
                <div class="book-info">
                    <div class="book-title">${o.name}</div>
                    <div class="book-price">${o.price} VND</div>
                </div>
                <button class="btn">Thêm vào giỏ hàng</button>
            </div>
        </c:forEach>
            
        </div>
    </div>
</body>
</html>
