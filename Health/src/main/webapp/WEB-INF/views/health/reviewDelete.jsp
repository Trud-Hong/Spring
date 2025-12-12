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
<title>후기 삭제</title>

<script type="text/javascript">
function goBack() {
    location.href = "<%=cp%>/review.do";
}

function confirmDelete() {
    if (confirm("정말로 이 후기를 삭제하시겠습니까?\n삭제된 후기는 복구할 수 없습니다.")) {
        return true;
    }
    return false;
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
        background: #d9534f;
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
        margin: 50px auto;
        padding: 0 15px;
    }
    .card {
        background: white;
        border-radius: 8px;
        padding: 30px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.15);
        border: 1px solid #d9534f;
    }
    .card h3 {
        margin-top: 0;
        font-size: 22px;
        margin-bottom: 20px;
        color: #d9534f;
        text-align: center;
    }
    .warning-message {
        background: #fff3cd;
        border: 1px solid #ffeaa7;
        border-radius: 4px;
        padding: 15px;
        margin-bottom: 25px;
        color: #856404;
        text-align: center;
    }
    .warning-icon {
        font-size: 24px;
        margin-bottom: 10px;
        display: block;
    }
    .review-info {
        background: #f8f9fa;
        border-radius: 4px;
        padding: 15px;
        margin-bottom: 20px;
        border-left: 4px solid #d9534f;
    }
    .review-info h4 {
        margin: 0 0 10px 0;
        color: #333;
    }
    .review-info p {
        margin: 5px 0;
        color: #666;
    }
    .form-group {
        margin-bottom: 25px;
    }
    label {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
        color: #333;
    }
    .btn {
        display: inline-block;
        padding: 12px 24px;
        background: #d9534f;
        color: white;
        text-decoration: none;
        border-radius: 4px;
        font-size: 16px;
        cursor: pointer;
        border: none;
        margin-right: 15px;
        transition: background-color 0.3s;
    }
    .btn:hover {
        background: #c12e2a;
    }
    .btn-cancel {
        background: #6c757d;
    }
    .btn-cancel:hover {
        background: #545b62;
    }
    .btn2 {
        display: inline-block;
        margin-bottom: 10px;
        padding: 6px 12px;
        background: #6c757d;
        color: white;
        text-decoration: none;
        border-radius: 4px;
        font-size: 14px;
    }
    .button-group {
        text-align: center;
        margin-top: 30px;
    }
    .error {
        color: #d9534f;
        margin-bottom: 20px;
        padding: 15px;
        background: #ffe6e6;
        border: 1px solid #ffcccc;
        border-radius: 4px;
        text-align: center;
        font-weight: bold;
    }
</style>
</head>
<body>

<header>
    <div class="header-left">
        <a href="<%=cp%>/review.do" class="btn2">후기목록</a>
    </div>
    <div class="header-center">후기 삭제</div>
</header>

<div class="container">
    <div class="card">
        <h3>후기 삭제하기</h3>
        
        <div class="warning-message">
            <span class="warning-icon">⚠️</span>
            <strong>주의!</strong><br>
            삭제된 후기는 복구할 수 없습니다.<br>
            신중하게 결정해주세요.
        </div>
        
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        
        <!-- 삭제할 후기 정보 표시 -->
        <c:if test="${not empty review}">
            <div class="review-info">
                <h4>삭제할 후기 정보</h4>
                <p><strong>작성자:</strong> ${review.writer}</p>
                <p><strong>작성일:</strong> ${review.createdAt}</p>
                <p><strong>내용:</strong> ${review.content}</p>
            </div>
        </c:if>
        
        <!-- 삭제 확인 폼 -->
        <form action="<%=cp%>/reviewDelete" method="post" onsubmit="return confirmDelete()">
            <input type="hidden" name="id" value="${id}">
            
            <div class="button-group">
                <button type="submit" class="btn">삭제하기</button>
                <button type="button" onclick="goBack()" class="btn btn-cancel">취소</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>