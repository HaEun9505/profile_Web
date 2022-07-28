package com.haeun.profileweb.dao;

public interface IDao {
	
	//멤버 관련 dao 메소드
	
	//회원가입 메소드(insert)
	public void joinDao(String mid, String mpw, String mname, String memail);
	public int checkIdDao(String mid);	//회원가입 여부 체크 메소드(아이디가 존재하면 1, 아니면 0 반환)
	
	
	//board 관련 dao 메소드
}
