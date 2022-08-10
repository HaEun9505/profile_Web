/**
 * 
 */
 
 /* 로그인 체크 */
 
 function loginCheck(){
	
	if(document.login_form.mid.value.length == 0){
		alert("로그인 하시려는 아이디를 입력해주세요.");
		login_form.mid.focus();
		return;
	}
	
	if(document.login_form.mpw.value.length == 0){
		alert("로그인 하시려는 비밀번호를 입력해주세요.");
		login_form.mpw.focus();
		return;
	}
	
	document.login_form.submit();
}