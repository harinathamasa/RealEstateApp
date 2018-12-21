<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
</head>
<body style="padding-left: 200px;padding-top: 20px">
<c:if test="${empty recommendations}">
   <h2>No recommendations found..!!</h2>
</c:if> 
<c:if test="${!empty recommendations}">
	<h1>Top Recommendations</h1>
   <c:forEach items="${recommendations}" var="land">
   <table style="padding-left: 40px">
	<tr>
	<td><b>Address :</b></td>
	<td>${land.parcelAddr}</td>
	</tr>
	<tr>
	<td><b>Type :</b></td>
	<td>${land.parcelType}</td>
	</tr>
	<tr>
	<td><b>Total Area :</b></td>
	<td>${land.totalLand}</td>
	</tr>
	 <tr>
	<td><b>Total Amount :</b></td>
	<td>${land.salesAmount}</td>
	</tr>
	 <tr>
	<td><b>Water :</b></td>
	<td>${land.water}</td>
	</tr>
	 <tr>
	<td><b>Gas :</b></td>
	<td>${land.gas}</td>
	</tr>
	<tr>
	<td><b>Electricity :</b></td>
	<td>${land.electricity}</td>
	</tr>
   </table>
   <br>
	</c:forEach>

</c:if>
</body>

</html>
