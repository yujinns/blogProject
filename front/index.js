// 보이기/숨기기 - 토글
function showLogin(){
  var objId = document.getElementById('login');

  if(objId.style.display=="block"){
     objId.style.display = "none";

  } else {
     objId.style.display = "block";
  }

  var objId2 = document.getElementById('login_bt')

  if(objId2.style.display=="none"){
  objId2.style.display = "block";
 
 }else {
 objId2.style.display = "none";
 }
}

//로그인 버튼
function chk_Lform() {
if(document.getElementById("L_id").value==''){
alert("아이디를 입력해주세요.");
return false;
}
if(document.getElementById("L_pwd").value==''){
alert("비밀번호를 입력해주세요.");
return false;
}
document.getElementById('frm1').submit();
}

//회원가입 보이기
function showSignup() {
var objId = document.getElementById('signup');

if(objId.style.display=="block"){
objId.style.display = "none";

} else {
objId.style.display = "block";
}

var objId2 = document.getElementById('signup_bt')

if(objId2.style.display=="none"){
objId2.style.display = "block";

}else {
objId2.style.display = "none";
}  

var objId2 = document.getElementById('L_id')

if(objId2.style.display=="none"){
objId2.style.display = "block";

}else {
objId2.style.display = "none";
}  

var objId2 = document.getElementById('L_pwd')

if(objId2.style.display=="none"){
objId2.style.display = "block";

}else {
objId2.style.display = "none";
}  

var objId2 = document.getElementById('login_btt')

if(objId2.style.display=="none"){
objId2.style.display = "block";

}else {
objId2.style.display = "none";
}  

var objId2 = document.getElementById('pwd_ch_bt')

if(objId2.style.display=="none"){
objId2.style.display = "block";

}else {
objId2.style.display = "none";
}  

var objId2 = document.getElementById('service_n')

if(objId2.style.display=="none"){
objId2.style.display = "block";

}else {
objId2.style.display = "none";
}  
}

//회원가입 -> 로그인창
function hideSignup() {
var objId = document.getElementById('signup');

if(objId.style.display=="block"){
objId.style.display = "none";

} else {
objId.style.display = "block";
}

var objId2 = document.getElementById('signup_bt')

if(objId2.style.display=="none"){
objId2.style.display = "";

}else {
objId2.style.display = "none";
}  

var objId2 = document.getElementById('L_id')

if(objId2.style.display=="none"){
objId2.style.display = "";

}else {
objId2.style.display = "none";
}  

var objId2 = document.getElementById('L_pwd')

if(objId2.style.display=="none"){
objId2.style.display = "";

}else {
objId2.style.display = "none";
}  

var objId2 = document.getElementById('login_btt')

if(objId2.style.display=="none"){
objId2.style.display = "";

}else {
objId2.style.display = "none";
}  

var objId2 = document.getElementById('pwd_ch_bt')

if(objId2.style.display=="none"){
objId2.style.display = "";

}else {
objId2.style.display = "none";
}  

var objId2 = document.getElementById('service_n')

if(objId2.style.display=="none"){
objId2.style.display = "";

}else {
objId2.style.display = "none";
}   
}

//회원가입 버튼
function chk_Sform() {
if(document.getElementById("S_id").value==''){
alert("아이디를 입력해주세요.");
return false;
}
if(document.getElementById("S_pwd").value==''){
alert("비밀번호를 입력해주세요.");
return false;
}
var s_pwd = document.getElementById("S_pwd").value;
var s_pwd_ck = document.getElementById("S_pwd_ck").value;

if (s_pwd != s_pwd_ck) {
alert("패스워드가 일치하지 않습니다.");
return false;
}
if(document.getElementById("S_name").value==''){
alert("이름을 입력해주세요.");
return false;
}
if(document.getElementById("S_email").value==''){
alert("이메일을 입력해주세요.");
return false;
}
if(document.getElementById("S_pwd_a").value==''){
alert("답변을 입력해주세요.");
return false;
}
document.getElementById('frm2').submit();
}

//비밀번호 찾기 보이기
function showFind() {
  var objId = document.getElementById('find_pwd');
  
  if(objId.style.display=="block"){
  objId.style.display = "none";
  
  } else {
  objId.style.display = "block";
  }
  
  var objId2 = document.getElementById('signup_bt')
  
  if(objId2.style.display=="none"){
  objId2.style.display = "block";
  
  }else {
  objId2.style.display = "none";
  }  
  
  var objId2 = document.getElementById('L_id')
  
  if(objId2.style.display=="none"){
  objId2.style.display = "block";
  
  }else {
  objId2.style.display = "none";
  }  
  
  var objId2 = document.getElementById('L_pwd')
  
  if(objId2.style.display=="none"){
  objId2.style.display = "block";
  
  }else {
  objId2.style.display = "none";
  }  
  
  var objId2 = document.getElementById('login_btt')
  
  if(objId2.style.display=="none"){
  objId2.style.display = "block";
  
  }else {
  objId2.style.display = "none";
  }  
  
  var objId2 = document.getElementById('pwd_ch_bt')
  
  if(objId2.style.display=="none"){
  objId2.style.display = "block";
  
  }else {
  objId2.style.display = "none";
  }  
  
  var objId2 = document.getElementById('service_n')
  
  if(objId2.style.display=="none"){
  objId2.style.display = "block";
  
  }else {
  objId2.style.display = "none";
  }  
  }

  function hideFindpwd() {
    var objId = document.getElementById('find_pwd');
    
    if(objId.style.display=="block"){
    objId.style.display = "none";
    
    } else {
    objId.style.display = "block";
    }
    
    var objId2 = document.getElementById('signup_bt')
    
    if(objId2.style.display=="none"){
    objId2.style.display = "";
    
    }else {
    objId2.style.display = "none";
    }  
    
    var objId2 = document.getElementById('L_id')
    
    if(objId2.style.display=="none"){
    objId2.style.display = "";
    
    }else {
    objId2.style.display = "none";
    }  
    
    var objId2 = document.getElementById('L_pwd')
    
    if(objId2.style.display=="none"){
    objId2.style.display = "";
    
    }else {
    objId2.style.display = "none";
    }  
    
    var objId2 = document.getElementById('login_btt')
    
    if(objId2.style.display=="none"){
    objId2.style.display = "";
    
    }else {
    objId2.style.display = "none";
    }  
    
    var objId2 = document.getElementById('pwd_ch_bt')
    
    if(objId2.style.display=="none"){
    objId2.style.display = "";
    
    }else {
    objId2.style.display = "none";
    }  
    
    var objId2 = document.getElementById('service_n')
    
    if(objId2.style.display=="none"){
    objId2.style.display = "";
    
    }else {
    objId2.style.display = "none";
    }   
    }