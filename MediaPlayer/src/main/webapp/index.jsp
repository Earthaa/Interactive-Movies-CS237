<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/styles.css">

<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<script src="scripts/script.js"></script>

<title>Insert title here</title>
</head>
<body>

<div id='cssmenu'>
<ul>
   <li><a href='#'><span>Home</span></a></li>
   <li class='active has-sub'><a href='#'><span>Music</span></a>
      <ul>
         <li class='has-sub'><a href='listFilesServlet'><span>List Files</span></a>
            <ul>
               <li><a href='#'><span>Sub Product</span></a></li>
               <li class='last'><a href='#'><span>Sub Product</span></a></li>
            </ul>
         </li>
         <li class='has-sub'><a href='#'><span>Product 2</span></a>
            <ul>
               <li><a href='#'><span>Sub Product</span></a></li>
               <li class='last'><a href='#'><span>Sub Product</span></a></li>
            </ul>
         </li>
      </ul>
   </li>
   <li><a href='#'><span>About</span></a></li>
   <li class='last'><a href='#'><span>Contact</span></a></li>
</ul>
</div>

	<!--  -->

	<!-- 	<audio controls> -->
	<!-- 		<source src="/Movie/files/001. 오혁-01-소녀.mp3" type="audio/ogg"> -->
	<!-- 		<source src="/Movie/files/001. 오혁-01-소녀.mp3" type="audio/mpeg"> -->
	<!-- 		<source src="/Movie/files/001. 오혁-01-소녀.mp3" type="audio/mp3"> -->
	<!-- 			Your browser does not support the audio element. -->
	<!-- 	</audio> -->
	<!-- 	<br /> -->
	<!-- 	<audio controls> -->
	<!-- 		<source src="/Movie/files/LoginScreenIntro.mp3" type="audio/ogg"> -->
	<!-- 		<source src="/Movie/files/LoginScreenIntro.mp3" type="audio/mpeg"> -->
	<!-- 		<source src="/Movie/files/LoginScreenIntro.mp3" type="audio/mp3"> -->
	<!-- 			Your browser does not support the audio element. -->
	<!-- 	</audio> -->
	<!-- 	<br /> -->
	<!-- 	<video width="320" height="240" controls> -->
	<!-- 		<source src="/Movie/files/F201308021823010.mp4" type="video/mp4"> -->
	<!-- 		<source src="/Movie/files/F201308021823010.mp4" type="video/ogg"> -->
	<!-- 			Your browser does not support the video tag. -->
	<!-- 	</video> -->
	<!-- 	<br /> -->
	<%
// 		request.getRequestDispatcher("/listFilesServlet").forward(request, response);
	%>

</body>
</html>