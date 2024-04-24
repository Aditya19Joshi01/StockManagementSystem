<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body >

<div class="container content" >

<h2 style="padding-top: 30px">Product List</h2>
<%@include file="businessMessage.jsp" %>
<table class="table bg-light text-dark" style="margin-top: 20px;">
  <thead>
    <tr>
      <th scope="col">Product Name</th>
      <th scope="col">quantity</th>
      <th scope="col">price</th>
      <th scope="col">Image</th>   
       <c:if test="${sessionScope.user.userRole == 'Admin'}">  
      <th scope="col">Action</th>
      </c:if>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="li" varStatus="u">
    <tr>     
      <td>${li.name}</td>
      <td>${li.quantity}</td>
      <td>${li.price}</td>
      <td><img alt="" src="${pageContext.request.contextPath}/getProductImage/${li.id}" width="150px" height="100px" ></td> 
       <c:if test="${sessionScope.user.userRole == 'Admin'}">
      <td>    
        
      <a href="${pageContext.request.contextPath}/productEdit?id=${li.id}"><i class="fas fa-pen"></i></a>
      <a href="${pageContext.request.contextPath}/productDelete?id=${li.id}"><i class="fas fa-trash"></i></a>      
      </td>
      </c:if>
    </tr>
   </c:forEach>
  </tbody>
</table>

</div>

</body>
</html>