<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>

	<div class="container mt-3">

	<div class="row">

	<div class ="col-md-6 offset-md-3">
			<h1 class="text-center mb-3">Change Product Details</h1>

				<form action="/handleProduct" method="post">
			   <input type="hidden" value="${product.pid}" name="pid" />
				<div class="form-group">
					<label for="productName">Product Name</label> <input type="text"
						class="form-control" id="productName" aria-describedby="emailHelp"
						name="productName" placeholder="Enter product name here" value="${product.productName}">
				</div>

				<div class="form-group">
					<label for="Description">Product description</label>
					<textarea class="form-control"
					name="description"
					id="description" rows="5"
						placeholder="Enter product description">${product.description }
				      </textarea>
				</div>


				<div class="form-group">
				<label for="price">Product Price</label>
					<input type="text"
					class="form-control"
					name="price" id="price" value="${product.price }">


				</div>

				<div class="container text-center">
					<a href="/home"
					class="btn btn-danger mb-3">Back</a>
					<button type="submit"
					class="btn btn-warning mb-3">Update Product</button>
				</div>

			</form>

</div>
		</div>

	</div>

</body>
</html>