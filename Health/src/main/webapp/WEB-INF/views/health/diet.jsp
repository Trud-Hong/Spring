<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주간 식단 추천</title>

<style type="text/css">

body { font-family: Arial, sans-serif; background:#f4f6f9; padding:20px; }
h2 { margin-bottom:10px; }
.calendar { width:100%; border-collapse:collapse; margin-bottom:20px; }
.calendar th, .calendar td { width:14.28%; height:70px; text-align:center; vertical-align:top; border:1px solid #ddd; cursor:pointer; }
.calendar th { background:#4a76a8; color:white; font-weight:bold; padding:10px 0; }
.calendar td:hover { background:#e8f0fe; }
.calendar .today { background:#d1e7ff; font-weight:bold; border:2px solid #4a76a8; }
.week-diet { display:grid; grid-template-columns:repeat(auto-fill,minmax(250px,1fr)); gap:15px; }
.day-card { background:white; border-radius:8px; padding:15px; box-shadow:0 2px 6px rgba(0,0,0,0.1); }
.day-card h3 { margin-top:0; font-size:16px; }
.meal { margin:5px 0; padding:5px; border-radius:4px; font-size:14px; }
.breakfast { background:#fff8d6; }
.lunch { background:#d6f5d6; }
.dinner { background:#ffe0b2; }

</style>

</head>
<body>

<h2>주간 식단 추천</h2>
<p>달력에서 날짜를 클릭하면 해당 주차 식단이 표시됩니다.</p>

<table id="calendar" class="calendar"></table>
<div id="weekDiet" class="week-diet"></div>

<script type="text/javascript">

//오늘
var today = new Date();

// 이번 주 일요일, 토요일
var thisSunday = new Date(today);
thisSunday.setDate(today.getDate() - today.getDay());
var thisSaturday = new Date(thisSunday);
thisSaturday.setDate(thisSunday.getDate() + 6);

// ---------- 더미 주간 식단 데이터 ----------
var dietData = {
  "2025-8-24": [
    {date:"8/24 (일)", breakfast:"빵, 커피", lunch:"비빔밥", dinner:"불고기"},
    {date:"8/25 (월)", breakfast:"오트밀", lunch:"샐러드, 닭가슴살", dinner:"연어스테이크"},
    {date:"8/26 (화)", breakfast:"시리얼, 우유", lunch:"김치찌개", dinner:"고등어조림"},
    {date:"8/27 (수)", breakfast:"토스트, 계란", lunch:"된장찌개", dinner:"두부조림"},
    {date:"8/28 (목)", breakfast:"죽, 과일", lunch:"칼국수", dinner:"제육볶음"},
    {date:"8/29 (금)", breakfast:"요거트, 견과류", lunch:"파스타", dinner:"삼겹살"},
    {date:"8/30 (토)", breakfast:"샌드위치", lunch:"냉면", dinner:"치킨샐러드"}
  ]
};

// ---------- 달력 생성 ----------
function generateCalendar(year, month) {
  var firstDay = new Date(year, month-1, 1);
  var lastDay = new Date(year, month, 0);

  var dayOfWeek = firstDay.getDay();
  var table = "<tr>";
  var weekdays = ["일","월","화","수","목","금","토"];
  for (var i=0;i<7;i++){ table+="<th>"+weekdays[i]+"</th>"; }
  table += "</tr><tr>";

  for (var i=0;i<dayOfWeek;i++){ table += "<td></td>"; }

  for (var d=1; d<=lastDay.getDate(); d++){
    var currentDate = new Date(year, month-1, d);
    var classes = "";
    if (currentDate.toDateString() === today.toDateString()){ classes="today"; }
    table += "<td class='"+classes+"' onclick='showWeekDiet("+year+","+month+","+d+")'>"+d+"</td>";
    if ((d + dayOfWeek) % 7 === 0) table += "</tr><tr>";
  }
  table += "</tr>";
  document.getElementById("calendar").innerHTML = table;
}

// ---------- 주차 시작(일요일) 키 ----------
function getWeekKey(date){
  var day = date.getDay();
  var diff = date.getDate() - day;
  var sunday = new Date(date.getFullYear(), date.getMonth(), diff);
  return sunday.getFullYear() + "-" + (sunday.getMonth()+1) + "-" + sunday.getDate();
}

// ---------- 주간 식단 표시 ----------
function showWeekDiet(year, month, day){
  var clickedDate = new Date(year, month-1, day);

  // 클릭한 주차 시작일
  var weekStart = new Date(clickedDate);
  weekStart.setDate(clickedDate.getDate() - clickedDate.getDay());

  // 이번 주 토요일을 초과하면 표시 안함
  if (weekStart > thisSaturday){
    alert("이번 주까지만 식단 추천이 표시됩니다.");
    document.getElementById("weekDiet").innerHTML = "";
    return;
  }

  var weekKey = getWeekKey(clickedDate);
  var diet = dietData[weekKey] || [];

  var container = document.getElementById("weekDiet");
  container.innerHTML = "";
  for (var i=0;i<diet.length;i++){
    var item = diet[i];
    var card = document.createElement("div");
    card.className = "day-card";
    card.innerHTML =
      "<h3>" + item.date + "</h3>" +
      "<div class='meal breakfast'><strong>아침:</strong> " + item.breakfast + "</div>" +
      "<div class='meal lunch'><strong>점심:</strong> " + item.lunch + "</div>" +
      "<div class='meal dinner'><strong>저녁:</strong> " + item.dinner + "</div>";
    container.appendChild(card);
  }
}

// 초기 달력 생성
generateCalendar(today.getFullYear(), today.getMonth()+1);

</script>

</body>
</html>
