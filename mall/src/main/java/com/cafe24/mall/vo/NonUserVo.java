package com.cafe24.mall.vo;

public class NonUserVo {

	private int no;
	private String account;
	private String mac_addr;

	public int getNo() {
		return no;
	}

	public String getAccount() {
		return account;
	}

	public String getMac_addr() {
		return mac_addr;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setMac_addr(String mac_addr) {
		this.mac_addr = mac_addr;
	}

	@Override
	public String toString() {
		return "NonUserVo [no=" + no + ", account=" + account + ", mac_addr=" + mac_addr + "]";
	}
}
