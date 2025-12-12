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
<title>식습관 설정</title>

<link rel="stylesheet" type="text/css" href="<%=cp %>/resources/css/habit.css"/>
<script src="<%=cp %>/resources/js/habit.js"></script>
</head>
<body>

<header>식습관 설정</header>

<div class="container">

    <!-- 아침 -->
    <div class="card">
        <h3>🌅 아침식사</h3>
        <div class="checkbox-group">
            <input type="checkbox" id="breakfast" onchange="toggleTimeInput('breakfast')">
            <label for="breakfast">아침을 먹습니다 </label>
            <input type="time" id="breakfastTime" value="08:00">
        </div>
    </div>

    <!-- 점심 -->
    <div class="card">
        <h3>🥗 점심식사</h3>
        <div class="checkbox-group">
            <input type="checkbox" id="lunch" checked onchange="toggleTimeInput('lunch')">
            <label for="lunch">점심을 먹습니다 </label>
            <input type="time" id="lunchTime" value="12:00">
        </div>
    </div>

    <!-- 저녁 -->
    <div class="card">
        <h3>🌙 저녁식사</h3>
        <div class="checkbox-group">
            <input type="checkbox" id="dinner" checked onchange="toggleTimeInput('dinner')">
            <label for="dinner">저녁을 먹습니다 </label>
            <input type="time" id="dinnerTime" value="18:00">
        </div>
    </div>

    <!-- 버튼 -->
    <div class="card" style="text-align:center;">
        <button class="btn" onclick="location.href='<%=cp %>/heal/habitUpdate.do';">저장하기</button>
		<button type="button" class="btn danger" onclick="location.href='/heal/main.do'">뒤로가기</button>
    </div>

</div>



</body>
</html>
