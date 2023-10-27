package com.kh.com.kh.web.Controller;

import com.kh.com.kh.domain.svc.MemberSVC.MemberSVC;
import com.kh.com.kh.web.form.userupdateForm.UpdateCKForm;
import com.kh.com.kh.web.form.userupdateForm.UpdateForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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


  @GetMapping
  public ModelAndView update(
    UpdateCKForm updateCKForm
  ){
    ModelAndView mv = new ModelAndView();
    mv.addObject("updateCKForm",updateCKForm);
    mv.setViewName("webPage/myPage/cus_update");
    return mv;
  }

  @PostMapping
  public ModelAndView updateForm(
      UpdateCKForm updateCKForm
  ){
    ModelAndView mv = new ModelAndView();
    log.info("updateCK={}",updateCKForm);
    mv.setViewName("webPage/myPage/cus_update");
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
