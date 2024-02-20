package com.cafe.vo;

public class MemberVO {
	private String id=null;
	private String pass=null;
	private String tel=null;
	private String email=null;
	private String indate=null;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	
	public void prt() {
		System.out.println(id +"/"+pass+"/"+tel+"/"+email+"/"+indate);
	}

}
