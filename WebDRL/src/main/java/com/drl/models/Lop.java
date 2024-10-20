package com.drl.models;

public class Lop {

    private String id;
    private int khoaHocID;
    private String khoaID;
    private String giangVienID;
    private String ten;

    
	public Lop() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getKhoaHocID() {
		return khoaHocID;
	}
	public void setKhoaHocID(int khoaHocID) {
		this.khoaHocID = khoaHocID;
	}
	public String getKhoaID() {
		return khoaID;
	}
	public void setKhoaID(String khoaID) {
		this.khoaID = khoaID;
	}
	public String getGiangVienID() {
		return giangVienID;
	}
	public void setGiangVienID(String giangVienID) {
		this.giangVienID = giangVienID;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Lop(String id, int khoaHocID, String khoaID, String giangVienID, String ten) {
		super();
		this.id = id;
		this.khoaHocID = khoaHocID;
		this.khoaID = khoaID;
		this.giangVienID = giangVienID;
		this.ten = ten;
	}
	
}
