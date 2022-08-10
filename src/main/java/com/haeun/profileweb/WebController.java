package com.haeun.profileweb;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haeun.profileweb.dao.IDao;
import com.haeun.profileweb.dto.BoardDto;
import com.haeun.profileweb.dto.MemberDto;

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
	public String question(HttpServletRequest request, Model model) {
		
		//request객체로 session값 빼오기
		HttpSession session = request.getSession();
		
		//세션 값 하나씩 가져오기(문자열이므로 업캐스팅)
		String sid = (String) session.getAttribute("sid");
		String sname = (String) session.getAttribute("sname");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		if(sid != null) {	// 로그인 되어있으면
			
			//로그인한 id의 모든 정보를 dto로 반환
			MemberDto memberDto = dao.memberInfoDao(sid);
			
			//데이터를 model 객체에 실어서 전달
			model.addAttribute("memberDto",memberDto);
			model.addAttribute("sid", sid);	//로그인한 아이디값을 넘겨줌
			
		}else {
			model.addAttribute("sid", "GUEST");
			model.addAttribute("sname", "");
		}
		
		return "question";
	}
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		//dtos를 반환
		ArrayList<BoardDto> dtos = dao.listDao();
		
		//dtos를 model 객체에 실어서 전달
		model.addAttribute("list",dtos);		
		
		return "list";
	}
	
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public String joinOk(HttpServletRequest request, Model model) {
		
		//request 객체로 값 빼오기
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
			
			//자동로그인
			HttpSession session = request.getSession();
			
			session.setAttribute("sid", mid);
			session.setAttribute("sname", mname);
			
			//데이터를 model 객체에 실어서 전달(joinOk-${}에 값을 전달)
			model.addAttribute("mname", mname);
			model.addAttribute("mid", mid);
		}
		model.addAttribute("checkId", checkId);	//checkId 값이 1(아이디 존재) 또는 0(존재 안함) 전송
		
		return "joinOk";
	}
	
	@RequestMapping(value = "/loginOk", method = RequestMethod.POST)
	public String loginOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		int checkId = dao.checkIdDao(mid);	//1이 반환되면 아이디가 존재
		
		int checkIdPw = dao.checkIdPwDao(mid, mpw);	//아이디와 비밀번호가 모두 일치하면 1 반환
		
		//데이터를 model 객체에 실어서 전달
		model.addAttribute("checkId",checkId);
		model.addAttribute("checkIdPw",checkIdPw);
		
		if(checkIdPw == 1) {	//checkId값이 1인 경우에만 로그인
			
			//로그인한 id의 모든 정보를 dto로 반환
			MemberDto memberDto = dao.memberInfoDao(mid);
			
			//비밀번호 체크(request객체로 session값 빼오기)
			HttpSession session = request.getSession();
			
			//세션에 저장(세션 생성)
			session.setAttribute("sid", memberDto.getMid());
			session.setAttribute("sname", memberDto.getMname());
			
			model.addAttribute("mid",memberDto.getMid());
			model.addAttribute("mname",memberDto.getMname());
		}
		return "loginOk";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		
		//세션 무효화
		session.invalidate();	//세션 삭제->로그아웃		
		
		return "login";
	}
	
	@RequestMapping(value = "/infoModify")
	public String infoModify(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		//request객체 안에서 session값 가져오기
		HttpSession session = request.getSession();
		
		//세션 값 가져오기(문자열이므로 업캐스팅)
		String sid = (String) session.getAttribute("sid");
		
		//로그인한 id의 모든 정보를 dto로 반환
		MemberDto memberDto = dao.memberInfoDao(sid);
		
		model.addAttribute("memberDto", memberDto);
		
		return "infoModify";
	}
	
	@RequestMapping(value = "/infoModifyOk")
	public String infoModifyOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		//dao 호출하면 sqlSession과 연결됨
		IDao dao = sqlSession.getMapper(IDao.class);
				
		dao.infoModifyDao(mpw, mname, memail, mid);
		
		//정보를 수정한 id의 모든 정보를 dto로 반환
		MemberDto memberDto = dao.memberInfoDao(mid);
		
		//데이터를 model 객체에 실어서 전달
		model.addAttribute("memberDto", memberDto);
		
		return "infoModifyOk";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(HttpServletRequest request, Model model) {
		
		String qid = request.getParameter("qid");
		String qname = request.getParameter("qname");
		String qcontent = request.getParameter("qcontent");
		String qemail = request.getParameter("qemail");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.writeDao(qid, qname, qcontent, qemail);
		
		return "redirect:list";	//새로고침(요청이 새로 들어옴)
	}
	
	@RequestMapping(value = "/qview")
	public String qview(HttpServletRequest request, Model model) {
		
		//request 객체로 값 빼오기
		String qnum = request.getParameter("qnum");
		
		//dao 호출하면 sqlSession과 연결됨
		IDao dao = sqlSession.getMapper(IDao.class);
		
		//정보를 가져와서 메소드로 반환
		BoardDto boardDto = dao.contentViewDao(qnum);
		
		//데이터를 model 객체에 실어서 전달
		model.addAttribute("contentDto", boardDto);
		
		model.addAttribute("boardId", boardDto.getQid());
		
		return "qview";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		//request 객체로 값 빼오기
		String qnum = request.getParameter("qnum");
		
		//dao 호출하면 sqlSession과 연결됨
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.deleteDao(qnum);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/qModify")
	public String modify(HttpServletRequest request, Model model) {
		
		String qname = request.getParameter("qname");
		String qcontent = request.getParameter("qcontent");
		String qemail = request.getParameter("qemail");		
		String qnum = request.getParameter("qnum");
	
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.qModifyDao(qname, qcontent, qemail, qnum);
		
		return "redirect:list";
	}
}
