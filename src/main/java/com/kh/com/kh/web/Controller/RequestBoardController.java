package com.kh.com.kh.web.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Controller
@RequestMapping
@RequiredArgsConstructor
public class RequestBoardController {

  @GetMapping("/requestBoard")
  public ModelAndView request(
      HttpServletRequest request
  ){
    ModelAndView mv = new ModelAndView();
    HttpSession loginCheck = request.getSession(false);
    mv.addObject("loginCheck",loginCheck);

    mv.setViewName("webPage/requestBoard/requestBoard");
    return mv;
  }
}
