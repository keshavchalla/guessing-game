<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>

$(document).ready(function(){
	$("#guess").hide();
	$("#min").hide();
	$("#max").hide();
	$("#guessNo").hide();
	
	$("#start").click(function(){
		 $.ajax({ 
			 method: "GET",
			 url: "/usrResponse", 
			 data: {guess: 'none',minNo: 0,maxNo: 1000 }
			 })
		  .done(function(response) {
			    $("#guess").show();
				$("#messag").show().html(response.message);
				$("#min").text(response.lowerLimit);
				$("#max").text(response.upperLimit);
				$("#guessNo").text(response.guessNo);  
				 $("#guess").on('change',function(){
					
					if(this.value == 'higher'){
						var minNo = $("#guessNo").text();
						var maxNo = $("#max").text();
					}else if(this.value == 'lower'){
						var maxNo = $("#guessNo").text();
						var minNo = $("#min").text();
					}else if(this.value == 'yes'){
						var maxNo = '0';
						var minNo = '0';
					}
					$.ajax({ 
						 method: "GET",
						 url: "/usrResponse", 
						 data: { guess: this.value, minNo: minNo,maxNo: maxNo }
						 })
					  .done(function(responses) {
						  $("#messag").show().html(response.message);
						  
						  $('#guess').prop('selectedIndex',0);
						  $("#messag").show().html(responses.message);
						  $("#min").text(responses.lowerLimit);
							$("#max").text(responses.upperLimit);
							$("#guessNo").text(responses.guessNo); 
					  });
				
				}); 
		  })
		  .fail(function(response) {
		    alert( "error" );
		  })
		  .always(function(response) {
		    //alert( "complete" );
		  }); 
	}); 
    	
	 
	
});
 
 
</script>
</head>
<body>
<input type="button" id="start" value="Start"><br><br>
<div id="messag"></div><br>
<div id="min"></div>
<div id="max"></div>
<div id="guessNo"></div>
<select id="guess">
  <option value="none">Select</option>	
  <option value="higher">Higher</option>
  <option value="lower">Lower</option>
  <option value="yes">Yes</option>
</select>
</body>

</html>