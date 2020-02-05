/**
 * 
 */
function proc1() {

        namevalue = document.ff.name.value;
        idvalue = document.ff.id.value;
        namelen = namevalue.trim().length;
        idlen = idvalue.trim().length;

        if(namelen == 0){
            alert("이름을 입력하세요");
            return false;
        }
        if(namelen <2 || namelen >5){
            alert("이름은 2~5자리 사이입니다.");
            return false;
        }

        if(idlen == 0){
            alert("ID를 입력하세요");
            return false;
        }
        if(idlen < 8 || idlen > 12){
            alert("ID는 8~12사이의 자리로 입력해주세요");
            return false;
        }
        res = "이름 : " + namevalue + "<br>";
        res += "ID : " + idvalue + "<br>";
        res += "<span>환영합니다<span><br>"
		document.getElementById('result2').innerHTML = res;
	}