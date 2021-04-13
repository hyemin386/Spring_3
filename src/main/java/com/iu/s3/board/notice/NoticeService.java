package com.iu.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.board.BoardFileDTO;
import com.iu.s3.board.BoardService;
import com.iu.s3.util.FileManager;
import com.iu.s3.util.Pager;
import com.iu.s3.util.Pager_backUp;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private HttpSession session;
	
	public boolean setSummerFileDelete(String FileName) throws Exception {
		boolean result = fileManager.delete("notice", FileName, session);
		return result;
	}
	
	public String setSummerFileUpload(MultipartFile file) throws Exception {
		//첨부파일이 아니므로 db에 저장 안함!
		String fileName = fileManager.save("notice", file, session);
		return fileName;
	}
	
	public List<BoardDTO> getList(Pager pager) throws Exception {
		//startRow, lastRow 계산하는 메서드 호출 
		pager.makeRow();
		//페이징 계산 메서드 호출
		long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		
		long num =noticeDAO.getNum();
		
		boardDTO.setNum(num);
		
		int result = noticeDAO.setInsert(boardDTO);
		
		//글번호 찾기
		
		for(MultipartFile mf : files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			String fileName= fileManager.save("notice", mf, session);
			
			boardFileDTO.setNum(num);
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOrigineName(mf.getOriginalFilename());
			
			noticeDAO.setFileInsert(boardFileDTO);
		}
		
		return result;//noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		//1. 파일들을 HDD에 저장
		for(MultipartFile multipartFile : files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO(); //정보저장
			//HDD에 저장
			String fileName = fileManager.save("notice", multipartFile, session);
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOrigineName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			//2. DB에 insert
			noticeDAO.setFileInsert(boardFileDTO);
		}
		//3. 글 수정		
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}
	
	public int setFileDelete(BoardFileDTO boardFileDTO) throws Exception {
		//1. 조회
		boardFileDTO= noticeDAO.getFileSelect(boardFileDTO);
		//2. 테이블 삭제
		int result = noticeDAO.setFileDelete(boardFileDTO);
		//3. HDD 삭제
		if(result>0) {
			fileManager.delete("notice", boardFileDTO.getFileName(), session);
		}
		
		return result;
	}
}
