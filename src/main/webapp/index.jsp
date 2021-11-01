<%@page import="com.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Job portal</title>
<%@ include file="all_component/all_css.jsp" %>
<style type="text/css">
.back-img{
	background: url("img/1.png");
	width:100%;
	height:86vh;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>

<% Connection conn =DBConnect.getConnction();
//out.println(conn);
%>

<div class="container-fluid back-img">
	<div class="text-center">
		<h1 class="text-while p-4">
			<i class="fa fa-book" aria-hidden="true"></i> Online JOb Portal
		</h1>
	</div>
</div>

<%@include file="all_component/footer.jsp" %>
</body>
</html>