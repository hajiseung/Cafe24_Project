package com.cafe24.mall.vo;

public class ListVo {
	private int item_no;
	private String photo;
	private String title;
	private int item_count;
	private int accmulate;
	private int total_item_price;

	public int getItem_no() {
		return item_no;
	}

	public String getPhoto() {
		return photo;
	}

	public String getTitle() {
		return title;
	}

	public int getItem_count() {
		return item_count;
	}

	public int getAccmulate() {
		return accmulate;
	}

	public int getTotal_item_price() {
		return total_item_price;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}

	public void setAccmulate(int accmulate) {
		this.accmulate = accmulate;
	}

	public void setTotal_item_price(int total_item_price) {
		this.total_item_price = total_item_price;
	}

	@Override
	public String toString() {
		return "ListVo [item_no=" + item_no + ", photo=" + photo + ", title=" + title + ", item_count=" + item_count
				+ ", accmulate=" + accmulate + ", total_item_price=" + total_item_price + "]";
	}

}
