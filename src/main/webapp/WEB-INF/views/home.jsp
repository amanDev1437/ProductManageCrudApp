<html>
<head>

<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


</head>

<body>

 <div class="container mt-3">

 <div class="row">

 <div class="col-md-12">

 <h1 class="text-center mb-3">Welcome to Product App</h1>

 <table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Product Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>

   <c:forEach items="${product }" var="p">


    <tr>
      <td>${p.pid }</th>
      <td>${p.productName }</td>
      <td>${p.description}</td>
      <td class="font-weight-bold">&#8377; ${p.price }</td>
    <td>
    <a href="delete/${p.pid }"><i class="fa-solid fa-trash text-danger margin-10"></i></i></a>
    <a href="update/${p.pid }"><i class="fas fa-pen-nib text-primary"></i></a>

    </td>
    </tr>
   </c:forEach>
  </tbody>
</table>

 </div>

 <div class="container text-center">

 <a href="addProduct" class="btn btn-outline-success">Add Product</a>
 <a href="logout" class="btn btn-outline-success">Log Out</a>

 </div>


 </div>


 </div>

</body>
</html>