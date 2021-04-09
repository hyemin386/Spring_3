package com.iu.s3.board.comments;

import java.sql.Date;

public class CommentsDTO {
	
	private long commentNum;
	private long num;
	private String name;
	private String contents;
	private Date regDate;
	
	public long getCommentNum() {
		return commentNum;
	}
	public void setCommentsNum(long commentNum) {
		this.commentNum = commentNum;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
