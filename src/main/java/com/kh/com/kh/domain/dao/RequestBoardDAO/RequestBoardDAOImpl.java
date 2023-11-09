package com.kh.com.kh.domain.dao.RequestBoardDAO;

import com.kh.com.kh.domain.dao.entity.WorkGive;
import com.kh.com.kh.domain.dao.entity.WorkGiveAll;
import com.kh.com.kh.domain.dao.entity.WorkGiveNick;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RequestBoardDAOImpl implements RequestBoardDAO{
  private final NamedParameterJdbcTemplate template;

  @Override
  public List<WorkGiveAll> findRQBoardAll() {
    String sql =
        ("select board_id,member_id,category,area,hope_date,hope_text from requestBoard order by cdate ");
    String sql2 =
        ("select r1.member_id,nickname from requestBoard r1, member m1 where r1.member_id = m1.member_id ");

    List<WorkGiveAll> query = template.query(sql, BeanPropertyRowMapper.newInstance(WorkGiveAll.class));
    List<WorkGiveNick> queryNick = template.query(sql2, BeanPropertyRowMapper.newInstance(WorkGiveNick.class));

    for (int i = 0; i < query.size(); i++) {
      for (int j = 0; j < queryNick.size(); j++) {
      if(query.get(i).getMember_id().equals(queryNick.get(j).getMember_id())){
        query.get(i).setNickname(queryNick.get(j).getNickname());
        }}}

    log.info("DAOquery={}",query);
    return query;
  }

  @Override
  public WorkGive findRQBoard(Long pid) {
    // 단건조회
    String sql = ("select board_id,member_id,category,area,hope_date,hope_text from requestBoard where board_id = :board_id");
    Map<String, Long> param = Map.of("board_id",pid);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    WorkGive workGive = template.queryForObject(sql, param, BeanPropertyRowMapper.newInstance(WorkGive.class));
    Long memberId = workGive.getMember_id();
    // 해당건 닉네임 조회
    String sql2 =
        ("select member_id, nickname from member where member_id = :memberId");
    Map<String,Long> param2 = Map.of("memberId",memberId);
    WorkGiveNick workGiveNick = template.queryForObject(sql2, param2, BeanPropertyRowMapper.newInstance(WorkGiveNick.class));
    workGive.setNickname(workGiveNick.getNickname());
    return workGive;
  }
}
