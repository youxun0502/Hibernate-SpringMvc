<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	<h3>Form</h3>
	<form action="hello2.controller" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="userName" /></td>
				<td>${errors.name}</td>
			</tr>
			<tr>
				<td><button type="submit" value="send">Send</button></td>
			</tr>
		</table>
	</form>
</body>
</html>