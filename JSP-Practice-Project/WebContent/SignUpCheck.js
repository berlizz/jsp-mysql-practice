
function passwordCheck() {
	if(document.signupForm.mPassword.value === "") {
		alert('비밀번호를 입력하세요');
		document.signupForm.mPassword.focus();
		return;
	}
	
	if(document.signupForm.mPassword.value !== document.signupForm.mPasswordCheck.value) {
		alert('비밀번호가 일치하지 않습니다');
		document.signupForm.mPassword.focus();
		return;
	}
	
	document.signupForm.submit();
}	