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
import org.springframework.web.bind.annotation.ResponseBody;

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
			/* session.setAttribute("key", null); 특정 키만 초기화 */
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
	public String join(UserVO vo, String ageStr) {
		// age는 필수값이 아니지만, VO에서 age는 int형으로 null로 insert 불가.
		if(ageStr != null && !ageStr.equals("")) {
			vo.setAge(Integer.parseInt(ageStr));
		}
		
		int result = userService.insert(vo);
		if(result > 0) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		return "redirect:login.do";
	}
	
	@RequestMapping(value="/checkId.do", method=RequestMethod.POST)
	@ResponseBody
	public String checkId(String id) {
		int result = userService.selectCntById(id);
		return result+"";
	}
}
