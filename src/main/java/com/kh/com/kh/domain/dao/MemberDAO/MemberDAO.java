package com.kh.com.kh.domain.dao.MemberDAO;

import com.kh.com.kh.domain.dao.entity.Member;

import java.util.Optional;

public interface MemberDAO {
  Optional<Member> findByInfo (String email);

  Boolean nickExist (String nickname);

  Member insert(Member member);

  //아이디찾기
  Optional<String> findEmailByTel(String tel);

  //비밀번호 유무확인
  boolean existUser(String email, String tel);

  //비밀번호 변경
  int changePasswd(String email, String passwd);
}
