<!DOCTYPE html>
<html>

<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
   //alert('yes sir');
});

function ajaxReq() {
	
	$.ajax({
		  async: true,
		  type: "GET",
		  url: "http://localhost:8080/sse-demo/publishEvent",
		  cache: false,
		  success: function(data){
		   // alert('Data ' + data);
		  }
		});
	
}

</script>

</head>
<body>
<h2>Spring SseEmitter Demo</h2>
<h1>Gangadhar Pathipaka</h1>

<a href="http://localhost:8080/sse-demo/hello/Ganga">Click here 1 </a> <br/><br/>

<a href="http://localhost:8080/sse-demo/welcom">Click here 2 </a><br/><br/>
<button name="helloBtn" value="click Btn" onclick="ajaxReq()">Click me</button>

  <script>
            var source = new EventSource("/sse-demo/sse");
            source.onmessage = function(event) {
            	console.log('Origin ' + event.origin + " -|- Message " + event.data);
            	alert('Origin ' + event.origin + " -|- Message " + event.data);
            }
    </script>

</body>
</html>