<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="uploadCos" method="post" enctype="multipart/form-data">
	<!-- <form action="upload.jsp" method="post" enctype="multipart/form-data"> -->
	이름 : <input type="text" name="name"><br>
	파일 : <input type="file" name="file"><br>
	<input type="submit" name="업로드"><br>
</form>
</body>
</html>