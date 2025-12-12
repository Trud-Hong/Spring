function isDelete(member_id){
		if (confirm("정말로 삭제하시겠습니까?")) {
			location.href="<%=cp%>/heal/delete_ok.do?member_id=" + member_id;
		}
	}