function validateRegister() {
    var uid = document.getElementById('id').value;
    var uname = document.getElementById('name').value;
    var pwd = document.getElementById('pwd').value;
    var repwd = document.getElementById('pwdcheck').value;
    var email_id = document.getElementById('email').value;
    var pwd_a = document.getElementById('pwd_a').value;
    var pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;
    
    if ( uid.value == "" ) { //해당 입력값이 없을 경우 같은말: if(!uid.value)   
    alert( "아이디를 입력하세요.");
    uid.focus(); //focus(): 커서가 깜빡이는 현상, blur(): 커서가 사라지는 현상   
    return false; //return: 반환하다 return false:  아무것도 반환하지 말아라 아래 코드부터 아무것도 진행하지 말것 

  }else if ( pwd.value == "" ) {
    alert( "비밀번호를 입력하세요." );
    pwd.focus();
    return false;

  }else if (!pwdCheck.test(pwd.value)) {
    alert( "비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다." );
    pwd.focus();
    return false;

  }else if (repwd.value !== pwd.value) {
    alert( "비밀번호가 일치하지 않습니다.." );
    repwd.focus();
    return false;

  }else if (pwd_a.value == "") {
    alert("답변을 입력하세요.");
    uname.focus();
    return false;

  }else if (uname.value == "") {
    alert("이름을 입력하세요.");
    uname.focus();
    return false;

  }else if (email_id.value == "") {
    alert("이메일 주소를 입력하세요.");
    email_id.focus();
    return false;
  }else{

    //입력 값 전송   
    document.registerForm.submit();  //유효성 검사의 포인트      
}}