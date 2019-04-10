<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
 
 <form enctype="multipart/form-data"  action="${pageContext.request.contextPath }/upload" method="post" >  
	    <input type="file" name="file" id="file"/>  
	    参数inputStr:<input type="text" name="des">    
	        <input type="submit" value="submit" />  
	</form>  
	<a href="/Studio/csss/style.css">1</a>
	<a href="../test">2</a>
	<a href="/Studio/test">3</a>
 
 </body>

</html>