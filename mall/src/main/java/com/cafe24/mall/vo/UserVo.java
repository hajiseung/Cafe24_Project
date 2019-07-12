package com.cafe24.mall.vo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.cafe24.mall.MemberEnum;

public class UserVo {

	private int no;
	private String id;
	private String email;
	private String pw;
	private String name;
	private String nickname;
	private String tell_ph;
	private String cell_ph;
	private String join_date;
	private int point;
	private int saving; // 적립금
	private String birthday;
	private String account_number; // 계좌번호
	private int massive_mount; // 누적금액
	private MemberEnum grade;
	private boolean email_recv;
	private boolean sms_recv;
	private int purchase_cnt;
	private boolean islogin;

	public int getNo() {
		return no;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getNickname() {
		return nickname;
	}

	public String getTell_ph() {
		return tell_ph;
	}

	public String getCell_ph() {
		return cell_ph;
	}

	public String getJoin_date() {
		return join_date;
	}

	public int getPoint() {
		return point;
	}

	public int getSaving() {
		return saving;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getAccount_number() {
		return account_number;
	}

	public int getMassive_mount() {
		return massive_mount;
	}

	public MemberEnum getGrade() {
		return grade;
	}

	public boolean isEmail_recv() {
		return email_recv;
	}

	public boolean isSms_recv() {
		return sms_recv;
	}

	public int getPurchase_cnt() {
		return purchase_cnt;
	}

	public boolean isIslogin() {
		return islogin;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setTell_ph(String tell_ph) {
		this.tell_ph = tell_ph;
	}

	public void setCell_ph(String cell_ph) {
		this.cell_ph = cell_ph;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public void setSaving(int saving) {
		this.saving = saving;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public void setMassive_mount(int massive_mount) {
		this.massive_mount = massive_mount;
	}

	public void setGrade(MemberEnum grade) {
		this.grade = grade;
	}

	public void setEmail_recv(boolean email_recv) {
		this.email_recv = email_recv;
	}

	public void setSms_recv(boolean sms_recv) {
		this.sms_recv = sms_recv;
	}

	public void setPurchase_cnt(int purchase_cnt) {
		this.purchase_cnt = purchase_cnt;
	}

	public void setIslogin(boolean islogin) {
		this.islogin = islogin;
	}

	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", email=" + email + ", pw=" + pw + ", name=" + name + ", nickname="
				+ nickname + ", tell_ph=" + tell_ph + ", cell_ph=" + cell_ph + ", join_date=" + join_date + ", point="
				+ point + ", saving=" + saving + ", birthday=" + birthday + ", account_number=" + account_number
				+ ", massive_mount=" + massive_mount + ", grade=" + grade + ", email_recv=" + email_recv + ", sms_recv="
				+ sms_recv + ", purchase_cnt=" + purchase_cnt + ", islogin=" + islogin + "]";
	}

}
