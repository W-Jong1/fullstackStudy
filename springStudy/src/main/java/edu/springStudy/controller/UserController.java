package edu.springStudy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.springStudy.service.UserService;
import edu.springStudy.vo.UserVO;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/list.do")
	public String list(Model model) {
		List<UserVO> list = userService.list();
		model.addAttribute("list", list);
		return "user/list";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public void login(
			UserVO vo
		,	HttpServletRequest req
		,	HttpServletResponse res
		) throws IOException {
		res.setContentType("text/html;chars=UTF-8");
		PrintWriter pw = res.getWriter();
		HttpSession session = req.getSession();
		UserVO loginVO = userService.selectUserByLogin(vo);
		if(loginVO != null) {
			// 성공
			System.out.println("회원존재");
			pw.append("<script>alert('로그인 되었습니다.');location.href='"+req.getContextPath()+"/';</script>");
			session.setAttribute("login", loginVO);
		}else {
			// 존재하지 않음
			System.out.println("회원존재X");
			pw.append("<script>alert('로그인에 실패하였습니다.');location.href='login.do';</script>");
		}
		pw.flush();
	}
	
	@RequestMapping(value="/logout.do")
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html;chars=UTF-8");
		PrintWriter pw = res.getWriter();
		try {
			HttpSession session = req.getSession();
			session.invalidate();
			pw.append("<script>alert('로그아웃 되었습니다.');location.href='"+req.getContextPath()+"/'</script>");
		}catch(Exception e) {
			e.printStackTrace();
			pw.append("<script>alert('로그아웃시 예외가 발생했습니다.');location.href='"+req.getContextPath()+"/'</script>");
		}
		pw.flush();
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(UserVO vo, HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserVO loginVO = (UserVO)session.getAttribute("login");
		if(loginVO != null) {
			return "redirect:/";
		}
		System.out.println(vo.toString());
		int result = userService.join(vo);
		if(result>0) {
			UserVO joinLoginVO = userService.selectUserByLogin(vo);
			if(joinLoginVO != null) {
				session.setAttribute("login", joinLoginVO);
				return "redirect:/";
			}else {
				return "redirect:join.do";
			}
		}else {
			return "redirect:join.do";
		}
	}
}
