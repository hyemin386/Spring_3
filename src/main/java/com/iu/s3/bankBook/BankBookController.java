package com.iu.s3.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.util.Pager;

@Controller
@RequestMapping("/bankBook/**")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping("bankBookList")
	public void getList(Model model)throws Exception{
		List<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list", ar);
	}
	
	@RequestMapping(value = "bankBookSelect")
	public ModelAndView getSelect(BankBookDTO bankBookDTO) throws Exception {
		//System.out.println("select 시작");
		//System.out.println(bankBookDTO.getBookNumber());
		ModelAndView mv = new ModelAndView();
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		//System.out.println("service 끝");
		mv.addObject("dto",bankBookDTO);
		mv.setViewName("bankBook/bankBookSelect");
		return mv;
	}
	
	@RequestMapping(value = "bankBookDelete")
	public String setDelete(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("Delete");
		System.out.println(bankBookDTO.getBookNumber());
		int result = bankBookService.setDelete(bankBookDTO);
		System.out.println(result);
		
		return "redirect:./bankBookList";
	}
	
	@RequestMapping("bankBookUpdate")
	public void setUpdate(BankBookDTO bankBookDTO, Model model) throws Exception {
		//bankBookDTO에는 bookNumber한개만 넘어오므로 select를 이용해서 해당 데이터 조회
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		//jsp로 보내기 (model에 담거나 modelAndView 사용 우리는 model위에서 선언함)
		model.addAttribute("dto", bankBookDTO);		
	}
	
	@RequestMapping(value="bankBookUpdate", method=RequestMethod.POST)
	public String setUpdate(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.setUpdate(bankBookDTO);
		return "redirect:./bankBookList";
	}
}
