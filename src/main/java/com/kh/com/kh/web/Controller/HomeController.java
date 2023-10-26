package com.kh.com.kh.web.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping
// ()의 경로와 컨트롤러를 이어주는 것 경로 = 키 컨트롤러 = 밸류
public class HomeController {

  @GetMapping("/")
  public ModelAndView webAddForm(
      HttpServletRequest request
  ){
    ModelAndView mv = new ModelAndView();
    String view = null;
    HttpSession loginCheck = request.getSession(false);

    log.info("session ={}",loginCheck);
    mv.addObject("loginCheck",loginCheck);
    mv.setViewName("webPage/indexs/index");
    return mv;
  }
  }
