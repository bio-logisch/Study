package com.cafe.vo;

public class BBSVO {
	
	private String bbs_flag=null;
	private String bbs_num=null;
	private String bbs_wr=null;
	private String bbs_pass=null;
	private String bbs_title=null;
	private String bbs_comment=null;
	private String bbs_date=null;
	private int bbs_cnt=0;
	private String[] files=null;
	
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	public int getBbs_cnt() {
		return bbs_cnt;
	}
	public void setBbs_cnt(int bbs_cnt) {
		this.bbs_cnt = bbs_cnt;
	}
	public String getBbs_flag() {
		return bbs_flag;
	}
	public void setBbs_flag(String bbs_flag) {
		this.bbs_flag = bbs_flag;
	}
	public String getBbs_num() {
		return bbs_num;
	}
	public void setBbs_num(String bbs_num) {
		this.bbs_num = bbs_num;
	}
	public String getBbs_wr() {
		return bbs_wr;
	}
	public void setBbs_wr(String bbs_wr) {
		this.bbs_wr = bbs_wr;
	}
	public String getBbs_pass() {
		return bbs_pass;
	}
	public void setBbs_pass(String bbs_pass) {
		this.bbs_pass = bbs_pass;
	}
	public String getBbs_title() {
		return bbs_title;
	}
	public void setBbs_title(String bbs_title) {
		this.bbs_title = bbs_title;
	}
	public String getBbs_comment() {
		return bbs_comment;
	}
	public void setBbs_comment(String bbs_comment) {
		this.bbs_comment = bbs_comment;
	}
	public String getBbs_date() {
		return bbs_date;
	}
	public void setBbs_date(String bbs_date) {
		this.bbs_date = bbs_date;
	}
	
	

}
