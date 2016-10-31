<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="n" %>
<%@page import="Servion.UserBean"%>
<%@page import="Servion.UserEntity"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="Servion.SessionUtility"%>
<%@page import="org.hibernate.Session"%>
<%@page import="Servion.ProductDescBean"%>
<html>
<head>	<script>
		function validate() 
		{
			var x = document.forms["search"]["keyword"].value;
		   	if(x==""||x==null)
		   	{
		   		alert("Please enter a keyword to search");
				return false;
		   	}
		}
		function cart() 
		{
			alert("Item Added to Cart");
			
		}
		function wish() 
		{
			alert("Item Added to Wishlist");
			
		}
	</script>
<title>Free Style A New ShoeWorld | Home :: Servion</title>
<link href="<n:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<n:url value="/resources/js/jquery-1.11.0.min.js"/>"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="<n:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Free Style Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script type="text/javascript" src="<n:url value="/resources/js/move-top.js"/>"></script>
<script type="text/javascript" src="<n:url value="/resources/js/easing.js"/>"></script>
<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>	
<!-- start menu -->
<script src="<n:url value="/resources/js/simpleCart.min.js"/>"> </script>
<link href="<n:url value="/resources/css/memenu.css"/>" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<n:url value="/resources/js/memenu.js"/>"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>				
</head>
<body> 
	<!--top-header-->
	<div class="top-header">
	<div class="container">
		<div class="top-header-main">
			<div class="col-md-4 top-header-left">
				<div class="search-bar">
				<input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
					<input type="submit" value="">
				</div>
			</div>
			<div class="col-md-4 top-header-middle">
				<a href="index.html"><img src="<n:url value="/resources/images/logo-4.png"/>" alt="" /></a>
			</div>
			<div class="col-md-4 top-header-right">
				<div class="cart box_1">
						<a href="checkout.html">
						<h3> <div class="total">
							<span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> items)</div>
							<img src="<n:url value="/resources/images/cart-1.png"/>" alt="" />
						</a>
						<p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>
						<div class="clearfix"> </div>
					</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!--top-header-->
	<!--bottom-header-->
	<div class="header-bottom">
		<div class="container">
			<div class="top-nav">
				<ul class="memenu skyblue"><li class="active"><a href="home">Home</a></li>
					<li class="grid"><a href="men">Men</a>
						
					<li class="grid"><a href="women">Women</a>
						<li class="grid"><a href="kid">Kids</a>
					</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--bottom-header-->
	<!--start-breadcrumbs-->
	<div class="breadcrumbs">
		<div class="container">
			<div class="breadcrumbs-main">
				<ol class="breadcrumb">
					<li><a href="index.html">Home</a></li>
					<li class="active">Men</li>
				</ol>
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
	<!--start-product--> 
	
			<div class="product">
			<div class="container">
				<div class="product-main">
					<n:forEach var="pro" items="${product}">
						<div class="col-md-9 p-left">
							<div class="product-one">
								<div class="col-md-4 product-left single-left"> 
									<div class="p-one simpleCart_shelfItem">
										<img src="${pro.getP_img()}" width="100" height="100"/>
										
									</div>
									<h4>${pro.getP_name()}
									</h4>	
									<h4>Rs ${pro.getP_price()}
									</h4>
									<p>${pro.getP_desc()}
									</p>
									<spring:form action="additem" method="post" commandName="iBean" onsubmit="return cart()">
												<spring:hidden path="id" value="${obj.getPid()}"/>
												<spring:hidden path="name" value="${obj.getP_name()}"/>
												<spring:hidden path="price" value="${obj.getP_price() }"/>
												<spring:hidden path="view" value="index"/>
												<input  type="submit" value="Add to Cart" class="btn btn-default add-to-cart"/>
											</spring:form></div>
							</div>
						</div>
					</n:forEach>
									
				</div>
				
			</div>
		</div>
				
				
	<!--end-product-->
			<!--start-footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-top">
					<div class="footer-top">
					
				</div>
				<div class="col-md-3 footer-left">
					<h3>ABOUT US</h3>
					<ul>
						<p>We Are New Trend Setter</p>
						<p>With Large Collection of</p>
						<p>New Branded Shoes for</p>
						<p>Men Women and Kids</p>
					</ul>
				</div>
			
				<div class="col-md-3 footer-left">
					<h3>CUSTOMER SERVICES</h3>
					<ul>
						<li>Call +91 44 123456</li>
						<li>Toll Free 1800 180 120 33</li>
						<li>Mail cs@freestyle.in</li>
											 
					</ul>
				</div>
				<div class="col-md-3 footer-left">
					<h3>CATEGORIES</h3>
					<ul>
						<li><a href="men">Men Shoes</a></li>
						<li><a href="women">Women Shoes</a></li>
						<li><a href="kid">Kids Shoes</a></li>
						</ul>
				</div>
				<div class="col-md-3 footer-left">
					<h3>YOUR ACCOUNT</h3>
					<ul>
						<li><a href="account">Your Account</a></li>
						</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--end-footer-->
	<!--end-footer-text-->
	<div class="footer-text">
		<div class="container">
			<div class="footer-main">
				<p class="footer-class">© 2015 Free Style All Rights Reserved | Design by  <a href="http://servion.com" target="_blank">Servion</a> </p>
			</div>
		</div>
		<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										*/
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
		<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	</div>
	<!--end-footer-text-->	
</body>
</html>