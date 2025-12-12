<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이용 후기</title>

<script type="text/javascript">
	function deleteReview(reviewId) {
		if (confirm("정말로 후기를 삭제하시겠습니까?")) {
			location.href="<%=cp%>/reviewDelete/" + reviewId;
		}
	}

	function openWriteForm() {
	    location.href = "<%=cp%>/review/write.do";
	}
</script>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f9;
	margin: 0;
	padding: 0;
}

header {
	background: #4a76a8;
	color: white;
	padding: 15px;
	text-align: center;
	font-size: 20px;
	position: relative;
}

.header-left {
	position: absolute;
	left: 15px;
}

.header-center {
	text-align: center;
	width: 100%;
}

.container {
	max-width: 800px;
	margin: 30px auto;
	padding: 0 20px;
}

.card {
	background: white;
	border-radius: 8px;
	padding: 20px;
	margin-bottom: 20px;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
}

.card h3 {
	margin-top: 0;
	font-size: 18px;
	margin-bottom: 15px;
	color: #333;
}

.btn {
	display: inline-block;
	margin-top: 10px;
	padding: 8px 16px;
	background: #4a76a8;
	color: white;
	text-decoration: none;
	border-radius: 20px;
	font-size: 14px;
	cursor: pointer;
	border: none;
}

.btn2 {
	display: inline-block;
	margin-bottom: 10px;
	padding: 6px 12px;
	background: #4a76a8;
	color: white;
	text-decoration: none;
	border-radius: 4px;
	font-size: 14px;
}

.btn:hover {
	background: #3a5a85;
}

.danger {
	background: #d9534f;
	margin-left: 10px;
}

.danger:hover {
	background: #c12e2a;
}

.review-item {
	border-bottom: 1px solid #eee;
	padding: 15px 0;
}

.review-item:last-child {
	border-bottom: none;
}

.review-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 10px;
}

.review-author {
	font-weight: bold;
	color: #4a76a8;
}

.review-date {
	color: #666;
	font-size: 14px;
}

.review-rating {
	color: #ffa500;
	font-size: 18px;
	margin-bottom: 10px;
}

.review-content {
	line-height: 1.6;
	color: #333;
}

.review-actions {
	margin-top: 10px;
}

.no-reviews {
	text-align: center;
	color: #666;
	font-style: italic;
	padding: 50px 0;
}

.write-review {
	text-align: center;
	margin-bottom: 30px;
}

.stats {
	display: flex;
	justify-content: space-around;
	text-align: center;
	background: #f8f9fa;
	padding: 15px;
	border-radius: 8px;
	margin-bottom: 20px;
}

.stat-item {
	flex: 1;
}

.stat-number {
	font-size: 24px;
	font-weight: bold;
	color: #4a76a8;
}

.stat-label {
	font-size: 14px;
	color: #666;
	margin-top: 5px;
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	display: block;
	margin-bottom: 8px;
	font-weight: bold;
	color: #333;
}

.form-group textarea, 
.form-group input[type="text"], 
.form-group input[type="password"] {
	width: 100%;
	padding: 12px;
	border: 1px solid #ddd;
	border-radius: 4px;
	font-size: 14px;
	box-sizing: border-box;
}

.form-group textarea {
	resize: vertical;
	min-height: 100px;
}

.form-submit {
	text-align: center;
	margin-top: 20px;
}

.simple-review-item {
	margin-bottom: 15px;
	padding: 15px;
	background: #f8f9fa;
	border-radius: 4px;
}

.simple-review-header {
	font-weight: bold;
	color: #4a76a8;
	margin-bottom: 8px;
}

.simple-review-content {
	margin-bottom: 10px;
	line-height: 1.5;
}

.simple-review-meta {
	font-size: 12px;
	color: #666;
}

.simple-review-actions {
	margin-top: 10px;
}

.simple-review-actions a {
	margin-right: 10px;
	font-size: 14px;
}
</style>
</head>
<body>

	<header>
	<div class="header-left">
		<a href="<%=cp%>/main.do" class="btn2">메인메뉴</a>
	</div>
	<div class="header-center">이용 후기</div>
	</header>

	<div class="container">

		<!-- 로그인한 사용자만 후기 작성 가능 -->
		<c:choose>
			<c:when test="${not empty sessionScope.customInfo}">
				<!-- 로그인된 사용자 - 후기 작성 폼 표시 -->
				<div class="card">
					<h3>후기 작성하기</h3>
					<form action="<%=cp%>/reviewWrite" method="post">
						<div class="form-group">
							<label for="content">후기 내용:</label>
							<textarea name="content" id="content" placeholder="후기를 작성해주세요" required></textarea>
						</div>
						<div class="form-group">
							<label for="writer">작성자:</label>
							<input type="text" name="writer" id="writer" value="${sessionScope.customInfo.name}" readonly style="background-color: #f8f9fa;">
						</div>
						
						<div class="form-submit">
							<button type="submit" class="btn">작성완료</button>
						</div>
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<!-- 로그인하지 않은 사용자 - 안내 메시지 -->
				<div class="card">
					<h3>후기 작성하기</h3>
					<div style="text-align: center; padding: 40px 20px;">
						<p style="font-size: 16px; color: #666; margin-bottom: 20px;">
							후기를 작성하려면 로그인이 필요합니다.
						</p>
						<a href="<%=cp%>/login.do" class="btn">로그인하기</a>
					</div>
				</div>
			</c:otherwise>
		</c:choose>

		<!-- 후기 통계 -->
		<div class="stats">
			<div class="stat-item">
				<div class="stat-number">${totalReviews}</div>
				<div class="stat-label">총 후기</div>
			</div>
			<div class="stat-item">
				<div class="stat-number">${avgRating}</div>
				<div class="stat-label">평균 별점</div>
			</div>
			<div class="stat-item">
				<div class="stat-number">${myReviews}</div>
				<div class="stat-label">내 후기</div>
			</div>
		</div>

		<!-- 새로운 reviews 목록 -->
		<c:if test="${not empty reviews}">
			<div class="card">
				<h3>최신 후기 목록</h3>
				<c:forEach var="r" items="${reviews}">
					<div class="simple-review-item">
						<div class="simple-review-header">${r.writer}</div>
						<div class="simple-review-content">${r.content}</div>
						<div class="simple-review-meta">${r.createdAt}</div>
						<div class="simple-review-actions">
							<a href="<%=cp%>/reviewEdit/${r.id}" class="btn">수정</a>
							<a href="javascript:void(0);" onclick="deleteReview(${r.id})" class="btn danger">삭제</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>

		<!-- 기존 후기 목록이 비어있을 때 -->
		<c:if test="${empty reviews}">
			<div class="card">
				<h3>이용 후기</h3>
				<div class="no-reviews">
					아직 등록된 후기가 없습니다.<br> 첫 번째 후기를 작성해보세요!
				</div>
			</div>
		</c:if>

	</div>

</body>
</html>