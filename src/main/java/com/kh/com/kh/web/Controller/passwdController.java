package com.kh.com.kh.web.Controller;


import com.kh.com.kh.domain.dao.MailService.MailService;
import com.kh.com.kh.domain.svc.MemberSVC.MemberSVC;
import com.kh.com.kh.web.form.memberForm.FindPasswdForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
import java.util.UUID;
@Controller
@Slf4j@RequiredArgsConstructor@RequestMapping("/memberChange")
public class passwdController {
    private final MemberSVC memberSVC;
    private final MailService mailService;
    @GetMapping
    public String changePasswd(){
        log.info("제발 좀 되라");
        return "webPage/Login/changePasswd";
    }
    //비밀번호 찾기
    @PostMapping
    public String findPasswd(
            @Valid @ModelAttribute FindPasswdForm findPasswdForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ){
        boolean existUser = memberSVC.existUser(findPasswdForm.getEmail(),findPasswdForm.getTel());
        log.info("파인드패스워드= {}");
        if(existUser){
            String randomPasswd = UUID.randomUUID().toString().substring(0,5);
            memberSVC.changePasswd(findPasswdForm.getEmail(),randomPasswd);
            StringBuffer str = new StringBuffer();
            str.append("<html>");
            str.append("<p><b>");
            str.append(randomPasswd);
            str.append("</b></p>");
            str.append("<p>위 임시번호로 로그인후 비밀번호 변경 바랍니다.</p>");
            str.append("<a href='http://localhost:9080/login'>로그인</a>");
            str.append("</html>");
            mailService.sendMail(findPasswdForm.getEmail(),"임시비밀번호",str.toString());
        }else{
            log.info("실패= {}");
        }
        return "redirect:/memberChange";
    }
    @GetMapping("/findEmail")
    public String findEmailForm(){
        return "webPage/Login/findEmail";
    }
    @ResponseBody@PostMapping("/findEmail")
    public String findEmail(
          @ModelAttribute
          FindPasswdForm findPasswdForm
    ){
        log.info("이메일확인");
        Optional<String> findedEmail = memberSVC.findEmailByTel(findPasswdForm.getTel());
        String showEmail = findedEmail.get();
        return showEmail;
    }
}
