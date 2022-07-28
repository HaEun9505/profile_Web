package com.haeun.profileweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//데이터 이동 객체 클래스

@Getter
@Setter
@NoArgsConstructor	//인수가 없는 생성자
@AllArgsConstructor	//모든 필드가 들어있는 생성자
//위에 선언해야 모든 변수 생성자를 만듦

public class MemberDto {
	
	private String mid;		//가입한 아이디
	private String mpw;		//가입한 비밀번호
	private String mname;	//가입한 이름
	private String memail;	//가입한 이메일
	private String mdate;	//가입일
	
	
}
