package com.iu.s3.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iu.s3.member.MemberDTO;

@Controller
@RequestMapping("/account/**")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("accountList")
	public void getList(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member"); //id 세션을 가진것은 memberDTO이기때문에 호출
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(memberDTO.getId());
		List<AccountDTO> ar = accountService.getList(accountDTO);
		model.addAttribute("list", ar);
	}
	
	@RequestMapping("accountInsert")
	public String setInsert(HttpSession session , AccountDTO accountDTO) throws Exception {
		MemberDTO memberDTO =(MemberDTO)session.getAttribute("member");
		accountDTO.setId(memberDTO.getId());
		int result = accountService.setInsert(accountDTO);
		return "redirect:./accountList";
	}
}
