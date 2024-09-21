package com.drl.models;

import java.util.Date;

public class Khoa {
	private String id;
    private String ten;
    private Date ngayTL;
    private int status;
    
	public Khoa() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Date getNgayTL() {
		return ngayTL;
	}
	public void setNgayTL(Date ngayTL) {
		this.ngayTL = ngayTL;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Khoa(String id, String ten, Date ngayTL, int status) {
		super();
		this.id = id;
		this.ten = ten;
		this.ngayTL = ngayTL;
		this.status = status;
	}

}
