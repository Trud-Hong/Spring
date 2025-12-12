<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	int lownum = 80;
	int highnum = 120;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>혈압 수정</title>

<link rel="stylesheet" type="text/css" href="<%=cp%>/resources/css/blood.css"/>

</head>
<body>

	<header>혈압 수정</header>

	<div class="container">

		<!-- 내 정보 수정 -->
		<div class="card">
			<h3>🧾 혈압 수정</h3>

			<div class="info-row">
				<label>수축기:</label> <input type="number" value="<%=highnum%>" min="50" max="250" >
			</div>

			<div class="info-row">
				<label>이완기:</label> <input type="number" value="<%=lownum%>" min="30" max="150" >
			</div>

			<button class="btn" onclick="location='<%=cp%>/heal/bloodUpdate.do';">저장</button>
			<button type="button" class="btn danger" onclick="location.href='/heal/main'">뒤로가기</button>

		</div>

	</div>

</body>
</html>




































