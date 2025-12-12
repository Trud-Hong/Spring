<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>

<link rel="stylesheet" type="text/css" href="<%=cp%>/resources/css/myPageEdit.css">
<script src="<%=cp %>/resources/js/myPageEdit.js"></script>
</head>
<body>

	<header>
		<div class="left">
			<a href="<%=cp%>/main.do">건강관리 시스템</a>
		</div>
		<div style="font-size: 20px;">
        	내 정보
        </div>
        <div></div>
	</header>

	<div class="container">

		<!-- 내 정보 수정 -->
		<form action="" method="post" name="myForm">
		<div class="card">
			<h3>🧾 내 정보 수정</h3>

			<div class="info-row">
				<label>아이디:</label> <input name="member_id" type="text" value="${dto.member_id }"
					readonly style="background: #dbdbdb;">
			</div>

			<div class="info-row">
				<label>비밀번호:</label> <input name="password" type="password" value="${dto.password }">
			</div>

			<div class="info-row">
				<label>이름:</label> <input name="name" type="text" value="${dto.name }">
			</div>

			<div class="info-row">
				<label>체중:</label>
				<div style="display: flex; align-items: center; gap: 5px;">
					<input name="weight" type="number" value="${dto.weight }" min="0" id="weightInput"
						style="flex: 1;"> <span>kg</span>
				</div>
			</div>

			<div class="info-row">
				<label>키:</label>
				<div style="display: flex; align-items: center; gap: 5px;">
					<input name="height" type="number" value="${dto.height }" min="0" id="heightInput"
						style="flex: 1;"> <span>cm</span>
				</div>
			</div>

			<div class="info-row">
				<label>생년월일:</label> <input name="birth" type="date" value="${dto.birth }">
			</div>

			<div class="info-row">
				<label>내 관리목표:</label> <select>
					<option value="다이어트" ${dto.goal.equals("다이어트") ? "selected" : ""}>다이어트</option>
					<option value="체중증량" ${dto.goal.equals("체중증량") ? "selected" : ""}>체중증량</option>
					<option value="건강" ${dto.goal.equals("건강") ? "selected" : ""}>건강</option>
				</select>
			</div>

			<button class="btn" type="button" onclick="update();">저장</button>
			<button class="btn" type="button" onclick="location='<%=cp%>/myPage.do';">취소</button>
		</div>
	</form>
	</div>
	
</body>
</html>
