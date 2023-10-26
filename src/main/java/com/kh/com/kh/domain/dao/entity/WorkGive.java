package com.kh.com.kh.domain.dao.entity;

import lombok.Data;

@Data
public class WorkGive {
  private Long Board_id;
  private Long member_id;
  private String nickname;
  private String category;
  private String area;
  private String hope_date;
  private String hope_text;
}
