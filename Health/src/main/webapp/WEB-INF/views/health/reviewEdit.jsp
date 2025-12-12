<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	
	String cp = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>후기 작성/수정</title>

<script type="text/javascript">
function goBack() {
    location.href = "<%=cp%>/review.do";
}
	
function validateForm() {
	var content = document.getElementById('content').value.trim();
	if (content === '') {
		alert('후기 내용을 입력해주세요.');
		return false;
	}
	return true;
}

function submitForm() {
	if (validateForm()) {
		document.getElementById('reviewForm').submit();
	}
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
        max-width: 500px;
        margin: 20px auto;
        padding: 0 15px;
    }
    .card {
        background: white;
        border-radius: 8px;
        padding: 20px;
        box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        margin-bottom: 20px;
    }
    .card h3 {
        margin-top: 0;
        font-size: 20px;
        margin-bottom: 20px;
        color: #333;
        text-align: center;
    }
    .form-group {
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
        color: #333;
    }
    select, textarea, input[type="text"], input[type="password"] {
        width: 100%;
        padding: 12px;
        border: 1px solid #ddd;
        border-radius: 4px;
        font-size: 14px;
        box-sizing: border-box;
    }
    select {
        width: 200px;
    }
    textarea {
        resize: vertical;
        min-height: 120px;
    }
    .btn {
        display: inline-block;
        padding: 10px 20px;
        background: #4a76a8;
        color: white;
        text-decoration: none;
        border-radius: 4px;
        font-size: 14px;
        cursor: pointer;
        border: none;
        margin-right: 10px;
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
    .btn-cancel {
        background: #6c757d;
    }
    .btn-cancel:hover {
        background: #545b62;
    }
    .button-group {
        text-align: center;
        margin-top: 30px;
    }
    .error {
        color: red;
        margin-bottom: 15px;
        padding: 10px;
        background: #ffe6e6;
        border: 1px solid #ffcccc;
        border-radius: 4px;
    }
</style>
</head>
<body>

<header>
    <div class="header-left">
        <a href="<%=cp%>/review.do" class="btn2">후기목록</a>
    </div>
    <div class="header-center">후기 작성/수정</div>
</header>

<div class="container">
    <!-- 새 후기 작성 폼 -->
    <div class="card">
        <h3>후기 작성하기</h3>
        
        <form id="reviewForm" action="<%=cp%>/review/write_ok.do" method="post">
            <div class="form-group">
                <label for="writer">작성자:</label>
                <input type="text" name="writer" id="writer" placeholder="작성자명을 입력하세요" required>
            </div>
            
            <div class="form-group">
                <label for="content">후기 내용:</label>
                <textarea name="content" id="content" placeholder="건강관리 프로젝트 이용 후기를 작성해주세요..." required></textarea>
            </div>
            
            <div class="button-group">
                <button type="button" onclick="submitForm()" class="btn">작성완료</button>
                <button type="button" onclick="goBack()" class="btn btn-cancel">취소</button>
            </div>
        </form>
    </div>

    <!-- 후기 수정 폼 (기존 후기가 있을 때만 표시) -->
    <c:if test="${not empty review}">
    <div class="card">
        <h3>후기 수정하기</h3>
        
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        
        <form action="<%=cp%>/reviewEdit" method="post">
            <input type="hidden" name="id" value="${review.id}">
            
            <div class="form-group">
                <label for="edit-writer">작성자:</label>
                <input type="text" name="writer" id="edit-writer" value="${review.writer}" required>
            </div>
            
            <div class="form-group">
                <label for="edit-content">후기 내용:</label>
                <textarea name="content" id="edit-content" required>${review.content}</textarea>
            </div>
            
            <div class="button-group">
                <button type="submit" class="btn">수정완료</button>
                <button type="button" onclick="goBack()" class="btn btn-cancel">취소</button>
            </div>
        </form>
    </div>
    </c:if>
</div>

</body>
</html>