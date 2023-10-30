package com.kh.com.kh.web.Controller;

import com.kh.com.kh.domain.dao.entity.Member;
import com.kh.com.kh.domain.svc.MemberSVC.MemberSVC;
import com.kh.com.kh.domain.svc.MyPageSVC.MyPageSVC;
import com.kh.com.kh.web.form.memberForm.SessionForm;
import com.kh.com.kh.web.form.userupdateForm.UpdateCKForm;
import com.kh.com.kh.web.form.userupdateForm.UpdateForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/update")
@RequiredArgsConstructor
public class UserUpdateConteroller {

private final MyPageSVC myPageSVC;

  @GetMapping
  public ModelAndView update(
    UpdateCKForm updateCKForm
  ){
    ModelAndView mv = new ModelAndView();
    mv.addObject("updateCKForm",updateCKForm);
    mv.setViewName("webPage/myPage/cus_update");
    return mv;
  }
  // 회원 정보 수정
  @PostMapping
  public ModelAndView updateForm(
      UpdateCKForm updateCKForm,
      HttpSession session
  ){
    ModelAndView mv = new ModelAndView();
    SessionForm sessionInfo = (SessionForm) session.getAttribute("sessionForm");
    log.info("sessionMember",sessionInfo.getMember_id());
    log.info("updateCK={}",updateCKForm);

    UpdateForm updateForm = new UpdateForm();
    updateForm.setMember_id(sessionInfo.getMember_id());
    updateForm.setNickname(sessionInfo.getNickname());
    updateForm.setPasswd(sessionInfo.getPasswd());
    updateForm.setPic(sessionInfo.getPic());
    updateForm.setTel(sessionInfo.getTel());

    if(updateCKForm.getNickname() != null){
      updateForm.setNickname(updateCKForm.getNickname());
    } else if(updateCKForm.getTel() != null){
      updateForm.setTel(updateCKForm.getTel());
    } else if(updateCKForm.getPasswd() != null){
      updateForm.setPasswd(updateCKForm.getPasswd());
    } else {
      updateForm.setPic(updateCKForm.getPic());
    }

    log.info("updateFormLAST={}",updateForm);
    Long updateCnt = myPageSVC.updateCnt(updateForm);
    log.info("updateFormLAST={}",updateCnt);

    SessionForm sessionForm = new SessionForm(
        updateForm.getMember_id(), sessionInfo.getEmail(), updateForm.getNickname(),sessionInfo.getGubun(),
        updateForm.getTel(),updateForm.getPic(),updateForm.getPasswd()
    );
    session.setAttribute("sessionForm",sessionForm);
    mv.addObject("updateCKForm",sessionForm);
    mv.setViewName("redirect:/update");
    return mv;
  }

  @PostMapping("/delete")
  public ModelAndView deletePicForm(
      UpdateCKForm updateCKForm
  ){
    ModelAndView mv = new ModelAndView();
    log.info("updateCK={}",updateCKForm);
    log.info("update/delete={}","호출됨!");
    mv.setViewName("webPage/myPage/cus_update");
    return mv;
  }
}
