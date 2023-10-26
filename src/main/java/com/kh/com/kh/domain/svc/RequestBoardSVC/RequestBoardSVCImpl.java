package com.kh.com.kh.domain.svc.RequestBoardSVC;

import com.kh.com.kh.domain.dao.RequestBoardDAO.RequestBoardDAO;
import com.kh.com.kh.domain.dao.entity.WorkGive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestBoardSVCImpl implements RequestBoardSVC{

  private final RequestBoardDAO requestBoardDAO;
  @Override
  public List<WorkGive> findRQBoard() {
    return null;
  }
}
