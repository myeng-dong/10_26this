package com.kh.com.kh.domain.dao.RequestBoardDAO;

import com.kh.com.kh.domain.dao.entity.WorkGive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RequestBoardDAOImpl implements RequestBoardDAO{
  private final NamedParameterJdbcTemplate template;

  @Override
  public List<WorkGive> findRQBoardAll() {
    String sql = ("select board_id,member_id,nickname,category,area,hope_date,hope_text from requestBoard ");

    List<WorkGive> query = template.query(sql, BeanPropertyRowMapper.newInstance(WorkGive.class));
    log.info("DAOquery={}",query);
    return query;
  }

  @Override
  public WorkGive findRQBoard(Long pid) {
    String sql = ("select board_id,member_id,nickname,category,area,hope_date,hope_text from requestBoard where board_id = :board_id");
    Map<String, Long> param = Map.of("board_id",pid);
    WorkGive workGive = template.queryForObject(sql, param, BeanPropertyRowMapper.newInstance(WorkGive.class));

    return workGive;
  }
}
