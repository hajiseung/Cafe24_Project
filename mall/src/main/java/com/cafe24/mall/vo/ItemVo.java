package com.cafe24.mall.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ItemVo {
	// item
	private long no;
	private long category_no;
	private String title;
	private String desc;

	// item_detail
	private long amount;
	private long available_amount;
	private long price;
	private boolean non_amount;
	private boolean displaystatus;
	private boolean salestatus;
	private String reg_date;

	// item_photo
	private MultipartFile mainPhoto;
	private MultipartFile subPhoto;
	private String main_photo;
	private List<String> sub_photo;
	private boolean is_sub_photo;

	// item_option
	private List<String> name;

	// item_category
	private String top_category;
	private String low_category;

	public long getNo() {
		return no;
	}

	public long getCategory_no() {
		return category_no;
	}

	public String getTitle() {
		return title;
	}

	public String getDesc() {
		return desc;
	}

	public long getAmount() {
		return amount;
	}

	public long getAvailable_amount() {
		return available_amount;
	}

	public long getPrice() {
		return price;
	}

	public boolean isNon_amount() {
		return non_amount;
	}

	public boolean isDisplaystatus() {
		return displaystatus;
	}

	public boolean isSalestatus() {
		return salestatus;
	}

	public String getReg_date() {
		return reg_date;
	}

	public MultipartFile getMainPhoto() {
		return mainPhoto;
	}

	public MultipartFile getSubPhoto() {
		return subPhoto;
	}

	public String getMain_photo() {
		return main_photo;
	}

	public List<String> getSub_photo() {
		return sub_photo;
	}

	public boolean isIs_sub_photo() {
		return is_sub_photo;
	}

	public List<String> getName() {
		return name;
	}

	public String getTop_category() {
		return top_category;
	}

	public String getLow_category() {
		return low_category;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public void setCategory_no(long category_no) {
		this.category_no = category_no;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public void setAvailable_amount(long available_amount) {
		this.available_amount = available_amount;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public void setNon_amount(boolean non_amount) {
		this.non_amount = non_amount;
	}

	public void setDisplaystatus(boolean displaystatus) {
		this.displaystatus = displaystatus;
	}

	public void setSalestatus(boolean salestatus) {
		this.salestatus = salestatus;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public void setMainPhoto(MultipartFile mainPhoto) {
		this.mainPhoto = mainPhoto;
	}

	public void setSubPhoto(MultipartFile subPhoto) {
		this.subPhoto = subPhoto;
	}

	public void setMain_photo(String main_photo) {
		this.main_photo = main_photo;
	}

	public void setSub_photo(List<String> sub_photo) {
		this.sub_photo = sub_photo;
	}

	public void setIs_sub_photo(boolean is_sub_photo) {
		this.is_sub_photo = is_sub_photo;
	}

	public void setName(List<String> name) {
		this.name = name;
	}

	public void setTop_category(String top_category) {
		this.top_category = top_category;
	}

	public void setLow_category(String low_category) {
		this.low_category = low_category;
	}

	@Override
	public String toString() {
		return "ItemVo [no=" + no + ", category_no=" + category_no + ", title=" + title + ", desc=" + desc + ", amount="
				+ amount + ", available_amount=" + available_amount + ", price=" + price + ", non_amount=" + non_amount
				+ ", displaystatus=" + displaystatus + ", salestatus=" + salestatus + ", reg_date=" + reg_date
				+ ", mainPhoto=" + mainPhoto + ", subPhoto=" + subPhoto + ", main_photo=" + main_photo + ", sub_photo="
				+ sub_photo + ", is_sub_photo=" + is_sub_photo + ", name=" + name + ", top_category=" + top_category
				+ ", low_category=" + low_category + "]";
	}

}
