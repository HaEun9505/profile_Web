package com.haeun.profileweb.dao;

import java.util.ArrayList;

import com.haeun.profileweb.dto.BoardDto;
import com.haeun.profileweb.dto.MemberDto;

public interface IDao {
	
	//멤버 관련 dao 메소드
	
	//회원가입 메소드(insert)
	public void joinDao(String mid, String mpw, String mname, String memail);
	public int checkIdDao(String mid);	//회원가입 여부 체크 메소드(아이디가 존재하면 1, 아니면 0 반환)
	public int checkIdPwDao(String mid, String mpw);	//아이디와 비밀번호 일치여부 체크(일치하면 1, 아니면 0)
	public MemberDto memberInfoDao(String mid);	//아이디로 검색해서 해당 아이디의 모든 정보를 반환하는 메소드
	//Parameter에 넣을 값 순서대로 지정
	public void infoModifyDao(String mpw, String mname, String memail, String mid);	//회원정보 수정 메소드
	
	//board 관련 dao 메소드
	public void writeDao(String qid, String qname, String qcontent, String qemail);	//게시판 글쓰기
	public ArrayList<BoardDto> listDao();	//게시판 글목록 가져오기(전부 가져오기 때문에 변수 필요 X)
	public BoardDto contentViewDao(String qnum);	//게시판 글 내용 가져오기(글 번호로 검색해서 해당 글번호의 모든 정보를 반환)
	public void deleteDao(String qnum);	//게시판 글 삭제
	public void qModifyDao(String qname, String qcontent, String qemail, String qnum);
}
