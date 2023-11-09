package com.kh.com.kh.web.Controller.filebox;

import com.kh.com.kh.web.form.FileTest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FileController {

  @GetMapping("file")
  public ModelAndView testFile(
      FileTest fileTest
  ){
    ModelAndView mv = new ModelAndView();
    mv.addObject("fileTest",fileTest);
    mv.setViewName("filetest/filetest");
    return mv;
  }

  @PostMapping("file")
  public ModelAndView posttest(
      FileTest fileTest

  ){
    ModelAndView mv = new ModelAndView();
    fileTest.setTable_info("memberPic");

    return mv;
  }
}
//  private Long uploadfileId; 시퀀스
//  private String table_info; 해당테이블의 정보
//  private Long table_id;
//  private String store_filename;
//  private String upload_filename;
//  private String fsize;
//  private String ftype;
//  private LocalDateTime cdate;