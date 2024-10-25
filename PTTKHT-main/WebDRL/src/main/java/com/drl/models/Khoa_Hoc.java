package com.drl.models;

public class Khoa_Hoc {
	private int id;
    private int namBD;
    private int namKT;
    
	public Khoa_Hoc() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNamBD() {
		return namBD;
	}
	public void setNamBD(int namBD) {
		this.namBD = namBD;
	}
	public int getNamKT() {
		return namKT;
	}
	public void setNamKT(int namKT) {
		this.namKT = namKT;
	}
	public Khoa_Hoc(int id, int namBD, int namKT) {
		super();
		this.id = id;
		this.namBD = namBD;
		this.namKT = namKT;
	}
	public Khoa_Hoc(int namBD, int namKT) {
		super();
		this.namBD = namBD;
		this.namKT = namKT;
	}
	
    
}
