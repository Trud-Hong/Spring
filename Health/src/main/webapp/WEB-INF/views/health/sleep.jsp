<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수면패턴 기록</title>

<link rel="stylesheet" type="text/css" href="<%=cp%>/resources/css/sleep.css"/>

</head>
<body>

<header>식습관 설정</header>
<div class="container">

    <!-- 수면시간 -->
    <div class="card">
        <h3>🌙 평균 수면시간</h3>
        <div class="info-row">
            <input type="number" min="1" max="12" id="breakfast">
        </div>
    </div>

    <!-- 취침시간 -->
    <div class="card">
        <h3>🛏 취침 시간</h3>
        <div class="info-row">
            <input type="time" id="sleeptime" value="23:00">
        </div>
    </div>

    <!-- 버튼 -->
    <div class="card" style="text-align:center;">
        <button class="btn" onclick="location.href='<%=cp %>/heal/habitUpdate.do';">저장하기</button>
		<button type="button" class="btn danger" onclick="location.href='/heal/main'">뒤로가기</button>
    </div>

</div>






</body>
</html>




































