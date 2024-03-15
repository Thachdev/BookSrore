<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ hàng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .total {
            font-weight: bold;
            text-align: right;
        }
        .btn-back {
            background-color: #008CBA;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="container">
	<%String s = (String) request.getAttribute("name"); %>
    <a href="./BackCart?user=<%=s%>" class="btn-back">Quay lại</a>
    <h2>Giỏ hàng của <%=s %></h2>
    <script>
	var username ='<%=s%>';
    function deleteItem(itemName) {
        var url = './DeleteItemControl?username=' + encodeURIComponent(username) +
                  '&itemName=' + encodeURIComponent(itemName);
        window.location.href = url;
    }
</script>
    <table>
        <thead>
            <tr>
                <th>Hình ảnh</th>
                <th>Tên sách</th>
                <th>Giá sách</th>
                
            </tr>
        </thead>
        <tbody id="cart-items">
            <!-- Các mục giỏ hàng sẽ được thêm vào đây -->
            <c:set var="totalPrice" value="0" />
            <c:forEach items="${cartItems}" var="item">
                <tr>
                    <td><img src="${item.image}" width="200" height="300"></td>
                    <td>${item.namebook}</td>
                    <td>${item.price} VND</td>
					<td><button onclick="deleteItem('${item.namebook}')" class="btn">Xóa</button></td>
                </tr>
                <c:set var="totalPrice" value="${totalPrice + item.price}" />
            </c:forEach>
           
        </tbody>
        <tfoot>
            <tr>
                <td colspan="4" class="total">Tổng tiền giỏ hàng:</td>
                <td>${totalPrice} VND</td>
            </tr>
        </tfoot>
    </table>
</div>

</body>
</html>
