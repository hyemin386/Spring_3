package com.iu.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("noticeInsert")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "notice");
		return mv;
	}
	
	@RequestMapping("noticeList")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<BoardDTO> ar = noticeService.getList(pager);
		
		//List<NoticeDTO> ar = noticeService.getList(curPage);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		mv.addObject("board","notice");
		mv.addObject("pager", pager);
		return mv;
	}
	
	/*
	 * @RequestMapping("noticeSelect") public ModelAndView getSelect(BoardDTO
	 * boardDTO) throws Exception { ModelAndView modelAndView = new ModelAndView();
	 * boardDTO = noticeService.getSelect(boardDTO);
	 * modelAndView.addObject("dto",boardDTO);
	 * modelAndView.setViewName("board/boardList"); return modelAndView; }
	 */
	
	/*
	 * @RequestMapping("noticeDelete") public String setDelete(NoticeDTO noticeDTO)
	 * throws Exception { int result = noticeService.setDelete(noticeDTO); return
	 * "redirect:./noticeList"; }
	 */
	
	@RequestMapping("noticeUpdate")
	public void setUpdate(NoticeDTO noticeDTO, Model model) throws Exception {
		//noticeDTO = noticeService.getSelect(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String setUpdate (NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.setUpdate(noticeDTO);
		return "redirect:./noticeList";
	}
	
	
	@RequestMapping(value = "noticeInsert" , method = RequestMethod.POST)
	public String setInsert(BoardDTO boardDTO, Model model) throws Exception {
		int result = noticeService.setInsert(boardDTO); //notice로 받아도 상관은 없음!
		
		String message ="등록실패";
		
		if(result>0) {
			message="등록성공";
		}
		model.addAttribute("msg",message);
		model.addAttribute("path", "./noticeList");
		return "common/commonResult";
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO= noticeService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.addObject("board","notice");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
}
