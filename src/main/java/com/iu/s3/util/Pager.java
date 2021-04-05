package com.iu.s3.util;

public class Pager {

	//1. DB에 일정한 개수만큼 조회
	//2. jsp 페이지에 일정한 개수만큼 번호를 출력
	
	private long perPage; //DB에 조회할 개수
	private long perBlock; //jsp에 출력할 번호의 개수
	
	public Pager() {
		this.perPage=10;
		this.perBlock=5;
		this.curPage=1; //기본값 1로 설정
	}
	
	private long curPage; //현재 페이지번호
	
	private long startRow;
	private long lastRow;
	
	//rownum 계산하는 메서드 
	public void makeRow() {
		this.startRow = (this.curPage-1)*perPage+1;
		this.lastRow = this.curPage*this.perPage;
	}
	
	// 페이징 계산 시작
	
	private long totalPage; //전체페이지
	private long startNum;
	private long lastNum;
	private boolean Pre; //앞에 존재하는지 여부확인을 위해
	private boolean next; //다음이 존재하는지
		
	//페이징 계산하는 메서드
	public void makeNum(long totalCount) {
		//1. 전체 글의 갯수로 전체 페이지 갯수 구하기
		this.totalPage = totalCount/this.perPage;
		if(totalCount%this.perPage != 0) {
			totalPage++;
		}
		
		//2. 전체페이지(totalPage)로 전체블록(totalBlock) 수 구하기
		long totalBlock = this.totalPage/this.perBlock;
		if(this.totalPage%this.perBlock!=0) {
			totalBlock++;
		}
		
		//3. 현제페이지(curPage)를 이용해 현재블록(curBlock) 번호 구하기
		long curBlock = this.curPage/this.perBlock;
		if(this.curPage%this.perBlock!=0) {
			curBlock++;
		}
		
		//4. curBlock으로 startNum, lastNum 구하기
		this.startNum = (curBlock-1)*this.perBlock+1;
		this.lastNum = curBlock*this.perBlock;
		
		//5. curBlcok이 totalBlock과 같다면
		if(curBlock==totalBlock) {
			this.lastNum = this.totalPage;
		}
		
		//6. 이전, 다음 유무
		if(curBlock>1) {
			this.Pre = true;
		}
		
		if(curBlock!=totalBlock) {
			this.next = true;
		}
		
	}
	
	//getter, setter
	public long getPerPage() {
		return perPage;
	}

	public void setPerPage(long perPage) {
		this.perPage = perPage;
	}

	public long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(long perBlock) {
		this.perBlock = perBlock;
	}

	public long getCurPage() {
		return curPage;
	}

	public void setCurPage(long curPage) {
		this.curPage = curPage;
	}

	public long getStartRow() {
		return startRow;
	}

	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}

	public long getLastRow() {
		return lastRow;
	}

	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getStartNum() {
		return startNum;
	}

	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}

	public long getLastNum() {
		return lastNum;
	}

	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isPre() {
		return Pre;
	}

	public void setPre(boolean pre) {
		Pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	//검색
	private String kind; //검색할 컬럼명을 담을 변수
	private String search; //검색어를 담을 변수

	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		return search;
	}
	public void setSearch(String search) {
		if(search == null) {
			search="";
		}
		this.search = search;
	}
}
