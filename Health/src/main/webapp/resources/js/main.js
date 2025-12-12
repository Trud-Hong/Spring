window.onload = function() {

    var today = new Date();
    var currentMonth = today.getMonth();
    var currentYear = today.getFullYear();
    var monthNames = ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"];

    // 데이터 가져오는 함수
    function fetchDayData(year, month, day, callback) {
        fetch(`/heal/api/daydata?year=${year}&month=${month+1}&day=${day}`)
	    .then(response => response.json())
	    .then(data => {
	        console.log("DB에서 가져온 데이터:", data);
	        callback(data);
	    })
	    .catch(err => {
	        console.error(err);
	        callback({ BP: "", SLEEP: "", EXERCISE: "", DIET: "", CONDITION: "" });
	    });

    }

    // 데이터 표시
    function displayData(year, month, day) {
        var container = document.getElementById("dayData");
        container.innerHTML = "<h4>" + year + "-" + (month+1) + "-" + day + "</h4>";
        container.innerHTML += "<p>로딩중...</p>";

        fetchDayData(year, month, day, function(data){
            container.innerHTML = "<h4>" + year + "-" + (month+1) + "-" + day +  " 컨디션 정보" + "</h4>";
            container.innerHTML +=
                "<p>혈압: " + (data.BP || "-") + "</p>" +
                "<p>수면: " + (data.SLEEP || "-") + "</p>" +
                "<p>운동: " + (data.EXERCISE || "-") + "</p>" +
                "<p>식단: " + (data.DIET || "-") + "</p>" +
                "<p>컨디션 점수: " + (data.CONDITION || "-") + "점</p>";
        });
    }

    // 달력 생성
    function createCalendar(year, month) {
        document.getElementById("calendarTitle").innerText = year + "년 ";
        document.getElementById("currentMonth").innerText =  monthNames[month];

        var calendar = document.getElementById("calendar");
        calendar.innerHTML = "";

        var days = ['일','월','화','수','목','금','토'];
        for(var d=0; d<days.length; d++){
            var header = document.createElement("div");
            header.className = "day-header";
            header.innerText = days[d];
            calendar.appendChild(header);
        }

        var firstDay = new Date(year, month, 1).getDay();
        var lastDate = new Date(year, month+1, 0).getDate();

        for(var i=0; i<firstDay; i++){
            calendar.appendChild(document.createElement("div"));
        }

        for(var i=1; i<=lastDate; i++){
            (function(i){
                var day = document.createElement("div");
                day.className = "day";
                if(year===today.getFullYear() && month===today.getMonth() && i===today.getDate()) {
                    day.className += " today";
                }

                day.innerText = i;

                // 클릭 이벤트
                day.addEventListener("click", function(){
                    displayData(year, month, i);
                });

                calendar.appendChild(day);
            })(i);
        }

        // 페이지 로드 시 오늘 날짜 정보 표시
        displayData(today.getFullYear(), today.getMonth(), today.getDate());
    }

    // 이전/다음 달 버튼
    document.getElementById("prevMonth").addEventListener("click", function(){
        currentMonth--;
        if(currentMonth<0){ currentMonth=11; currentYear--; }
        createCalendar(currentYear, currentMonth);
    });
    document.getElementById("nextMonth").addEventListener("click", function(){
        currentMonth++;
        if(currentMonth>11){ currentMonth=0; currentYear++; }
        createCalendar(currentYear, currentMonth);
    });

    // 초기 달력 생성
    createCalendar(currentYear, currentMonth);
};
