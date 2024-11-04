package com.drl.models;

public class HK_NK {
	private int id;
    private String nienKhoa;
    private int hocKy;
    private int xet;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNienKhoa() {
		return nienKhoa;
	}
	public void setNienKhoa(String nienKhoa) {
		this.nienKhoa = nienKhoa;
	}
	public int getHocKy() {
		return hocKy;
	}
	public void setHocKy(int hocKy) {
		this.hocKy = hocKy;
	}
	public int getXet() {
		return xet;
	}
	public void setXet(int xet) {
		this.xet = xet;
	}
	public HK_NK() {
		super();
	}
	public HK_NK(int id, String nienKhoa, int hocKy, int xet) {
		super();
		this.id = id;
		this.nienKhoa = nienKhoa;
		this.hocKy = hocKy;
		this.xet = xet;
	}
	public HK_NK(String nienKhoa, int hocKy, int xet) {
		super();
		this.nienKhoa = nienKhoa;
		this.hocKy = hocKy;
		this.xet = xet;
	}
    
}
