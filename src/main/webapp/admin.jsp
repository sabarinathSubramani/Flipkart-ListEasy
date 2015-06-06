<html>

	<div class="header">
		<img class="logo" height="46" width="158" src="https://img1a.flixcart.com/fk-sp-static/images/mp-brand-refresh-logo.png">
		<h1 align="center" style="color:white"><b><span style='color:yellow;'>List</span> <span style='color:blue;'>Easy</span></b></h1>
	</div>
	<style type="text/css">
		.header{
		    height:100px;
		    background:#027CD5;
		    width:1280px;
		    padding-left: 10px;
		    top: 0px;
		    margin:auto; 
		    z-index:100000;
		    
		    position: fixed;
		    margin-left: -15px;
		    
		}
		.footer {
		 	height:100px;
		 	background-color: #027CD5;
			width:100%;
		}

		
		
		
		.footer{
			position: fixed;
	    	top: 535px;
	    	color: white;
	    	margin:auto;
	    	margin-left: -15px;
	    	padding-left: 15px;
		}
		h1 {
			
			
			line-height: 26.3999996185303px;
			position: relative;
			top:-30px;
			/*font-family: 'Brush script', Arial, sans-serif;	*/	
			font-family: 'Brush Script MT', cursive;	
		}
		.logo{
			margin-top: 20px;
			margin-left: 20px;
		}

		.inputform{
			margin-left: 1%;
			margin-top: 10%;

		}

		.input {
			border:4px solid #456879;
			border-radius:10px;
			height: 32px;
			width: 230px;
			font-size: 20px;
			font-family:'Helvetica Neue',sans-serif;
			margin-top: 8px;
		}
		#submit{
			margin-top: 2%;
			margin-left: 22%;
		}

		#footer_message{
			margin-top: 5%;
			text-align: center;
		}

		body {
			/*background-image: url("http://rack.0.mshcdn.com/media/ZgkyMDEzLzEyLzI2LzY4L0VDb21tZXJjZS4wMDZjZC5qcGcKcAl0aHVtYgk5NTB4NTM0IwplCWpwZw/2fd9eaa3/3ad/E-Commerce.jpg");
			background-repeat: no-repeat;
			background-position: 50% 50%; /* image centered on screen */
background-position: 50%; /* this also centers on screen */
background-position: 100px 100px;
background-position: center;

background-size: 980px 460px;
		}


		.fetchListings {
			background: #00A0D1;
			padding:8px 20px;
			color:#cfebf3;
			font-family:'Helvetica Neue',sans-serif;
			font-size:15px;
			border-radius:40px;
			-moz-border-radius:40px;
			-webkit-border-radius:40px;
			border:2px solid #095B7E;
			text-align: center;
		}
	</style>
	
	<p></p>
	<div class="form">
		<form action="./success" method="post" class="inputform">
		
    		<p>
    			<!-- <b>SKU</b> 
    				<input class="input" id="sku" type="text" name="name" value="">&nbsp&nbsp&nbsp -->

   				<b>Link</b> 
   					<input class="input" type="text" name="URL" >&nbsp;

   				</p>
   				<p>

   				<b>Store ID</b> 
   					<input class="input" type="text" name="store_id" >&nbsp;
   				</p>
   				<p>

   				<b>FK Seller ID</b> 
   					<input class="input" type="text" name="seller_id" >&nbsp;
   				</p>
   				<p>

	   			<b>Vertical </b>	
	   				<select class="input" name="vertical">
		    			<option value="book">book</option>
					</select>

    		</p>
    	
    	
    	<p>
    		<input class="fetchListings" id="submit" type="submit" value="Fetch My Products">
    	</p>

		</form>
	</div>

	<div class="footer">
			<h1 id="footer_message">
			<span style='color:white;'>Happy</span> 
			<span style='color:white;'>Listing</span> 
			<span style='color:white;'>in </span>
			<span style='color:white;'>Flipkart </span>
			<span style='color:white;'>Market</span>
			<span style='color:white;'>Place</span>
			</h1>
	</div>

		<script type="text/javascript">
			
		</script>
		<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.min.js"></script>
</html>
