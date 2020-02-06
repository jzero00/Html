	/**
	 * 
	 * 정규식을 이용한 데이터 검증
	 * 비교문자값.match('정규식') :  
	 * 정규식.test(비교문자값) 	: 비교문자값이 정규식에 맞는지 여부
	 * 							: 결과값 true, false 리턴
	 */

	function sendProc() {
		
		f = document.ff;

		//id는 영문자로 시작하고 숫자를 조합해서 8~12 사이로 한다
		
		idvalue = f.id.value;
		idlen = idvalue.trim().length;

		if(idlen == 0){
			alert("ID를 입력하세요.");
			return false;
		}
		if(idlen < 8 || idlen > 12 ) {
			alert("ID는 8~12자리 사이로 입력하세요.");
			return false;
		}
		//영문자가 처음에 하나 이상 나와야 한다는 조건...
		idreg = /^[a-zA-Z][0-9a-zA-Z]{7,11}$/;
		if(!(idreg.test(idvalue))){
			alert("ID 형식 오류..");
			return false;
		}
		//////////////////////////////////////////////////
		//이름
		namevalue = f.name.value;
		namelen = namevalue.trim().length;
		if(namelen == 0){
			alert("이름을 입력하세요...");
			return false;
		}
		namereg = /^[가-힣]+|^[a-zA-Z]+/
		if(namereg.test(namevalue)){
			rkor = /^[가-힣]+$/;
			reng = /^[a-zA-Z]+$/;
			if(rkor.test(namevalue)){
				//길이
				if(namelen < 2 || namelen > 5){
					alert("2~5자리 한글이름을 입력하세요");
					return false;
				}
			} else if (reng.test(namevalue)){
				if(namelen < 10 || namelen > 20){
					alert("10~20자리 영어이름을 입력하세요");
					return false;
				}
			} else {
				alert("이름형식 오류..");
				return false;
			}
		} else {
			alert("이름형식 오류..");
			return false;
		}
		//////////////////////////////////////////////
		//비밀번호 - 영문 숫자 중, 특수문자가 한글자 이상씩 포함.

		//전방탐색
		///\w+(?str) --> str를 찾아서, str를 기준으로 앞에 한번이상 나오는 문자나 숫자
		//str를 기준으로 앞에 아타나는 문자나 숫자가 없다면 str로 시작한다.
		passvalue = f.pass.value;
		passlen = passvalue.trim().length;
		passchk = f.passchk.value;
		
		if(passvalue != passchk){
			alert("두 개의 비밀번호가 일치하지 않습니다.");
			return false;
		}
		if(passlen == 0){
		alert("비밀번호를 입력하세요.");
		return false;
		}
		if(passlen < 8 || passlen > 12 ) {
			alert("비밀번호는 8~12자리 사이로 입력하세요.");
			return false;
		}
		passreg = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,12}$/;
		if(!(passreg.test(passvalue))){
			alert("비밀번호 형식 오류...");
			return false;
		}
		/////////////////////////////////////////////////////
		//전화번호
		telvalue = f.tel.value;
		tellen = telvalue.trim().length;

		if(tellen == 0){
			alert("전화번호 입력");
			return false;
		}
		telreg = /^\d{3}-\d{4}-\d{4}$/;
		if(!(telreg.test(telvalue))){
			alert("전화번호 형식 오류...");
			return false;
		}
		/////////////////////////////////////
		//이메일
		mailvalue = f.email.value;
		maillen = mailvalue.trim().length;
		
		if(maillen == 0){
			alert("이메일 입력");
			return false;
		}
		mailreg = /^[a-zA-z0-9]+@[a-zA-z0-9]+(\.[a-zA-z0-9]){1,2}$/;
		if(!(mailreg.test(mailvalue))){
			alert("이메일 형식 오류...");
			return false;
		}
		return true;
	}