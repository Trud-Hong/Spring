function sendIt() {
		
		var f = document.myForm;
		
		str = f.member_id.value;
		str = str.trim();
		if (!str) {
			alert("아이디를 입력하세요!");
			f.member_id.focus();
			return;
		}
		f.member_id.value = str;
		
		str = f.password.value;
		str = str.trim();
		if (!str) {
			alert("패스워드를 입력하세요!");
			f.password.focus();
			return;
		}
		f.password.value = str;
		
		str = f.name.value;
		str = str.trim();
		if (!str) {
			alert("이름을 입력하세요!");
			f.name.focus();
			return;
		}
		f.name.value = str;
		
		str = f.birth.value;
		str = str.trim();
		if (!str) {
			alert("생일을 입력하세요!");
			f.birth.focus();
			return;
		}
		f.birth.value = str;

		str = f.gender.value;
		str = str.trim();
		if (!str) {
			alert("성별을 입력하세요!");
			f.gender.focus();
			return;
		}
		f.gender.value = str;
		
		str = f.weight.value;
		str = str.trim();
		if (!str) {
			alert("체중을 입력하세요!");
			f.weight.focus();
			return;
		}
		f.weight.value = str;

		str = f.height.value;
		str = str.trim();
		if (!str) {
			alert("키를 입력하세요!");
			f.height.focus();
			return;
		}
		f.height.value = str;
		
		f.action = "join_ok.do";
		f.submit();
		
	}