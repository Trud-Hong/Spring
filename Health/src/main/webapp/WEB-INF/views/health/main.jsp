<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.text.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	String today = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
	
	Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH); // 0~11
    int selectedDay = 0;

    String selDate = request.getParameter("date"); // YYYY-MM-DD
    if(selDate != null){
        String[] parts = selDate.split("-");
        year = Integer.parseInt(parts[0]);
        month = Integer.parseInt(parts[1]) - 1;
        selectedDay = Integer.parseInt(parts[2]);
    }

    cal.set(year, month, 1);
    int firstDay = cal.get(Calendar.DAY_OF_WEEK) - 1; // 0=일
    int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>건강관리 메인</title>

<link rel="stylesheet" type="text/css" href="<%=cp%>/resources/css/main.css">
<script src="<%=cp %>/resources/js/main.js"></script>

</head>
<body>

    <!-- 상단 -->
    <c:choose>
	<c:when test="${empty sessionScope.customInfo.member_id }">
    <header>
        <div style="flex:1; text-align:left;"><a href="<%=cp%>/main.do">건강관리 시스템</a></div>
        <div class="center-menu">
        	<a href="myPage.do" class="btn2">마이페이지</a>
        	<a href="review.do" class="btn2">이용후기</a>
        	<a href="commu.do" class="btn2">커뮤니티</a>
        </div>
        <div style="flex:1; text-align:right;">
			<a href="<%=cp %>/join" class="btn2">회원가입</a>|
			<a href="<%=cp %>/login" class="btn2">로그인</a>
		</div>
    </header>
    </c:when>
    <c:otherwise>
    <!-- 로그인 성공시 상단 -->
    <header>
        <div style="flex:1; text-align:left;"><a href="<%=cp%>/main.do">건강관리 시스템</a></div>
        <div class="center-menu">
        	<a href="myPage.do" class="btn2">마이페이지</a>
        	<a href="review.do" class="btn2">이용후기</a>
        	<a href="commu.do" class="btn2">커뮤니티</a>
        </div>
        <div style="font-size: 10pt; flex:1; text-align:right;">
			<b style="color: yellow;">${sessionScope.customInfo.name }</b>님 반갑습니다.
			<a href="logout.do" class="btn2">로그아웃</a>
		</div>
    </header>
    </c:otherwise>
    </c:choose>

    <!-- 메인 카드 영역 -->
    <div class="container">

        <div class="card">
            <h3>🥗 식단 추천</h3>
            <p>오늘의 추천: 저염식 / 고단백</p>
            <a href="diet.do" class="btn">주간 식단 보기</a>
        </div>

        <div class="card">
            <h3>🍚 식습관</h3>
            <p>일일 식사 횟수: 3회</p>
            <p>시간: 08:00 / 13:00 / 19:00</p>
            <a href="habit.do" class="btn">수정</a>
        </div>

        <div class="card">
            <h3>🏃 운동</h3>
            <p>추천: 유산소</p>
            <a href="exercise.do" class="btn">운동 기록하기</a>
        </div>

        <div class="card">
            <h3>❤️ 혈압</h3>
            <p>최근 결과: #/# 정상</p>
            <a href="blood.do" class="btn">입력하기</a>
        </div>

        <div class="card">
            <h3>👤 신체정보</h3>
            <p>이름: 홍길동, 생년월일: 1111-11-11, 성별: 남성</p>
            <p>키: 175cm, 체중: 70kg, BMI: 22.9</p>
            <a href="profile.do" class="btn">수정</a>
        </div>

        <div class="card">
            <h3>🎯 관리목표</h3>
            <p>현재 목표: 다이어트</p>
            <a href="goal.do" class="btn">목표 변경</a>
        </div>

        <div class="card">
            <h3>💤 수면패턴</h3>
            <p>최근 기록: 01:00 ~ 07:00</p>
            <p>권장: 8시간 (23시~07시)</p>
            <p>권장 취침 시간 : 23시</p>
            <a href="sleep.do" class="btn">기록하기</a>
        </div>

</div>
    
    
<!-- 좌우 2열 레이아웃: 달력 + 데이터 영역 -->
<div style="display:flex; gap:20px; padding:20px;">
  
  <!-- 달력 영역 -->
  <div class="card" style="flex:1;">
    <h3 id="calendarTitle"></h3>
    <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:10px;">
      <button id="prevMonth" class="btn2">◀</button>
      <div id="currentMonth" style="font-weight:bold; font-size: 20pt"></div>
      <button id="nextMonth" class="btn2">▶</button>
    </div>
    <div id="calendar"></div>
  </div>

  <!-- 데이터 표시 영역 -->
  <div class="card" style="flex:1; padding:10px; overflow-y:auto; max-height:600px;">
    <div id="dayData" style="min-height:500px; padding:10px;">
      
    </div>
  </div>

</div>



</body>
</html>



