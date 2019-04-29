<!DOCTYPE html>

<html lang="en">

<head>
<script src="/js/jquery-3.3.1.js"></script>
</head>


<body>
 

  <h1>Contents:</h1>
  <hr />
  <div id="respcontent"></div>


   <script>
    var json = '${respData}'
	var result = JSON.stringify(JSON.parse(json), null, 4);
    $("<pre>").text(result).appendTo($("#respcontent"));
  </script>
  
</body>

</html>