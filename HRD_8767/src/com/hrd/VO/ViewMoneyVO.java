package com.hrd.VO;

public class ViewMoneyVO {
	
	int custno = 0;
	String custname = null;
	String custgrade = null;
	int totalprice = 0;
	
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustgrade() {
		return custgrade;
	}
	public void setCustgrade(String custgrade) {
		this.custgrade = custgrade;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

}
