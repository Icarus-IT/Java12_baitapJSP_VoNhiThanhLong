<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Page</title>
<link rel="stylesheet" href="styles.css">
<link rel="shortcut icon" href="visualstudio_icon_188909.ico"
	type="image/x-icon">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body style="margin: 1%">
	<h1 class="text-red">Quản Lý Sản Phẩm</h1>
	<form action="ProductServlet" method="post">
		<p>Tên sản phẩm:</p>
		<input type="text" name="tenSanPham" />
		<p>Số lượng</p>
		<input type="number" name="quantity" />
		<p>Giá bán</p>
		<input  type="number" step="0.01" name="price" /> </br></br>
		
		<button type="submit" class="btn btn-primary">Lưu lại</button> </br>
		<c:if test="${requestScope.SUCCESS ne null }">

			<font color="green"> ${requestScope.SUCCESS} </font>
		</c:if>
		<c:if test="${requestScope.FAIL ne null }">

			<font color="red"> ${requestScope.FAIL} </font>
		</c:if>
	</form>
	</br> 
	<table class="table table-bordered">
		<thead class="table-dark">
			<tr>
				<th>STT</th>
				<th>Tên Sản Phẩm</th>
				<th>Số Lượng</th>
				<th>Giá Bán</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${LIST}" varStatus="loopStatus">
				<tr>
					<td>${loopStatus.count }</td>
					<td>${product.tenSanPham }</td>
					<td>${product.soLuong }</td>
					<td>${product.giaBan }</td>


				</tr>
			</c:forEach>

		</tbody>
	</table>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>
