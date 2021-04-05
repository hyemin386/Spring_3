package com.iu.s3.util;

public class Pager_backUp {

	private int perPage = 10;
	private int perBlock = 5;

	private long curPage;
	private long startRow;
	private long lastRow;

	private long startNum;
	private long lastNum;

	private boolean pre; //목록의 이전 블록이 있으면 true 없으면 false
	private boolean next; //목록의 다음 블록이 있으면 true 없으면 false

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
	public boolean isPre() {
		return pre;
	}
	public void setPre(boolean pre) {
		this.pre = pre;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
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
	public long getCurPage() {
		if(this.curPage<1) {
			this.curPage=1;
		}
		return curPage;
	}
	public void setCurPage(long curPage) {
		if(curPage<1) {
			curPage=1;
		}
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

	public void makeRow() {
		long startRow = (this.getCurPage()-1)*perPage+1; //몇번째 페이지를 볼것인지
		long lastRow = this.getCurPage()*perPage;

		this.setStartRow(startRow);
		this.setLastRow(lastRow);
	}

	public void makeNum(long totalCount) {
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
		long curBlock = this.getCurPage()/perBlock;
		if(this.getCurPage()%perBlock != 0) {
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
		//이전
		if(curBlock != 1) { //현재블록이 1과같지 않다면
			this.setPre(true);
		}
		//다음
		if(curBlock != totalBlock) {
			this.setNext(true);
		}

		this.setStartNum(startNum);
		this.setLastNum(lastNum);
	}
}
