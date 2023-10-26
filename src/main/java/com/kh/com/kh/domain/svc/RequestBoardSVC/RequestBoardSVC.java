package com.kh.com.kh.domain.svc.RequestBoardSVC;

import com.kh.com.kh.domain.dao.entity.WorkGive;

import java.util.List;

public interface RequestBoardSVC {
  List<WorkGive> findRQBoard();
}
