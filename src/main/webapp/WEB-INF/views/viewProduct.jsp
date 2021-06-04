<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="<c:url value="/resources/js/controller.js" /> "></script>

<div class="container-wrapper">
	<div class="container" ng-app="cartApp">
		<h1>Product Detail</h1>
		<p class="lead">Here is the detail information of the product!</p>
		<div class="row" ng-controller="cartCtrl">
			<%-- <div class="col-md-6">
				<c:set var="imageFilename"
					value="/resources/images/${product.id}.jpg" />
				<img src="<c:url value="${product.imageFilename}" />" alt="image"
					style="width: 80%" />

			</div> --%>
			<div class="col-md-6">
				<img
					src="<c:url value="/resources/images/${product.imageFilename}" />"
					alt="image" style="width: 80%" />
			</div>
			<div class="col-md-6">
				<h3>${product.name}</h3>
				<p>
					<strong style="color: #52A4E4"> Description : </strong>
					${product.description}
				</p>
				<p>
					<strong style="color: #52A4E4"> Manufacturer : </strong>
					${product.manufacturer}
				</p>
				<p>
					<strong style="color: #52A4E4"> Category : </strong>
					${product.category}
				</p>
				<p>
					<strong style="color: #52A4E4"> Price : </strong>
					<fmt:formatNumber value="${product.price}" pattern="#,###"/>원
				</p>
				
				<p>
					<a href="<c:url value="/products" />" class="btn btn-danger">Back</a>

					<button class="btn btn-warning btn-large"
						ng-click="addToCart('${product.id}')">
						<i class="fas fa-shopping-cart"></i>Order Now
					</button>

					<a href="<c:url value="/cart" />" class="btn btn-info"> <i
						class="fas fa-eye"></i> View Cart
					</a>
				</p>
			</div>

			<div style="width: 100%">
				<div style="float: right">
					<a href="<c:url value="/admin/productInventory"/>" class="btn btn-outline-success"> 목록으로 </a>
				</div>
			</div>
		</div>
	</div>
</div>