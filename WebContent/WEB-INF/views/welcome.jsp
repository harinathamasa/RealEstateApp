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
<script>
function enableSqua(){
	
	var sqrft = document.getElementById('squa').checked;
	if(sqrft){
		document.getElementById('enableAcres').style.display="none";
		document.getElementById('enableSquareFeet').style.display="block";
	}
	
}
function enableAcre(){
	var acre = document.getElementById('acre').checked;
	if(acre){
		document.getElementById('enableSquareFeet').style.display="none";
		document.getElementById('enableAcres').style.display="block";
	}
}
$(document).ready(function () {
	 $(function(){
		var parcelCities = '${cities}';
		parcelCities = parcelCities.replace('[','').replace(']','').split(",");
		 $("#city").autocomplete({
		        source: parcelCities
		    });
	
	 });
    
});

</script>
</head>
<body>
 <!-- Begin page content -->
    <div  class="container" style="overflow: scroll;border: 2px thin;">
    <div class="col-md-6">
     <h1 style="padding-top: 10px;padding-bottom: 20px">Real Estate App</h1>
     <form  action="" method="post">
     
        <div class="form-group ui-widget">
     	<label for="city">Enter City:</label>
     	<input type="text" class="form-control" id="city" name="city" placeholder="Enter city" style="font-size: 12">
     	</div>
     	
     	<div class="form-group">
     	<label>Select Category:</label>
     	<select class="form-control" id="category" name="category" >
<!-- 		<option value="select">select</option> -->
	<c:forEach items="${categories}" var="cat">
        <option value="${cat}">
            ${cat}
        </option>
      </c:forEach>
  		</select>
     	</div>
     	
     	<fieldset class="form-group">
    	<div class="row">
     	 <legend class="col-form-label col-sm-6 pt-0">Select land size</legend>
     	 <div class="col-sm-10">
        <div class="form-check">
          <input class="form-check-input" type="radio" name="landcat" id="squa" value="squa" onchange="enableSqua()">
          <label class="form-check-label" for="gridRadios1">
            Square Feet
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="landcat" id="acre" value="acre" onchange="enableAcre()">
          <label class="form-check-label" for="gridRadios2">
            Acre
          </label>
        </div>
        </div>
        </div>
        </fieldset>
     	
     	<div class="form-group" style="display: none;" id="enableSquareFeet">
     	<label for="city">Enter Square Feet:</label>
     	<input type="text" class="form-control" id="squareFeet" name="squareFeet" placeholder="Enter Square Feet">
     	</div>
     	
     	<div class="form-group" style="display: none;" id="enableAcres">
     	<label>Enter Number of Acres:</label>
     	<input type="text" class="form-control" id="acres" name="acres" placeholder="Enter Square Feet">
     	</div>
     	<fieldset class="form-group">
    	<div class="row">
     	 <legend class="col-form-label col-sm-6 pt-0">Select Price Range:</legend>
     	 <div class="col-sm-10">
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="0-50000" checked>
          <label class="form-check-label" for="gridRadios1">
            0 - 50000
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="50000-100000">
          <label class="form-check-label" for="gridRadios2">
            50000 - 100000
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="100000-300000">
          <label class="form-check-label" for="gridRadios3">
           100000 - 300000
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="300000-500000">
          <label class="form-check-label" for="gridRadios3">
           300000 - 500000
          </label>
        </div>
      </div>
    </div>
  </fieldset>
  <label>Eminities:</label>
  <div class="row">
   <div class="form-group col-10" style="padding-left: 35px">
    <input type="checkbox" class="form-check-input" id="gas" name="gas">
    <label class="form-check-label col-4" for="gas">Gas</label>
    <input type="checkbox" class="form-check-input" id="electricity" name="electricity">
    <label class="form-check-label col-4" for="electricity">Electricity</label>
    <br>
   </div>
  </div>
  <label>Water:</label>
  <div class="row">
   <div class="form-group col-10" style="padding-left: 35px">
    <input type="checkbox" class="form-check-input" id="private" name="private">
    <label class="form-check-label col-4" for="Private">Private</label>
    <input type="checkbox" class="form-check-input" id="municipality" name="municipality">
    <label class="form-check-label col-4" for="Municipality">Municipality</label>
   </div>
  </div>
	<button type="submit" class="btn btn-primary mb-2">Submit</button>
     </form>
     </div>
    </div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>