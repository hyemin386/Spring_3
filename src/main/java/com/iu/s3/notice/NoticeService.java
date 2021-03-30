package com.iu.s3.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.util.Pager;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getList(Pager pager) throws Exception {
		int perPage=10; //한 페이지당 보여줄 글의 개수
		int perBlock = 5; //한 블럭당 보여줄 숫자의 개수
		
		long startRow = (pager.getCurPage()-1)*perPage+1; //몇번째 페이지를 볼것인지
		long lastRow = pager.getCurPage()*perPage;
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		
		//1. totalCount
		long totalCount=noticeDAO.getTotalCount(pager); //총 글 수 가져오기
		//2. totalPage
		long totalPage = totalCount/perPage;
		if(totalCount%perPage != 0) {
			totalPage++;
		}
		
		//3. totalBlock 
		long totalBlock = totalPage/perBlock;
		if(totalPage%5 !=0 ) {
			totalBlock++;
		}
		
		//4. curBlock
		long curBlock = pager.getCurPage()/perBlock;
		if(pager.getCurPage()%perBlock != 0) {
			curBlock++;
		}
		
		//5. startNum, lasgNum
		long startNum = (curBlock-1)*perBlock+1;
		long lastNum = curBlock*perBlock;
		
		//6. 현재블록이(curBlock) 마지막 블록(totalBlock)일 때
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}
		
		//7. 이전, 다음 블록의 존재여부 판단
		if(curBlock != 1) { //현재블록이 1과같지 않다면
			pager.setPre(true);
		}
		
		if(curBlock != totalBlock) {
			pager.setNext(true);
		}
		
		pager.setStartNum(startNum);
		pager.setLastNum(lastNum);
		
		System.out.println("TotalPage: "+totalPage); //콘솔창 확인용

		return noticeDAO.getList(pager);
	}
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.getSelect(noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.setDelete(noticeDTO);
	}
	
	public int setUpdate(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.setUpdate(noticeDTO);
	}
	
	public int setInsert(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.setInsert(noticeDTO);
	}
}
