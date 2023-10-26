package com.kh.com.kh.domain.dao.RequestBoardDAO;

import com.kh.com.kh.domain.dao.entity.WorkGive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RequestBoardDAOImpl implements RequestBoardDAO{
  private final NamedParameterJdbcTemplate template;

  @Override
  public List<WorkGive> findRQBoard() {
    return null;
  }
}
