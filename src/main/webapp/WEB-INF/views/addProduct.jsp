<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
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
			<h1 class="text-center mb-3">Fill the product Details</h1>

			<form action="handleProduct" method="post">
				<div class="form-group">
					<label for="Name">Product Name</label>
					<input type="text"
						class="form-control"
						id="name"
						aria-describedby="emailHelp"
						name="productName"
						placeholder="Enter product name here" required="required">
				</div>

				<div class="form-group">
					<label for="Description">Product description</label>
					<textarea class="form-control"
					name="description"
					id="description" rows="5"
						placeholder="Enter product description"
						required="required"></textarea>
				</div>
				<div class="form-group">
				<label for="price">Product Price</label>
					<input type="text"
					class="form-control"
					name="price" id="price"
					required="required">

				</div>

				<div class="container text-center">
					<a href="/home"
					class="btn btn-danger mb-3">Back</a>
					<button type="submit"
					class="btn btn-primary mb-3">Add Product</button>
				</div>

			</form>

</div>
		</div>

	</div>

</body>
</html>