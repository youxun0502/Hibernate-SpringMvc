<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MultiLangResult</title>
</head>
<body>
	<p>
		<a href="multiLangResult.controller?locale=zh-TW">中文</a> <a
			href="multiLangResult.controller?locale=en-US">English</a>
	</p>
	<spring:message code="program.error" />
</body>
</html>