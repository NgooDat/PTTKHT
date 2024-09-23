package com.drl.models;

public class Diem_CT {
	private int id;
	private int diem;
	private String capDG;
	private int DRLID;
	private int CT_TCID;
	
	
	public Diem_CT() {
		super();
	}
	
	public Diem_CT(int id, int diem, String capDG, int dRLID, int cT_TCID) {
		super();
		this.id = id;
		this.diem = diem;
		this.capDG = capDG;
		DRLID = dRLID;
		CT_TCID = cT_TCID;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDiem() {
		return diem;
	}
	public void setDiem(int diem) {
		this.diem = diem;
	}
	public String getCapDG() {
		return capDG;
	}
	public void setCapDG(String capDG) {
		this.capDG = capDG;
	}
	public int getDRLID() {
		return DRLID;
	}
	public void setDRLID(int dRLID) {
		DRLID = dRLID;
	}
	public int getCT_TCID() {
		return CT_TCID;
	}
	public void setCT_TCID(int cT_TCID) {
		CT_TCID = cT_TCID;
	}
	
	
}
