<%@ page contentType="text/html; charset=UTF-8"%>
<%	
	String cp = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    <!-- 상단 헤더 -->
    <header>📢 커뮤니티</header>

    <div class="container">

        <!-- 검색 카드 -->
        <div class="card">
            <h3>🔍 게시글 검색</h3>
            <form action="<%=cp%>/list.action" method="get" style="display: flex; gap: 10px; flex-wrap: wrap;">
                <select name="searchKey" style="flex:1; min-width:120px;">
                    <option value="subject">제목</option>
                    <option value="name">이름</option>
                    <option value="content">내용</option>
                </select>
                <input type="text" name="searchValue" placeholder="검색어 입력" style="flex:2;">
                <button type="submit" class="btn">검색</button>
                <button type="button" class="btn" onclick="location.href='<%=cp%>/created.action'">글쓰기</button>
            </form>
        </div>

        <!-- 게시글 리스트 카드 -->
        <div class="card">
            <h3>📄 게시글 목록</h3>

            <c:if test="${dataCount == 0}">
                <p style="text-align:center; color: gray;">등록된 게시물이 없습니다.</p>
            </c:if>

            <c:forEach var="dto" items="${lists}">
                <div class="info-row" style="border-bottom:1px solid #eee; padding-bottom:10px; margin-bottom:10px;">
                    <a href="${articleUrl}&num=${dto.num}" style="font-size:18px; font-weight:bold; color:#4a76a8;">
                        ${dto.subject}
                    </a>
                    <div style="font-size:14px; color:#555; margin-top:5px;">
                        ✍ ${dto.name} | 📅 ${dto.created} | 👁 ${dto.hitCount}
                    </div>
                </div>
            </c:forEach>

            <c:if test="${dataCount != 0}">
                <div style="text-align:center; margin-top:15px;">
                    ${pageIndexList}
                </div>
            </c:if>
        </div>
    </div>

</body>
</html>