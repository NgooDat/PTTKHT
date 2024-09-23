package com.drl.models;

public class DRL {
	private int id;
    private int diemSV;
    private int diemCS;
    private int diemCV;
    private int status;
    private String sinhVienID;
    private int hkNkID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDiemSV() {
		return diemSV;
	}
	public void setDiemSV(int diemSV) {
		this.diemSV = diemSV;
	}
	public int getDiemCS() {
		return diemCS;
	}
	public void setDiemCS(int diemCS) {
		this.diemCS = diemCS;
	}
	public int getDiemCV() {
		return diemCV;
	}
	public void setDiemCV(int diemCV) {
		this.diemCV = diemCV;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSinhVienID() {
		return sinhVienID;
	}
	public void setSinhVienID(String sinhVienID) {
		this.sinhVienID = sinhVienID;
	}
	public int getHkNkID() {
		return hkNkID;
	}
	public void setHkNkID(int hkNkID) {
		this.hkNkID = hkNkID;
	}
}
