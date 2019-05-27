<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XML Transform</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnReqTransform").on("click", function() {
			
			var xmlData = $("#xmlData").val();
 			var xsltData = $("#xsltData").val();	
 
 			var reqData = {'xmlData' : xmlData, "xsltData" : xsltData};
			$.post("XmlTransformServlet", reqData, 
					function(data, status)
					{
						$("#divOutputXml").html(data);	
					});
		});
	});
</script>
</head>
<body>
	<p>* XML **************************************************</p>
	<textarea rows="12" cols="50" id="xmlData"
	style="width : 50%"
	></textarea>
	<p>* XLST **************************************************</p>
	<textarea rows="12" cols="50" 
	style="width : 50%"
	id="xsltData"></textarea>
	<br/>
	<input type="button" id="btnReqTransform" value ="Transform"> </input>
<!-- 	<form action="XmlTransformServlet" method="post"> -->
	
<!-- 		<input type="textarea" id="xmlData" /> <br /> <input -->
<!-- 			type="textarea" id="xsltData" /> <br />  -->
			
<!-- 	</form> -->


	<div id="divOutputXml"></div>
</body>
</html>