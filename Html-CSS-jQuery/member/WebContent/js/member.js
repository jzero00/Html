/**
 * 
 */
var regcheck = function (){
	
	// ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡
	//생년월일
	vbir = $('#bir').val().trim()
	birlen = vbir.length;
	
	if(birlen <= 0){
		alert("생년월일 입력");
		return false;
	}
	//생년월일 형식 숫자 4자리-2자리-2자리
	birreg = /^\d{4}-\d{2}-\d{2}$/;
	if(!(birreg.test(vbir))){
		alert('생년월일 형식오류');
		return false;
	}
	// ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡
	// 비밀번호
	

//	// ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡
//	// 아이디
//	// 아이디값
//	vid = $('#id').val().trim();
//	idlen = vid.trim().length;
//	
//	// 아이디 길이
//	if(idlen < 4 || idlen > 12){
//		alert("아이디는 4~12자리 사이입니다.")
//		return false;
//	}
//	// 아이디 정규식
//	idreg = /^[a-zA-z]+[a-zA-z0-9]*$/
//		if(!(idreg.test(vid))){
//			alert("아이디 형식 오류");
//			return false;
//		}
	// ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡
	// 휴대폰번호
	// 휴대폰번호값
	vhp = $('#phonenumber').val().trim();
	hplen = vhp.trim().length;
	
	// 휴대폰번호 정규식
	hpreg = /^\d{3}-\d{4}-\d{4}$/
//	hpreg = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/
		if(!(hpreg.test(vhp))){
			alert("전화번호 형식 오류");
			return false;
		}
	// ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡
	// 이메일
	// 이메일 값
	vmail = $('#email').val().trim();
	
	// 이메일 정규식
	mailreg = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+){1,2}$/;
		if(!(mailreg.test(vmail))){
			alert("이메일 형식 오류");
			return false;
		}
	return true;
}