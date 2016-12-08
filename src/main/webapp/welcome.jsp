<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>
<h1>Mr.WELCOME yeah...</h1>


  <script>
            var source = new EventSource("rest/user/sse");
            source.onmessage = function(event) {
                 //Do what you need to do when message received.
                 alert(event);
            }
    </script>

</body>
</html>



