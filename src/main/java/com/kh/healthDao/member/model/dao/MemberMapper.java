package com.kh.healthDao.member.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.healthDao.member.model.vo.Member;
import com.kh.healthDao.member.model.vo.MemberRole;

@Mapper
public interface MemberMapper {
	/* 아이디를 가진 사용자 정보를 조회해온 뒤 패스워드 비교는 스프링 시큐리티 모듈을 통해 처리
	 * DB에서 id, pwd를 비교하는 것이 아니라 BCryptEncoder 객체가 가진 matchers 메소드를 통해 비교함
	 * (salt가 첨가되므로 매번 같은 문자열이 도출되지 않음) */
	Member findMemberById(String userId);

	/* 회원 가입 로직 */
	void insertMember(Member member);

	void insertMemberRole(MemberRole memberRole);
	
	// 아이디 중복 체크
	int idChk(Member member);

}
