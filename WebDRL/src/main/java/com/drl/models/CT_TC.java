package com.drl.models;

public class CT_TC {
	private int id;
    private String noiDung;
    private int diemTD;
    private int tieuChiID;
    
	public CT_TC() {
		super();
	}
	
	public CT_TC(int id, String noiDung, int diemTD, int tieuChiID) {
		super();
		this.id = id;
		this.noiDung = noiDung;
		this.diemTD = diemTD;

		this.tieuChiID = tieuChiID;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public int getDiemTD() {
		return diemTD;
	}
	public void setDiemTD(int diemTD) {
		this.diemTD = diemTD;
	}
	public int getTieuChiID() {
		return tieuChiID;
	}
	public void setTieuChiID(int tieuChiID) {
		this.tieuChiID = tieuChiID;
	}
    
}
