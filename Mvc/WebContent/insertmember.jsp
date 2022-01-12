<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="Controller?command=insertmember" method="post">
		id<input type="text" name="id"><br/>
		pw<input type="text" name="pw"><br/>
		name<input type="text" name="name"><br/>
		<input type="submit" value="작성완료">
	</form>
</body>
</html>