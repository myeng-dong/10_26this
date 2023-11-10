package com.kh.com.kh.domain.dao.MemberDAO;



import com.kh.com.kh.domain.dao.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
@SpringBootTest@Slf4j
public class MemberDAOTest {
    @Autowired
    private MemberDAO memberDAO;
    @Test
    @DisplayName("가입 이메일 찾기")
    void findEmail(){
        String tel= "010-1111-1111";
        Optional<String> findedEmail= memberDAO.findEmailByTel(tel);
        String pickedEmail = findedEmail.get();
        log.info("email= {}",pickedEmail);
        Assertions.assertThat(pickedEmail).isNotBlank();
    }
    @Test@DisplayName("가입 이메일 없음")
    void isEmptyEmail(){
        String tel= "010-1112-1115";
        Optional<String> findedEmail = memberDAO.findEmailByTel(tel);
        Assertions.assertThat(findedEmail.isEmpty()).isTrue();
    }
    @Test
    @DisplayName("이메일, 전화번호로 가입자 확인")
    void existBoolean(){
        String email = "naruplace19@gmail.com";
        String tel = "010-1111-1111";
        boolean existUser = memberDAO.existUser(email,tel);
        log.info("boolean= {}", existUser);
        Assertions.assertThat(existUser).isTrue();
    }
    @Test@DisplayName("비밀번호 변경")
    void changePasswd(){
        String email = "naruplace19@gmail.com";
        String passwd = "1234";
        int returnsValue = memberDAO.changePasswd(email,passwd);
        log.info("returnsValue= {}", returnsValue);
        Assertions.assertThat(returnsValue).isEqualTo(1);
        Optional<Member> user = memberDAO.findByInfo(email);
        if(user.isPresent()){
            Member member = user.get();
            log.info("getPasswd= {}",member.getPasswd());
            Assertions.assertThat(member.getPasswd()).isEqualTo(passwd);
        }else{
            Assertions.fail("회원정보없음");
        }
    }
}
