function update() {
		
		var f = document.forms["myForm"];
		
		if (!f.password.value) {
			alert("패스워드를 입력하세요!");
			f.password.focus();
			return;
		}
		
		if (!f.name.value) {
			alert("이름을 입력하세요!");
			f.name.focus();
			return;
		}
		
		if (!f.weight.value) {
			alert("체중을 입력하세요!");
			f.weight.focus();
			return;
		}
		
		if (!f.height.value) {
			alert("키를 입력하세요!");
			f.height.focus();
			return;
		}
		
		f.action = "<%=cp%>/myPageEdit.do";
		f.submit();
		
	}