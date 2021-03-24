package com.iu.s3.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankBook/**")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping("bankBookList")
	public void getList(Model model) throws Exception {
		List<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list",ar);
	}
	
	@RequestMapping(value = "bankBookSelect")
	public ModelAndView getSelect(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		mv.addObject("dto",bankBookDTO);
		mv.setViewName("bankBook/bankBookSelect");
		return mv;
	}
}
