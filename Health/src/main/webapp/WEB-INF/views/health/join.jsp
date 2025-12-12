<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	String userId = "hong123";
	String password = "******";
	String name = "홍길동";
	String weight = "70kg";
	String height = "175cm";
	String birth = "1990-01-01";
	String goal = "다이어트";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="<%=cp%>/resources/css/join.css"/>
<script src="<%=cp %>/resources/js/join.js"></script>


</head>
<body>
<form action="" method="post" name="myForm">
	<header>
		<div class="left">
			<a href="<%=cp%>/main.do">건강관리 시스템</a>
		</div>
		<div style="font-size: 20px;">
        	회 원 가 입
        </div>
        <div></div>
	</header>

	<div class="container">

		<!-- 내 정보 수정 -->
		<div class="card">
			<h3>🧾 회원 가입</h3>

			<div class="info-row">
				<label>아이디:</label> <input type="text" name="member_id">
			</div>

			<div class="info-row">
				<label>비밀번호:</label> <input type="password" name="password">
			</div>

			<div class="info-row">
				<label>이름:</label> <input type="text" name="name">
			</div>

			<div class="info-row">
				<label>생년월일:</label> <input type="date" name="birth">
			</div>

			<div class="info-row">
				<label>성별:</label>
				<div style="display: flex; align-content: center; gap: 5px;">
					<input type="radio" id="male" name="gender" value="M">
					<label for="male">남자</label>
					<input type="radio" id="female" name="gender" value="F">
					<label for="female">여자</label>
				</div>
			</div>

			<div class="info-row">
				<label>체중:</label>
				<div style="display: flex; align-items: center; gap: 5px;">
					<input type="number" min="0" id="weightInput" name="weight"
						style="flex: 1;"> <span>kg</span>
				</div>
			</div>

			<div class="info-row">
				<label>키:</label>
				<div style="display: flex; align-items: center; gap: 5px;">
					<input type="number" min="0" id="heightInput" name="height""
						style="flex: 1;"> <span>cm</span>
				</div>
			</div>


			<div class="info-row">
				<label>내 관리목표:</label> <select name="goal">
					<option value="다이어트" <%=goal.equals("다이어트") ? "selected" : ""%>>다이어트</option>
					<option value="체중증량" <%=goal.equals("체중증량") ? "selected" : ""%>>체중증량</option>
					<option value="건강" <%=goal.equals("건강") ? "selected" : ""%>>건강</option>
				</select>
			</div>
			
			<div class="info-row">
				<input type="button" class="btn" onclick="sendIt();" value="회원가입"/>
			</div>
		</div>
		
	</div>
</form>
</body>
</html>
