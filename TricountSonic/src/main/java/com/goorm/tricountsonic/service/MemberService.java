package com.goorm.tricountsonic.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goorm.tricountsonic.model.Member;
import com.goorm.tricountsonic.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    
    // 회원가입
    @Transactional
    public Member signup(Member member) {
        //먼저 중복회원 가입이 되어있는지 여부를 아는 로직이 필요
        memberRepository.findByLoginId(member.getLoginId())
          .ifPresent((member1 -> {
              throw new RuntimeException("login id duplicated");
          }));

        return memberRepository.save(member);
    }


    // 로그인
  public Member login(String loginId, String password) {
      // id,pw 일치 확인
      Member loginMember = memberRepository.findByLoginId(loginId)
        .filter(m -> m.getPassword().equals(password))
        .orElseThrow(() -> new RuntimeException("Member info is not found!"));

      return loginMember;
  }


    
    // 조회 - context
  public Member findMemberById(Long memberId) {
      Optional<Member> loginMember = memberRepository.findById(memberId);
      if (!loginMember.isPresent()) {
        throw new RuntimeException("Member info is not found!");
      }
      return  loginMember.get();
  }

}
