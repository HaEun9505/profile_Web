package com.haeun.profileweb;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haeun.profileweb.dao.IDao;

@Controller
public class WebController {
	
	@Autowired	//외부에서 객체를 생성해서 주입
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/")	// 첫 페이지 - index
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/index")	// /jsp
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/profile")
	public String profile() {
		return "profile";
	}
	
	@RequestMapping(value = "/contact")
	public String contact() {
		return "contact";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/question")
	public String question() {
		return "question";
	}
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/list")
	public String list() {
		return "list";
	}
	
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public String joinOk(HttpServletRequest request, Model model) {
		
		//request 객체로 값 빼기
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		//dao 호출하면 sqlSession과 연결됨
		IDao dao = sqlSession.getMapper(IDao.class);
		
		int checkId = dao.checkIdDao(mid);	//아이디 존재 여부체크(1이면 존재, 0이면 존재 X)
		
		//checkId가 0 일때만 가입(값이 없을때만)
		if(checkId==0) {
			dao.joinDao(mid, mpw, mname, memail);
			
			//model 객체에 실어서 전달(joinOk-${}에 값을 전달)
			model.addAttribute("mname", mname);
			model.addAttribute("mid", mid);
		}
		model.addAttribute("checkId", checkId);	//checkId 값이 1(아이디 존재) 또는 0(존재 안함) 전송
		
		return "joinOk";
	}
}
