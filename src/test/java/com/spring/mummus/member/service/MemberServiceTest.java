package com.spring.mummus.member.service;

import com.spring.mummus.member.dto.MemberSignUpRequest;
import com.spring.mummus.member.entity.Member;
import com.spring.mummus.member.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class MemberServiceTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

  
    @AfterEach
    void tearDown() {
        memberRepository.deleteAll();
    }

  
    @Test
    @DisplayName("회원가입이 성공한다.")
    void signUpSuccess() {
        //given
        MemberSignUpRequest memberSignUpRequest = new MemberSignUpRequest("test@naver.com", "password", "testName", "testAddress", "testPhoneNumber");

        //when
        memberService.signUp(memberSignUpRequest);
        Member member = memberRepository.findById(1L).get();

        //then
        assertThat(member.getEmail()).isEqualTo("test@naver.com");
        assertThat(member.getName()).isEqualTo("testName");
        assertThat(member.getPassword()).isEqualTo("password");
        assertThat(member.getAddress()).isEqualTo("testAddress");
        assertThat(member.getPhoneNumber()).isEqualTo("testPhoneNumber");
    }

}