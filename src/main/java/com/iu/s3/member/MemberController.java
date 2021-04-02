package com.iu.s3.member;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.s3.bankBook.BankBookDTO;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("memberJoinCheck")
	public void memberJoinCheck() throws Exception {
		
	}
	@RequestMapping("memberJoin")
	public void memberJoin() throws Exception {
		
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO, Model model) throws Exception {
		int result = memberService.memberJoin(memberDTO);

		String message = "회원가입 실패";	
		String path="./memberJoin";
		if(result>0) {
			message ="회원가입 성공";
			path="../";
		}
		//memberjoinResult로 model이용해 메시지 전송
		model.addAttribute("msg",message);
		model.addAttribute("path",path);
		return "common/commonResult";
	}
	
	@RequestMapping("memberLogin")
	public void memberLogin() throws Exception {
		
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public String memberLogin(MemberDTO memberDTO, HttpSession session) throws Exception {
		memberDTO = memberService.memberLogin(memberDTO);
		System.out.println(memberDTO); //login 성공했는지 여부를 보기 위함
		session.setAttribute("member", memberDTO);
		return "redirect:../";
	}
	
	@RequestMapping("memberLogout")
	public String memberLogout(HttpSession session) throws Exception {
		session.invalidate(); //session의 유지시간을 0으로 만들겠다는 코드! -> 유지시간이 0이되면 로그아웃됨
		return "redirect:../"; //index로 보냄
	}
	
	@RequestMapping("memberPage")
	public void memberPage() throws Exception {
		
	}
	
	@RequestMapping("memberDelete")
	public String memberDelete(HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result = memberService.memberDelete(memberDTO);
		session.invalidate(); //session 삭제하면서 로그아웃까지 진행
		return "redirect:../";
	}
	
	@RequestMapping("memberUpdate")
	public void memberUpdate() throws Exception {
		
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		int result = memberService.memberUpdate(memberDTO);
		if(result>0) {
			session.setAttribute("member", memberDTO); //session의 저장된 데이터를 바꿔주기
		}
		return "redirect:../";
	}
}
