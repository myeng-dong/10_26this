package com.kh.com.kh.web.Controller.postbox;


import com.kh.com.kh.domain.svc.PostBoxsSVC.EstimateBoxSVC.EstimateBoxSVC;
import com.kh.com.kh.web.form.estimateForm.EstimateAllForm;
import com.kh.com.kh.web.form.memberForm.SessionForm;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping
public class EstimateBoxController {

  private final EstimateBoxSVC estimateBoxSVC;

  @GetMapping("/postEs")
  public ModelAndView postEs(
      HttpSession session
  ){
    ModelAndView mv = new ModelAndView();
    SessionForm sessionForm = (SessionForm) session.getAttribute("sessionForm");
    List<EstimateAllForm> allPostEs = estimateBoxSVC.findAllPostEs(sessionForm.getMember_id());
    mv.addObject("allPostEs",allPostEs);
    mv.setViewName("webPage/postboxs/estimate/estimatePost");
    return mv;
  }

  @GetMapping("/getEs")
  public ModelAndView GetEs(
      HttpSession session
  ){
    ModelAndView mv = new ModelAndView();
    SessionForm sessionForm = (SessionForm) session.getAttribute("sessionForm");
    List<EstimateAllForm> allGetEs = estimateBoxSVC.findAllGetEs(sessionForm.getMember_id());
    mv.addObject("allGetEs",allGetEs);
    mv.setViewName("webPage/postboxs/estimate/estimateGet");
    return mv;
  }
}
