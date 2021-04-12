package com.iu.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.board.BoardFileDTO;
import com.iu.s3.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("FileDelete")
	public ModelAndView setFileDelete(BoardFileDTO boardFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setFileDelete(boardFileDTO);
		mv.addObject("result",result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	
	@RequestMapping("noticeInsert")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "notice");
		return mv;
	}
	
	@RequestMapping(value = "noticeInsert", method = RequestMethod.POST)
	public String setInsert(BoardDTO boardDTO, Model model, MultipartFile [] files)throws Exception{
		
		int result = noticeService.setInsert(boardDTO, files);
		
		
		String message="등록 실패";
		
		if(result>0) {
			message="등록 성공";
		}
		model.addAttribute("msg", message);
		model.addAttribute("path", "./noticeList");
		
		return "common/commonResult";
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
	
	@PostMapping("noticeDelete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setDelete(boardDTO); //성공하면 0보다 큰 숫자 실패하면 0이나 작은 숫자
		
		String message="삭제 실패";
		String path="./noticeList";
		
		if(result>0) {
			message="삭제 성공";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", path);
		
		mv.setViewName("common/commonResult");
		
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
	
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@PostMapping("noticeUpdate")
	public ModelAndView setUpdate (BoardDTO boardDTO, ModelAndView mv, MultipartFile [] files) throws Exception {
		int result = noticeService.setUpdate(boardDTO, files);
		//성공하면 list로 이동
		if(result>0) {
			mv.setViewName("redirect:./noticeList");
		} else { //실패하면 alert창으로 수정실패 띄우고 list로 이동
			mv.addObject("msg", "수정 실패");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/commonResult");
		}
		
		return mv;
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
