import { ajax } from "/js/common/common.js";
//rtcd
const $email = document.querySelector('#email');
const $tel = document.querySelector("#tel");
const $errMessage = document.querySelector("#errMessage");
const $emailSenderButton = document.querySelector("#emailSender");

$emailSenderButton.addEventListener('click', e => { 
   sendMail($email.value, $tel.value, $errMessage, e.target);
});

const sendMail = async (email, tel, errMessage, click) => {
   const url = "/http://localhost:9080/memberChange";
   const data = { email, tel };
   errMessage.textContent = "전송중...";
   click.disable = true;
   const result = await ajax.post(url, data);
   if (result.header.rtcd === "00") { 
      errMessage.textContent = "이메일로 전송 완료";
   } else {
      errMessage.textContent = "회원의 정보가 없습니다.";
   }
}