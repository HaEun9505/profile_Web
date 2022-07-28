package com.haeun.profileweb.dao;

import com.haeun.profileweb.dto.MemberDto;

public interface IDao {
	
	//멤버 관련 dao 메소드
	
	//회원가입 메소드(insert)
	public void joinDao(String mid, String mpw, String mname, String memail);
	public int checkIdDao(String mid);	//회원가입 여부 체크 메소드(아이디가 존재하면 1, 아니면 0 반환)
	public int checkIdPwDao(String mid, String mpw);	//아이디와 비밀번호 일치여부 체크(일치하면 1, 아니면 0)
	public MemberDto memberInfoDao(String mid);	//id로 검색해서 해당 id의 모든 정보를 반환하는 메소드 
	
	
	//board 관련 dao 메소드
}
