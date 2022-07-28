package com.haeun.profileweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor	//인수가 없는 생성자
@AllArgsConstructor	//인수가 있는 생성자
public class BoardDto {
	
	private int qnum;		//게시판 번호
	private String qid;		//게시판 글쓴이 아이디
	private String qname;	//게시판 글쓴이 이름
	private String qcontent;//게시판 내용
	private String qemail;	//게시판 글쓴이 이메일
	private String qdate;	//게시판 글쓴 날짜
}