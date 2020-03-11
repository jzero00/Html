/**
 * 
 */
//아이디 체크
var idcheck = function() {

	idvalue = $('#id').val();
	// 공백체크
	idlen = idvalue.length;
	if (idlen <= 0) {
		alert("아이디를 입력하세요");
		return false;
	}
	// 길이체크
	if (idlen < 4 || idlen > 12) {
		alert("id는 4~12사이로 입력해주세요")
		return false;
	}
	// 형식체크
	// 영문 소문자로 시작하고 두번째 문자보투 영문대소문자 숫자를 조합해 전체 길이 4~12
	idreg = /^[a-zA-z][a-zA-z0-9]{3,11}$/
	if (!(idreg.test(idvalue))) {
		alert("id형식오류입니다.");
		return false;
	}
	return true;
}
//비밀번호 체크
var passcheck = function() {

	// 비밀번호값
	vpass = $('#pass').val().trim();
	passlen = vpass.trim().length;

	// 비밀번호 길이
	// if (passlen < 4 || passlen > 10) {
	// alert("비밀번호는 4~10자리 사이입니다.");
	// return false;
	// }
	// 비밀번호 정규식
	// 영문 대소문자 숫자 특수문자 반드시 한개 이상 조합
	passreg = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).{4,10}$/
	if (!(passreg.test(vpass))) {
		alert("비밀번호 형식 오류");
		return false;
	}
	return true;
}
//비밀번호 확인 체크
var pass2check = function() {
	vpass = $('#pass').val().trim();
	vpass2 = $('#pass2').val().trim();

	pass2len = vpass2.trim().length;

	if (pass2len <= 0) {
		return false;
	}
	if (vpass != vpass2) {
		return false;
	}
	return true;
}

//▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶
//이름 체크
var namecheck = function(){
	
	vname = $('#name').val().trim();
	namelen = vname.length;
	
	//공백 
	if(namelen <= 0 ){
		alert("이름입력");
		return false;
	}
	
	//정규식 
	namereg = /^[가-힣]+$|^[a-zA-Z]+$/;
	if(namereg.test(vname)){
		regkor = /^[가-힣]+$/;
		regeng = /^[a-zA-Z]+$/;
		if(regkor.test(vname)){
			if(namelen <2 || namelen >5){
				alert("한글 2~5 사이 ");
				return false;
			}
		}else {
			if(namelen <5 || namelen >10){
				alert("영문 5~10 사이 ");
				return false;
			}
		}
	}else{
	  alert("이름 형식 오류 ");
	  return false;
	}
	
	count++;
	return true;
	
}

//생년월일 입력 체크
var bircheck = function() {
	vbir = $('#bir').val().trim();
	if (vbir <= 0) {
		return false;
	}
	count++;
	return true;
}

var phoneNoCheck = function() {
	vphoneNo = $('#phoneNo').val().trim();

	hpreg = /^\d{3}-\d{4}-\d{4}$/
	//	hpreg = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/

	if (!(hpreg.test(vphoneNo))) {
		alert("전화번호 형식 오류");
		return false;
	}
	count++;
	return true;
}

var mailcheck = function() {
	vmail = $('#email').val().trim();

	// 이메일 정규식
	mailreg = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+){1,2}$/;
	if (!(mailreg.test(vmail))) {
		alert("이메일 형식 오류");
		return false;
	}
	count++;
	return true;

}