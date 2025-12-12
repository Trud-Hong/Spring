<%@page import="com.health.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
request.setCharacterEncoding("UTF-8");
String cp = request.getContextPath();

MemberDTO goal = (MemberDTO) request.getAttribute("goal");
String message = (String) request.getAttribute("message");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리목표 설정</title>

<link rel="stylesheet" type="text/css" href="<%=cp%>/resources/css/goal.css"/>

</head>
<body>

<header>관리목표 설정</header>

<div class="container">

    <!-- 메시지 표시 -->
    <% if (message != null) { %>
        <div class="card message"><%= message %></div>
    <% } %>

    <!-- 현재 설정된 목표 -->
    <% if (goal != null) { %>
    <div class="card">
        <h3>📌 현재 설정된 목표</h3>
        <div class="info-row">
            <strong>목표:</strong>
            <% if ("diet".equals(goal.getGoal())) { %> 다이어트
               <% } else if ("bulkup".equals(goal.getGoal())) { %> 체중 증가
               <% } else if ("health".equals(goal.getGoal())) { %> 건강 유지
            <% } %>
        </div>
        <div class="info-row"><%-- <strong>설명:</strong> <%= goal.getDescription() %> --%></div>
    </div>
    <% } %>

    <!-- 목표 설정 -->
    <div class="card">
        <h3>🎯 목표 선택</h3>
        <form method="post" action="goalUpdate.do">
            <div class="radio-group">
                <input type="radio" id="diet" name="goalType" value="diet"
                    <%= (goal != null && "diet".equals(goal.getGoal())) ? "checked" : "" %>>
                <label for="diet">다이어트 - 체중 감량</label>
            </div>
            <div class="radio-group">
                <input type="radio" id="bulkup" name="goalType" value="bulkup"
                    <%= (goal != null && "bulkup".equals(goal.getGoal())) ? "checked" : "" %>>
                <label for="bulkup">벌크업 - 체중 증가</label>
            </div>
            <div class="radio-group">
                <input type="radio" id="health" name="goalType" value="health"
                    <%= (goal != null && "health".equals(goal.getGoal())) ? "checked" : "" %>>
                <label for="health">건강 유지 - 현재 상태 유지</label>
            </div>

            <button type="submit" class="btn">저장하기</button>
            <button type="button" class="btn danger" onclick="location.href='/heal/main'">뒤로가기</button>
        </form>
    </div>

</div>

</body>
</html>
