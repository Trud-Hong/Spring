<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	String name = "홍길동";
	String height = "175cm";
	String weight = "70kg";
	String birth = "1990-01-01";
	String gender = "남성";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신체정보 수정</title>

<link rel="stylesheet" type="text/css" href="<%=cp%>/resources/css/profile.css"/>

</head>
<body>

	<header>내 정보</header>

	<div class="container">

		<!-- 내 정보 수정 -->
		<div class="card">
			<h3>🧾 내 정보 수정</h3>
			
			

			<div class="info-row">
				<label>이름:</label> <input type="text" value="<%=name%>">
			</div>

			<div class="info-row">
				<label>키:</label>
				<div style="display: flex; align-items: center; gap: 5px;">
					<input type="number" value="175" min="0" id="heightInput"
						style="flex: 1;"> <span>cm</span>
				</div>
			</div>
			
			<div class="info-row">
				<label>체중:</label>
				<div style="display: flex; align-items: center; gap: 5px;">
					<input type="number" value="70" min="0" id="weightInput"
						style="flex: 1;"> <span>kg</span>
				</div>
			</div>


			<div class="info-row">
				<label>생년월일:</label> <input type="date" value="<%=birth%>">
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

			<button class="btn" onclick="location='<%=cp%>/heal/profileUpdate.do';">저장</button>
			<button type="button" class="btn danger" onclick="location.href='/heal/main'">뒤로가기</button>

		</div>

	</div>

</body>
</html>

