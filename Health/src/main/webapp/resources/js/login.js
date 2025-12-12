function login() {
		
		var f = document.myForm;
		
		if (!f.member_id.value) {
			alert("아이디를 입력하세요!");
			f.member_id.focus();
			return;
		}

		if (!f.password.value) {
			alert("패스워드를 입력하세요!");
			f.password.focus();
			return;
		}
		
		f.action = "/heal/login_ok.do";
		f.submit();
		
		
	}